package com.bcc.projeto.entities;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_course")
@PrimaryKeyJoinColumn(name = "experience_course_id")
public class Course extends Experience {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "curriculum_id")
	private Curriculum curriculum;

	
	public Course() {}
	
	public Course(Long id, String organization, String description, Instant dateBegin, Instant dateEnd,
			Curriculum curriculum) {
		super(id, organization, description, dateBegin, dateEnd);
		this.curriculum = curriculum;
		this.curriculum.getCoursesExperiences().add(this);
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(curriculum);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(curriculum, other.curriculum);
	}

	@Override
	public String toString() {
		return "Course [curriculum=" + curriculum + "]";
	}
}
