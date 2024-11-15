package com.bcc.projeto.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bcc.projeto.entities.Curriculum;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CurriculumRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Curriculum save(Curriculum curriculum) {
		entityManager.persist(curriculum);
		entityManager.detach(curriculum);
		return curriculum;
	}
	
	// TODO find by id
	// TODO update
	// TODO delete
}