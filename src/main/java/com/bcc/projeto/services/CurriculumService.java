package com.bcc.projeto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcc.projeto.entities.AcademicBackground;
import com.bcc.projeto.entities.Candidate;
import com.bcc.projeto.entities.Course;
import com.bcc.projeto.entities.Curriculum;
import com.bcc.projeto.entities.Language;
import com.bcc.projeto.entities.Professional;
import com.bcc.projeto.entities.Skill;
import com.bcc.projeto.repositories.AcademicBackgroundRepository;
import com.bcc.projeto.repositories.CandidateRepository;
import com.bcc.projeto.repositories.CourseRepository;
import com.bcc.projeto.repositories.CurriculumRepository;
import com.bcc.projeto.repositories.LanguageRepository;
import com.bcc.projeto.repositories.ProfessionalRepository;
import com.bcc.projeto.repositories.SkillRepository;

@Service
public class CurriculumService {
	
	@Autowired
	private CurriculumRepository curriculumRepo;
	
	@Autowired
	private CandidateRepository candidateRepo;
	
	@Autowired
	private ProfessionalRepository professionalRepo;
	
	@Autowired
	private AcademicBackgroundRepository academicBackgroundRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private SkillRepository skillRepo;
	
	@Autowired
	private LanguageRepository languageRepo;
	
	@Transactional
	public Curriculum save(Curriculum curriculum) {
		saveCompositeModels(curriculum);
		return curriculumRepo.save(curriculum);
	}
	
	@Transactional
	public Curriculum saveIntoCandidateById(Long candidateId, Curriculum curriculum) {
		saveCompositeModels(curriculum);
		Candidate candidate = candidateRepo.findById(candidateId).orElseThrow();
		curriculum.setCandidate(candidate);
		return curriculumRepo.save(curriculum);
	}
	
	public Curriculum findById(Long id) {
		return curriculumRepo.findById(id);
	}
	
	public List<Curriculum> findAllByCandidateId(Long candidateId) {
		return curriculumRepo.findAllByCandidateId(candidateId);
	}
	
	public Curriculum update(Long id, Curriculum curriculum) {
		Curriculum obj = curriculumRepo.findById(id);
		
		obj.setAdditionalInfo(curriculum.getAdditionalInfo());
		obj.setProfessionalGoal(curriculum.getProfessionalGoal());
		
		return curriculumRepo.update(obj);
	}
	
	public void delete(Long id) {
		curriculumRepo.delete(id);
	}
	
	private void saveCompositeModels(Curriculum curriculum) {
		if (curriculum.getProfessionalExperiences().isEmpty() == false) {
			for (Professional obj : curriculum.getProfessionalExperiences())
				obj.setCurriculum(curriculum);
			professionalRepo.saveAll(curriculum.getProfessionalExperiences());
		}
		
		if (!curriculum.getAcademicBackgroundExperience().isEmpty()) {
			for (AcademicBackground obj : curriculum.getAcademicBackgroundExperience())
				obj.setCurriculum(curriculum);
			academicBackgroundRepo.saveAll(curriculum.getAcademicBackgroundExperience());
		}
		
		if (curriculum.getCoursesExperiences().isEmpty() == false) {
			for (Course obj : curriculum.getCoursesExperiences())
				obj.setCurriculum(curriculum);
			courseRepo.saveAll(curriculum.getCoursesExperiences());
		}
		
		if (curriculum.getSkills().isEmpty() == false) {
			for (Skill obj : curriculum.getSkills())
				obj.setCurriculum(curriculum);
			skillRepo.saveAll(curriculum.getSkills());
		}
		
		if (curriculum.getLanguages().isEmpty() == false) {
			for (Language obj : curriculum.getLanguages())
				obj.setCurriculum(curriculum);
			languageRepo.saveAll(curriculum.getLanguages());
		}
	}
}
