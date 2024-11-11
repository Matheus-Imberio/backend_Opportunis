package com.bcc.projeto.repositories;

import com.bcc.projeto.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
