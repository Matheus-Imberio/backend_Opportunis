package com.bcc.projeto.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_candidate")
@PrimaryKeyJoinColumn(name = "super_profile_id")
public class Candidate extends Profile {

	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private char genre;
	private Date birthDate;
	
	@OneToMany(mappedBy = "candidate")
	private List<Candidature> candidatures = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Feedback> feedbacks = new ArrayList<>();	
	
	@OneToMany(mappedBy = "candidate")
	private List<Curriculum> curriculumns = new ArrayList<>();
	
	
	public Candidate() {}

	public Candidate(Long id, String name, String email, String telephone, String password, String cpf, char genre,
			Date birthDate, Address address) {
		super(id, name, email, telephone, password);
		this.cpf = cpf;
		this.genre = genre;
		this.birthDate = birthDate;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public char getGenre() {
		return genre;
	}

	public void setGenre(char genre) {
		this.genre = genre;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<Candidature> getCandidatures() {
		return candidatures;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public List<Curriculum> getCurriculumns() {
		return curriculumns;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(birthDate, cpf, genre);
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
		Candidate other = (Candidate) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(cpf, other.cpf) && genre == other.genre;
	}

	@Override
	public String toString() {
		return "Candidate [cpf=" + cpf + ", genre=" + genre + ", birthDate=" + birthDate + "]";
	}
}
