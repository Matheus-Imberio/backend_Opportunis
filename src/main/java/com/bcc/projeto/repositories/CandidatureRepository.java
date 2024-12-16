package com.bcc.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcc.projeto.entities.Candidature;
import com.bcc.projeto.entities.pk.CandidaturePk;

public interface CandidatureRepository extends JpaRepository<Candidature, CandidaturePk> {
}
