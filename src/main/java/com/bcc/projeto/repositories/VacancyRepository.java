package com.bcc.projeto.repositories;

import com.bcc.projeto.entities.Category;
import com.bcc.projeto.entities.Vacancy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    Page<Vacancy> findByCategory(Category category, Pageable pageable);
}