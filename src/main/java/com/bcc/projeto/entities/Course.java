package com.bcc.projeto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_course")
@PrimaryKeyJoinColumn(name = "course_id")
public class Course extends Experience {

	private static final long serialVersionUID = 1L;

}
