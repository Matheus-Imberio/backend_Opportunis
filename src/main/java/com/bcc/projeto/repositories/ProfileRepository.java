package com.bcc.projeto.repositories;

import com.bcc.projeto.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
