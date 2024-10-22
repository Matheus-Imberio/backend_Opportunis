package com.bcc.projeto.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_candidature")
public class Candidature implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Instant date;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	// TODO relacionamento com Vacancy
	// TODO relacionamento com Candidate
	
	
	public Candidature() {}

	public Candidature(Long id, Instant date) {
		super();
		this.id = id;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}
	
	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id);
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
		return Objects.equals(date, other.date) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Candidature [id=" + id + ", date=" + date + "]";
	}
}
