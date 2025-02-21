package com.bcc.projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bcc.projeto.dtos.CandidateDTO;
import com.bcc.projeto.dtos.ResponseDTO;
import com.bcc.projeto.entities.Candidate;
import com.bcc.projeto.entities.enums.Roles;
import com.bcc.projeto.exceptions.CPFAlreadyInUseException;
import com.bcc.projeto.exceptions.DatabaseException;
import com.bcc.projeto.exceptions.EmailAlreadyInUseException;
import com.bcc.projeto.exceptions.ResourceNotFoundException;
import com.bcc.projeto.exceptions.TelephoneAlreadyInUseException;
import com.bcc.projeto.repositories.CandidateRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class CandidateService {

    private final CandidateRepository repository;

    @Autowired
    public CandidateService(CandidateRepository repository) {
        this.repository = repository;
    }

    public Page<Candidate> findAll(Pageable pageable) {    	
        return repository.findAll(pageable);
    }

    public Candidate findById(Long id) {
        Optional<Candidate> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public Candidate insert(Candidate obj) throws EmailAlreadyInUseException, CPFAlreadyInUseException, TelephoneAlreadyInUseException {
        Optional<Candidate> existingByEmail = repository.findByEmailEquals(obj.getEmail());
        if (existingByEmail.isPresent()) {
            throw new EmailAlreadyInUseException("Email já está em uso: " + obj.getEmail());
        }
        Optional<Candidate> existingByCPF = repository.findBycpf(obj.getCpf());
        if (existingByCPF.isPresent()) {
            throw new CPFAlreadyInUseException("CPF já está em uso: " + obj.getCpf());
        }
        Optional<Candidate> existingByTelephone = repository.findBytelephone(obj.getTelephone());
        if (existingByTelephone.isPresent()) {
            throw new TelephoneAlreadyInUseException("Telefone já está em uso: " + obj.getTelephone());
        }
        return repository.save(obj);
    }

    @Transactional
    public void insert(CandidateDTO candidateDTO, String encryptedPassword) {
        Candidate candidate = new Candidate();
        candidate.setName(candidateDTO.name());
        candidate.setEmail(candidateDTO.email());
        candidate.setTelephone(candidateDTO.telephone());
        candidate.setCpf(candidateDTO.cpf());
        candidate.setRole(Roles.CANDIDATE);
        candidate.setGenre(candidateDTO.genre());
        candidate.setUrl(candidateDTO.url_image());
        candidate.setPassword(encryptedPassword);
        repository.save(candidate);
    }

    @Transactional
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
    @Transactional
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
        entity.setGenre(obj.getGenre());
        entity.setEmail(obj.getEmail());
        entity.setTelephone(obj.getTelephone());
        entity.setCpf(obj.getCpf());
        entity.setPassword(obj.getPassword());
        entity.setUrl(obj.getUrl());
    }

    public ResponseDTO findByEmail(String email) {
        Optional<Candidate> candidateOptional = repository.findByEmailEquals(email);
        Candidate candidate = candidateOptional.orElseThrow(() -> new EntityNotFoundException("Candidate not found"));
        return new ResponseDTO(candidate.getEmail());
    }
    
    private int experienceCounter(Candidate candidate) {
    	return candidate.getCurriculumns().stream().mapToInt(curriculum -> curriculum.getProfessionalExperiences().size()).sum();
    }
}