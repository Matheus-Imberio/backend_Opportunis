package com.bcc.projeto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcc.projeto.entities.Candidature;
import com.bcc.projeto.exceptions.ResourceNotFoundException;
import com.bcc.projeto.repositories.CandidateRepository;
import com.bcc.projeto.repositories.CandidatureRepository;

@Service
public class CandidatureService {

	@Autowired
	private CandidatureRepository candidatureRepo;
	
	@Autowired
	private CandidateRepository candidateRepo;
	
	@Transactional
	public Candidature insert(Candidature candidature) {
		return candidatureRepo.save(candidature);
	}
	
	public List<Candidature> findAllByCandidateId(Long id) {
		candidateRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));		
		return candidatureRepo.findAllByCandidateId(id);
	}	
}
