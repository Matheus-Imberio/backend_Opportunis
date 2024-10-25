package com.bcc.projeto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_academic_background")
@PrimaryKeyJoinColumn(name = "academic_bckg_id")
public class AcademicBackground extends Experience {

	private static final long serialVersionUID = 1L;

}
