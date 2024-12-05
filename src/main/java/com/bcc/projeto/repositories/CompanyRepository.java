package com.bcc.projeto.repositories;

import com.bcc.projeto.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bcc.projeto.entities.Company;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByEmailEquals(String email);
    Optional<Company> findBycnpjEquals(String cpf);

    Page<Company> findByCategory(Category category, Pageable pageable);
}