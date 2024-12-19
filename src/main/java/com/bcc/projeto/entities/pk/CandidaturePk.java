package com.bcc.projeto.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.bcc.projeto.entities.Candidate;
import com.bcc.projeto.entities.Vacancy;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class CandidaturePk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@ManyToOne
	@JoinColumn(name = "vacancy_id")
	private Vacancy vacancy;
	
	public CandidaturePk() {
		super();
	}
	
	public CandidaturePk(Candidate candidate, Vacancy vacancy) {
		super();
		this.candidate = candidate;
		this.vacancy = vacancy;
	}

	@JsonIncludeProperties({"id", "name"})
	public Candidate getCandidate() {
		return candidate;
	}
	
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	@JsonIncludeProperties({"id", "goal"})
	public Vacancy getVacancy() {
		return vacancy;
	}
	
	public void setVacancy(Vacancy vacancy) {
		this.vacancy = vacancy;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(candidate, vacancy);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidaturePk other = (CandidaturePk) obj;
		return Objects.equals(candidate, other.candidate) && Objects.equals(vacancy, other.vacancy);
	}
}
