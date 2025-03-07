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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bcc.projeto.entities.Curriculum;
import com.bcc.projeto.services.CurriculumService;

@RestController
public class CurriculumController {

	@Autowired
	private CurriculumService curriculumService;

	@PostMapping(value = "/candidates/curriculumns")
	public ResponseEntity<Curriculum> save(@RequestBody Curriculum curriculum) {
		Curriculum savedCurriculum = curriculumService.save(curriculum);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCurriculum.getId()).toUri();
		return ResponseEntity.created(uri).body(savedCurriculum);
	}
	
	@PostMapping(value = "/candidates/{candidateId}/curriculumns")
	public ResponseEntity<Curriculum> saveIntoCandidateById(@PathVariable Long candidateId, @RequestBody Curriculum curriculum) {
		if (curriculum.getId() != -1) {
			curriculumService.delete(curriculum.getId());
		}
			curriculum.setId(null);
		Curriculum savedCurriculum = curriculumService.saveIntoCandidateById(candidateId, curriculum);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCurriculum.getId()).toUri();
		return ResponseEntity.created(uri).body(savedCurriculum);
	}
	
	@GetMapping(value = "/candidates/curriculumns/{id}")
	public ResponseEntity<Curriculum> findById(@PathVariable Long id) {
		return ResponseEntity.ok(curriculumService.findById(id));
	}
	
	@GetMapping(value = "/candidates/{candidateId}/curriculumns")
	public ResponseEntity<List<Curriculum>> findAllByCandidateId(@PathVariable Long candidateId) {
		List<Curriculum> curriculumns = curriculumService.findAllByCandidateId(candidateId);
		return ResponseEntity.ok().body(curriculumns);
	}
	
	@PutMapping(value = "/candidates/curriculumns/{id}")
	public ResponseEntity<Curriculum> update(@PathVariable Long id, @RequestBody Curriculum curriculum) {
		Curriculum obj = curriculumService.update(id, curriculum);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/candidates/curriculumns/{id}")
	public ResponseEntity<Curriculum> delete(@PathVariable Long id) {
		curriculumService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
