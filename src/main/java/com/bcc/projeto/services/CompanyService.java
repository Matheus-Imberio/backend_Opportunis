package com.bcc.projeto.services;

import com.bcc.projeto.entities.Administrator;
import com.bcc.projeto.entities.Company;
import com.bcc.projeto.exceptions.DatabaseException;
import com.bcc.projeto.exceptions.ResourceNotFoundException;
import com.bcc.projeto.repositories.AdmRepository;
import com.bcc.projeto.repositories.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public List<Company> findAll() {
        return repository.findAll();
    }

    public Company findById(Long id) {
        Optional<Company> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Company insert(Company obj) {
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

    public Company update(Long id, Company obj) {
        try {
            Company entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Company entity, Company obj) {
        entity.setSocialName(obj.getSocialName());
        entity.setCnpj(obj.getCnpj());
        entity.setQtdEmployee(obj.getQtdEmployee());
        entity.setSite(obj.getSite());
        entity.setCompanySector(obj.getCompanySector());
        entity.setNationality(obj.getNationality());
    }

}