package com.bcc.projeto.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_feedback")
public class Feedback implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String comment;
	private int score;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Candidate user;
	
	// TODO relacionamento com Company
	
	
	public Feedback() {}

	public Feedback(Long id, String comment, int score) {
		super();
		this.id = id;
		this.comment = comment;
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public Candidate getUser() {
		return user;
	}

	public void setUser(Candidate user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comment, id, score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feedback other = (Feedback) obj;
		return Objects.equals(comment, other.comment) && Objects.equals(id, other.id) && score == other.score;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", comment=" + comment + ", score=" + score + "]";
	}
}
