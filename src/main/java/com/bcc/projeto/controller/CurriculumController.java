package com.bcc.projeto.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bcc.projeto.entities.Curriculum;
import com.bcc.projeto.services.CurriculumService;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {

	private final CurriculumService curriculumService;

	@Autowired
	public CurriculumController(CurriculumService curriculumService) {
		this.curriculumService = curriculumService;
	}

	@PostMapping
	public ResponseEntity<Curriculum> save(@RequestBody Curriculum curriculum) {
		Curriculum savedCurriculum = curriculumService.save(curriculum);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCurriculum.getId()).toUri();
		return ResponseEntity.created(uri).body(savedCurriculum);
	}
	
	@PostMapping(value = "/candidate/{candidateId}")
	public ResponseEntity<Curriculum> saveIntoCandidateById(@PathVariable Long candidateId, @RequestBody Curriculum curriculum) {
		Curriculum savedCurriculum = curriculumService.saveIntoCandidateById(candidateId, curriculum);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCurriculum.getId()).toUri();
		return ResponseEntity.created(uri).body(savedCurriculum);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Curriculum> findById(@PathVariable Long id) {
		return ResponseEntity.ok(curriculumService.findById(id));
	}
	
	@GetMapping(value = "/candidate/{candidateId}")
	public ResponseEntity<List<Curriculum>> findAllByCandidateId(@PathVariable Long candidateId) {
		List<Curriculum> curriculumns = curriculumService.findAllByCandidateId(candidateId);
		return ResponseEntity.ok().body(curriculumns);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Curriculum> update(@PathVariable Long id, @RequestBody Curriculum curriculum) {
		Curriculum obj = curriculumService.update(id, curriculum);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Curriculum> delete(@PathVariable Long id) {
		curriculumService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
