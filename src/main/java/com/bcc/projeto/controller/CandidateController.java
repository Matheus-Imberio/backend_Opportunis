package com.bcc.projeto.controller;

import java.net.URI;
import java.util.List;

import com.bcc.projeto.services.CandidateService;
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

	@Autowired
	private CandidateService service;

	@GetMapping
	public ResponseEntity<List<Candidate>> findAll() {
		List<Candidate> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Candidate> FindById(@PathVariable Long id) {
		Candidate obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Candidate> insert(@RequestBody Candidate obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public  ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Candidate> update(@PathVariable Long id,@RequestBody Candidate obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}