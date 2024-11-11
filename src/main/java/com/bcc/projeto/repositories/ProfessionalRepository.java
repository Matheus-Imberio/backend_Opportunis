package com.bcc.projeto.repositories;

import com.bcc.projeto.entities.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
}
