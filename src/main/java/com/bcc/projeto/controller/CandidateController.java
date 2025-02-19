package com.bcc.projeto.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bcc.projeto.entities.Candidate;
import com.bcc.projeto.entities.enums.Roles;
import com.bcc.projeto.services.CandidateService;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

	private final CandidateService service;

	@Autowired
	public CandidateController(CandidateService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<Page<Candidate>> findAll(
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "4") Integer linesPerPage,
			@RequestParam(defaultValue = "ASC") String direction,
			@RequestParam(defaultValue = "professionalExperienceQtd") String orderBy) {
		try {
			Sort.Direction sortDirection = Sort.Direction.fromString(direction.toUpperCase());
			Pageable pageRequest = PageRequest.of(page, linesPerPage, sortDirection, orderBy);

			return ResponseEntity.ok().body(service.findAll(pageRequest));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().build();
		}
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