package com.bcc.projeto.repositories;

import com.bcc.projeto.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bcc.projeto.entities.Company;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByEmailEquals(String email);
}
