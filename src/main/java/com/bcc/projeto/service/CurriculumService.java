package com.bcc.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcc.projeto.entities.Curriculum;
import com.bcc.projeto.repositories.CurriculumRepository;

@Service
public class CurriculumService {
	
	@Autowired
	private CurriculumRepository curriculumRepo;
	
	
	public void save(Curriculum curriculum) {
		curriculumRepo.save(curriculum);
	}
	
	public List<Curriculum> findAll() {
		return curriculumRepo.findAll();
	}
}
