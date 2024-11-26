package com.bcc.projeto.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bcc.projeto.entities.Professional;
import com.bcc.projeto.services.ProfessionalService;

@RestController
public class ProfessionalController {

	@Autowired
	private ProfessionalService professionalService;
	
	@GetMapping(value = "/professional-experiences/curriculum/{curriculumId}")
	public ResponseEntity<List<Professional>> findAllbyCurriculumId(@PathVariable Long curriculumId) {
		List<Professional> body = professionalService.findAllByCurriculumId(curriculumId);
		return ResponseEntity.ok().body(body);
	}
	
	@PostMapping(value = "/professional-experiences/curriculum/{curriculumId}")
	public ResponseEntity<Professional> insertIntoCurriculumById(@PathVariable Long curriculumId, @RequestBody Professional professional) {
		Professional body = professionalService.insertIntoCurriculumById(curriculumId, professional);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(body.getId()).toUri();
		return ResponseEntity.created(uri).body(body);
	}
	
	// TODO insert
	// TODO inserIntoCurriculumById
	// TODO update
	// TODO delete
}
