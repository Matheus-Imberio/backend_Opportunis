package com.bcc.projeto.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcc.projeto.entities.Curriculum;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class CurriculumRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Curriculum save(Curriculum curriculum) {
		entityManager.persist(curriculum);
		entityManager.detach(curriculum);
		return curriculum;
	}
	
	public Curriculum findById(Long id) {
		return entityManager.find(Curriculum.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Curriculum> findAllByCandidateId(Long candidateId) {
		
		Query query = entityManager.createNativeQuery("SELECT tb_curriculum.* FROM tb_curriculum "
				+ "WHERE tb_curriculum.candidate_id = :candidateId", Curriculum.class)
				.setParameter("candidateId", candidateId);
		
		return query.getResultList();
	}
	
	public Curriculum update(Curriculum curriculum) {
		return entityManager.merge(curriculum);
	}
	
	public void delete(Object entity) {
		entityManager.remove(entity);
	}
}