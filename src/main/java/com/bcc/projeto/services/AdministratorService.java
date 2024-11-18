package com.bcc.projeto.services;

import com.bcc.projeto.entities.Administrator;
import com.bcc.projeto.exceptions.*;
import com.bcc.projeto.repositories.AdmRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService {

    @Autowired
    private AdmRepository repository;

    public List<Administrator> findAll() {
        return repository.findAll();
    }

    public Administrator findById(Long id) {
        Optional<Administrator> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Administrator insert(Administrator obj){return repository.save(obj);}

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

    public Administrator update(Long id, Administrator obj) {
        try {
            Administrator entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Administrator entity, Administrator obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setTelephone(obj.getTelephone());
        entity.setBirthDate(obj.getBirthDate());
        entity.setCpf(obj.getCpf());
        entity.setPassword(obj.getPassword());
    }

}