package com.bcc.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcc.projeto.entities.Candidature;
import com.bcc.projeto.services.CandidatureService;

@RestController
@RequestMapping("/candidatures")
public class CandidatureController {

	@Autowired
	private CandidatureService candidatureService;	
	
	@PostMapping
	public ResponseEntity<Candidature> save(@RequestBody Candidature candidature) {
		candidature = candidatureService.insert(candidature);
		return ResponseEntity.status(HttpStatus.CREATED).body(candidature);
	}
	
	@GetMapping(value = "/candidate/{id}")
	public ResponseEntity<List<Candidature>> findAllByCandidateId(@PathVariable Long id) {
		List<Candidature> candidatures = candidatureService.findAllByCandidateId(id);
		return ResponseEntity.ok().body(candidatures);
	}
}
