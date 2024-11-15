package com.bcc.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcc.projeto.entities.Curriculum;
import com.bcc.projeto.repositories.CurriculumRepository;

@Service
public class CurriculumService {
	
	@Autowired
	private CurriculumRepository curriculumRepo;
	
	
	public Curriculum save(Curriculum curriculum) {
		return curriculumRepo.save(curriculum);
	}
	
	// TODO find by id
	// TODO update
	// TODO delete
}
