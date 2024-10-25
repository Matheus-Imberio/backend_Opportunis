package com.bcc.projeto.repositories;

import com.bcc.projeto.entities.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatureRepository extends JpaRepository<Candidature, Long> {
}
