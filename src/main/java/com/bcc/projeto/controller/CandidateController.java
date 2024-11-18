package com.bcc.projeto.controller;

import java.awt.print.Pageable;
import java.net.URI;

import com.bcc.projeto.entities.enums.Roles;
import com.bcc.projeto.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bcc.projeto.entities.Candidate;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

	@Autowired
	private CandidateService service;

	public ResponseEntity<Page<Candidate>> findAll(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "4") Integer linesPerPage, @RequestParam(defaultValue = "ASC") String direction, @RequestParam(defaultValue = "username") String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		return ResponseEntity.ok().body(service.findAll((Pageable) pageRequest));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Candidate> FindById(@PathVariable Long id) {
		Candidate obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Candidate> insert(@RequestBody Candidate obj) {
		obj.setRole(Roles.CANDIDATE);
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