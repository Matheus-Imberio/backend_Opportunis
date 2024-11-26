package com.bcc.projeto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcc.projeto.entities.Curriculum;
import com.bcc.projeto.entities.Professional;
import com.bcc.projeto.repositories.CurriculumRepository;
import com.bcc.projeto.repositories.ProfessionalRepository;

@Service
public class ProfessionalService {
	
	@Autowired
	private ProfessionalRepository professionalRepo;
	
	@Autowired
	private CurriculumRepository curriculumRepo;
	
	@Transactional
	public List<Professional> findAllByCurriculumId(Long curriculumId) {
		Curriculum curr = curriculumRepo.findById(curriculumId);
		List<Professional> professionalList = professionalRepo.findByCurriculum(curr);
		System.out.println(professionalList.toString());
		return professionalList;
	}
	
	@Transactional
	public Professional insertIntoCurriculumById(Long curriculumId, Professional professional) {
		Curriculum curr = curriculumRepo.findById(curriculumId);
		professional.setCurriculum(curr);
		Professional body = professionalRepo.save(professional);
		return body;
	}
	
	// TODO insert
	// TODO inserIntoCurriculumById
	// TODO update
	// TODO delete
}
