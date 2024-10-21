package com.bcc.projeto.repositories;

import com.bcc.projeto.entities.Candidate;
import com.bcc.projeto.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
