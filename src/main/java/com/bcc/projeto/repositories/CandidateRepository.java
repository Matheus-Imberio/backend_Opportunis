package com.bcc.projeto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bcc.projeto.entities.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	
	@Query(value = "SELECT c FROM Candidate c ORDER BY c.professionalExperienceQtd")
	public List<Candidate> findAllOrderedByProfessionalExperienceQtd();
	
    Optional<Candidate> findByEmailEquals(String email);
    Optional<Candidate> findBytelephone(String telephone);
    Optional<Candidate> findBycpf(String cpf);
}
