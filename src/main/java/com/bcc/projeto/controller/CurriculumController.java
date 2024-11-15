package com.bcc.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcc.projeto.entities.Curriculum;
import com.bcc.projeto.service.CurriculumService;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {

	@Autowired
	private CurriculumService curriculumService;
	
	@PostMapping
	public ResponseEntity<Curriculum> save(@RequestBody Curriculum curriculum) {
		Curriculum savedCurriculum = curriculumService.save(curriculum);
		return ResponseEntity.ok(savedCurriculum);
	}
	
	// TODO find by id
	// TODO update
	// TODO delete
}
