package com.bcc.projeto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bcc.projeto.entities.Candidature;
import com.bcc.projeto.entities.pk.CandidaturePk;


public interface CandidatureRepository extends JpaRepository<Candidature, CandidaturePk> {
	
	@Query("FROM Candidature c WHERE c.id.candidate.id = :id")
	List<Candidature> findAllByCandidateId(Long id);
	
	@Query("FROM Candidature c WHERE c.id.vacancy.id = :id")
	List<Candidature> findAllByVacancyId(Long id);
}
