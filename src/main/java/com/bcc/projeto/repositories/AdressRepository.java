package com.bcc.projeto.repositories;

import com.bcc.projeto.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Address, Long> {
}
