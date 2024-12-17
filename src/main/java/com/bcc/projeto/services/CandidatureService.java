package com.bcc.projeto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcc.projeto.entities.Candidature;
import com.bcc.projeto.repositories.CandidatureRepository;

@Service
public class CandidatureService {

	@Autowired
	private CandidatureRepository candidatureRepo;
	
	@Transactional
	public Candidature insert(Candidature candidature) {
		return candidatureRepo.save(candidature);
	}
}
