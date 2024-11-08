package com.bcc.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcc.projeto.entities.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
