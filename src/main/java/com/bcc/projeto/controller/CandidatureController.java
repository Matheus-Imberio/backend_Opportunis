package com.bcc.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcc.projeto.entities.Candidate;
import com.bcc.projeto.entities.Candidature;
import com.bcc.projeto.entities.Vacancy;
import com.bcc.projeto.exceptions.ResourceNotFoundException;
import com.bcc.projeto.repositories.CandidateRepository;
import com.bcc.projeto.repositories.VacancyRepository;
import com.bcc.projeto.services.CandidatureService;

@RestController
@RequestMapping("/candidatures")
public class CandidatureController {

	@Autowired
	private CandidatureService candidatureService;
	
	@Autowired
	private CandidateRepository candidateRepo;
	
	@Autowired
	private VacancyRepository vacancyRepo;
	
	@PostMapping(value = "{candidateId}/{vacancyId}")
	public ResponseEntity<Candidature> insert(@PathVariable Long candidateId, @PathVariable Long vacancyId) {
		Candidate candidate = candidateRepo.findById(candidateId).orElseThrow(() -> new ResourceNotFoundException(candidateId));
		Vacancy vacancy = vacancyRepo.findById(vacancyId).orElseThrow(() -> new ResourceNotFoundException(vacancyId));
		
		Candidature c = new Candidature(null, candidate, vacancy);
		candidatureService.insert(c);
		return null;
	}
}
