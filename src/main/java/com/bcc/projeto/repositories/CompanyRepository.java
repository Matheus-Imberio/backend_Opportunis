package com.bcc.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcc.projeto.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
