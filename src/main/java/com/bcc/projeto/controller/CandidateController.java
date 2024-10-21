package com.bcc.projeto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcc.projeto.entities.Candidate;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Candidate>> findAll() {
		// fake candidates
		Candidate c1 = new Candidate(1L, "ruan", "ruan@gmail.com", "44988887777", "123", "11122233344", 'M', null, null);
		Candidate c2 = new Candidate(2L, "matheus", "matheus@gmail.com", "44900001111", "987", "00011122233", 'M', null, null);
		Candidate c3 = new Candidate(3L, "victhor", "victhor@gmail.com", "44911112222", "321", "12332112312", 'M', null, null);
		
		List<Candidate> allCandidates = List.of(c1, c2, c3);
		return new ResponseEntity<List<Candidate>>(allCandidates, HttpStatus.OK);
	}
}