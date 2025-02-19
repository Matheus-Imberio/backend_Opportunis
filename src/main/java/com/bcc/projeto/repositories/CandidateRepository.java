package com.bcc.projeto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcc.projeto.entities.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	
    Optional<Candidate> findByEmailEquals(String email);
    Optional<Candidate> findBytelephone(String telephone);
    Optional<Candidate> findBycpf(String cpf);
}
