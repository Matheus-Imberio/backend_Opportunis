package com.bcc.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcc.projeto.entities.Candidate;
import com.bcc.projeto.entities.Curriculum;
import com.bcc.projeto.repositories.CandidateRepository;
import com.bcc.projeto.repositories.CurriculumRepository;

@Service
public class CurriculumService {
	
	@Autowired
	private CurriculumRepository curriculumRepo;
	
	@Autowired
	private CandidateRepository candidateRepo;
	
	public Curriculum save(Curriculum curriculum) {
		return curriculumRepo.save(curriculum);
	}
	
	public Curriculum saveIntoCandidateById(Long candidateId, Curriculum curriculum) {
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
	// TODO delete
}
