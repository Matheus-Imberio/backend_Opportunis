package com.bcc.projeto.services;

import com.bcc.projeto.entities.Candidate;
import com.bcc.projeto.exceptions.DatabaseException;
import com.bcc.projeto.exceptions.ResourceNotFoundException;
import com.bcc.projeto.repositories.CandidateRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository repository;

    public List<Candidate> findAll() {
        return repository.findAll();
    }

    public Candidate findById(Long id) {
        Optional<Candidate> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Candidate  insert(Candidate obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("EmptyResultDataAccessException caught. Throwing ResourceNotFoundException.");
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Candidate update(Long id, Candidate obj) {
        try {
            Candidate entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Candidate entity, Candidate obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setTelephone(obj.getTelephone());
    }

}