package com.bcc.projeto.controller;

import java.util.List;

import com.bcc.projeto.services.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcc.projeto.entities.Candidature;
import com.bcc.projeto.entities.pk.CandidaturePk;
import com.bcc.projeto.services.CandidatureService;

@RestController
@RequestMapping("/candidatures")
public class CandidatureController {

	@Autowired
	private CandidatureService candidatureService;

	@Autowired
	private VacancyService vacancyService;


	@PostMapping
	public ResponseEntity<Candidature> save(@RequestBody Candidature candidature) {
		candidature = candidatureService.insert(candidature);
		vacancyService.updateClicks(candidature.getVacancy().getId());
		return ResponseEntity.status(HttpStatus.CREATED).body(candidature);
	}
	
	// Acho que esse método deveria estar no controller de candidato!
	@GetMapping(value = "/candidate/{id}")
	public ResponseEntity<List<Candidature>> findAllByCandidateId(@PathVariable Long id) {
		List<Candidature> candidatures = candidatureService.findAllByCandidateId(id);
		return ResponseEntity.ok().body(candidatures);
	}
	
	@GetMapping(value = "/vacancy/{id}")
	public ResponseEntity<List<Candidature>> findAllByVacancyId(@PathVariable Long id) {
		List<Candidature> candidatures = candidatureService.findAllByVacancyId(id);
		return ResponseEntity.ok().body(candidatures);
	}
	
	@GetMapping
	public ResponseEntity<Candidature> findById(@RequestBody CandidaturePk id) {
		Candidature body = candidatureService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

		@DeleteMapping(value = "/{candidateId}/{vacancyId}")
	public ResponseEntity<Void> delete(@PathVariable Long candidateId, @PathVariable Long vacancyId) {
		candidatureService.delete(candidateId, vacancyId);
		return ResponseEntity.noContent().build();
	}
}
