package com.bcc.projeto.repositories;

import com.bcc.projeto.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmRepository extends JpaRepository<Administrator, Long> {
}
