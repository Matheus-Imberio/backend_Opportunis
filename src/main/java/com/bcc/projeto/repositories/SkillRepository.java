package com.bcc.projeto.repositories;

import com.bcc.projeto.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
