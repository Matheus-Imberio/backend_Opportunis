package com.bcc.projeto.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_curriculum")
public class Curriculum implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String professionalGoal;
	private String additionalInfo;
	
	@OneToOne(mappedBy = "curriculum")
	private Professional experienceProfessional;
	
	@OneToOne(mappedBy = "curriculum")
	private AcademicBackground experienceAcademicBackground;
	
	@OneToOne(mappedBy = "curriculum")
	private Course experienceCourse;
	
	// TODO relacionamento com Candidate
	
	public Curriculum() {}
	
	public Curriculum(long id, String professionalGoal, String additionalInfo, Professional experienceProfessional,
			AcademicBackground experienceAcademicBackground, Course experienceCourse) {
		super();
		this.id = id;
		this.professionalGoal = professionalGoal;
		this.additionalInfo = additionalInfo;
		this.experienceProfessional = experienceProfessional;
		this.experienceAcademicBackground = experienceAcademicBackground;
		this.experienceCourse = experienceCourse;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProfessionalGoal() {
		return professionalGoal;
	}
	public void setProfessionalGoal(String professionalGoal) {
		this.professionalGoal = professionalGoal;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
	public Professional getExperienceProfessional() {
		return experienceProfessional;
	}
	public void setExperienceProfessional(Professional experienceProfessional) {
		this.experienceProfessional = experienceProfessional;
	}
	public AcademicBackground getExperienceAcademicBackground() {
		return experienceAcademicBackground;
	}
	public void setExperienceAcademicBackground(AcademicBackground experienceAcademicBackground) {
		this.experienceAcademicBackground = experienceAcademicBackground;
	}
	public Course getExperienceCourse() {
		return experienceCourse;
	}
	public void setExperienceCourse(Course experienceCourse) {
		this.experienceCourse = experienceCourse;
	}
	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, id, professionalGoal);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curriculum other = (Curriculum) obj;
		return Objects.equals(additionalInfo, other.additionalInfo) && id == other.id
				&& Objects.equals(professionalGoal, other.professionalGoal);
	}
	
	@Override
	public String toString() {
		return "Curriculum [id=" + id + ", professionalGoal=" + professionalGoal + ", additionalInfo=" + additionalInfo
				+ "]";
	}
}
