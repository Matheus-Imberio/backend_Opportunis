package com.bcc.projeto.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bcc.projeto.entities.Candidate;
import com.bcc.projeto.repositories.CandidateRepository;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

	// TODO é necessario criar a camada de Service
	@Autowired
	private CandidateRepository candidateRepo;
	
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Candidate>> findAll() {
		List<Candidate> allCandidates = candidateRepo.findAll();
		return new ResponseEntity<List<Candidate>>(allCandidates, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Candidate> insert(@RequestBody Candidate obj) {
		obj = candidateRepo.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}