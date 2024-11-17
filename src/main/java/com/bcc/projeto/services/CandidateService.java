package com.bcc.projeto.services;

import com.bcc.projeto.dtos.CandidateDTO;
import com.bcc.projeto.dtos.ResponseDTO;
import com.bcc.projeto.dtos.UserDTO;
import com.bcc.projeto.entities.Candidate;
import com.bcc.projeto.entities.User;
import com.bcc.projeto.entities.enums.Roles;
import com.bcc.projeto.exceptions.DatabaseException;
import com.bcc.projeto.exceptions.ResourceNotFoundException;
import com.bcc.projeto.repositories.CandidateRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
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

    public void insert(CandidateDTO candidateDTO, String encryptedPassword) {
        Candidate candidate = new Candidate();
        candidate.setName(candidateDTO.name());
        candidate.setEmail(candidateDTO.email());
        candidate.setTelephone(candidateDTO.telephone());
        candidate.setCpf(candidateDTO.cpf());
        candidate.setRole(Roles.CANDIDATE);
        candidate.setGenre(candidateDTO.genre());
        candidate.setPassword(encryptedPassword);
        repository.save(candidate);
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
        entity.setBirthDate(obj.getBirthDate());
        entity.setCpf(obj.getCpf());
        entity.setPassword(obj.getPassword());
    }

    public ResponseDTO findByEmail(String email) {
        Optional<Candidate> candidateOptional = repository.findByEmailEquals(email);
        Candidate candidate = candidateOptional.orElseThrow(() -> new EntityNotFoundException("Candidate not found"));
        return new ResponseDTO(candidate.getEmail());
    }
}