package com.bcc.projeto.service;

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
	
	// TODO update
	// TODO delete
}
