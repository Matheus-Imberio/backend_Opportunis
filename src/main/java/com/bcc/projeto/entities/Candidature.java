package com.bcc.projeto.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.bcc.projeto.entities.pk.CandidaturePk;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_candidature")
public class Candidature implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CandidaturePk id = new CandidaturePk();
	private Instant date;	
	
	public Candidature() {}

	public Candidature(CandidaturePk id, Instant date) {
		super();
		this.id = id;
		this.date = date;
	}
	
	public CandidaturePk getId() {
		return id;
	}
	
	public void setId(CandidaturePk id) {
		this.id = id;
	}
	
	@JsonIgnore
	public Candidate getCandidate() {
		return id.getCandidate();
	}
	
	public void setCandidate(Candidate candidate) {
		id.setCandidate(candidate);
	}
	
	@JsonIgnore
	public Vacancy getVacancy() {
		return id.getVacancy();
	}
	
	public void setVacancy(Vacancy vacancy) {
		id.setVacancy(vacancy);
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidature other = (Candidature) obj;
		return Objects.equals(id, other.id);
	}
}
