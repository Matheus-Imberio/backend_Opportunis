package com.bcc.projeto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
	@GetMapping(value = "/{id}")
	public ResponseEntity<Candidate> findById(@PathVariable Long id) {
		Optional<Candidate> obj = candidateRepo.findById(id);
		if (obj.isPresent()) {
			return ResponseEntity.ok(obj.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public ResponseEntity<Candidate> insert(@RequestBody Candidate obj) {
		obj = candidateRepo.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (candidateRepo.existsById(id)) {
			candidateRepo.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Candidate> update(@PathVariable Long id, @RequestBody Candidate obj) {
		if (!candidateRepo.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		obj.setId(id);
		Candidate updatedCandidate = candidateRepo.save(obj);
		return ResponseEntity.ok(updatedCandidate);
	}
}