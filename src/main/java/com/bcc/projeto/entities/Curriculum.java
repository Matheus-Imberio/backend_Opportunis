package com.bcc.projeto.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_curriculum")
public class Curriculum implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "curriculum_id")
	private Long id;
	private String professionalGoal;
	private String additionalInfo;
	
	@OneToMany(mappedBy = "curriculum")
	private List<Professional> professionalExperiences = new ArrayList<>();
	
	@OneToMany(mappedBy = "curriculum")
	private List<AcademicBackground> academicBackgroundExperience = new ArrayList<>();
	
	@OneToMany(mappedBy = "curriculum")
	private List<Course> coursesExperiences = new ArrayList<>();
	
	@OneToMany(mappedBy = "curriculum")
	private List<Language> languages = new ArrayList<>();
	
	@OneToMany(mappedBy = "curriculum")
	private List<Skill> skills = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	
	public Curriculum() {}
	
	public Curriculum(long id, String professionalGoal, String additionalInfo, Candidate candidate) {
		super();
		this.id = id;
		this.professionalGoal = professionalGoal;
		this.additionalInfo = additionalInfo;
		this.candidate = candidate;
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
	
	public List<Language> getLanguages() {
		return languages;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public List<Professional> getProfessionalExperiences() {
		return professionalExperiences;
	}

	public List<AcademicBackground> getAcademicBackgroundExperience() {
		return academicBackgroundExperience;
	}

	public List<Course> getCoursesExperiences() {
		return coursesExperiences;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
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
