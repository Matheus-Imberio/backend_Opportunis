package com.bcc.projeto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_professional")
@PrimaryKeyJoinColumn(name = "professional_id")
public class Professional extends Experience {

	private static final long serialVersionUID = 1L;

}
