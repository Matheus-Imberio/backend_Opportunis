package com.bcc.projeto.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bcc.projeto.entities.Candidate;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	
    Optional<Candidate> findByEmailEquals(String email);
    Optional<Candidate> findBytelephone(String telephone);
    Optional<Candidate> findBycpf(String cpf);
}
