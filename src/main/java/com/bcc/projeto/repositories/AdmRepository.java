package com.bcc.projeto.repositories;

import com.bcc.projeto.entities.Administrator;
import com.bcc.projeto.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdmRepository extends JpaRepository<Administrator, Long> {
}
