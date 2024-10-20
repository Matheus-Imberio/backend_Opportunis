package com.bcc.projeto.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_candidate")
@PrimaryKeyJoinColumn(name = "super_profile_id")
public class Candidate extends Profile {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private String cpf;
	
	@Getter
	@Setter
	private char genre;
	
	@Getter
	@Setter
	private Date birthDate;
	
	// TODO relacionamento com classe Curriculum
	// TODO relacionamento com classe Applicant
	// TODO relacionamento com classe Feedback
	
	
	public Candidate() {}


	public Candidate(Long id, String name, String email, String telephone, String password, String cpf, char genre,
			Date birthDate, Address address) {
		super(id, name, email, telephone, password, address);
		this.cpf = cpf;
		this.genre = genre;
		this.birthDate = birthDate;
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
