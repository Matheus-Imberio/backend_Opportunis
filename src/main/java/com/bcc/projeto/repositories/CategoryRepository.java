package com.bcc.projeto.repositories;

import com.bcc.projeto.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
