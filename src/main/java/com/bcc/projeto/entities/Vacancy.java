package com.bcc.projeto.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_vacancy")
public class Vacancy implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String goal;
	private String requirements;
	private String description;
	private float wage;
	private int qtdCandidate;
	
	// TODO relacionamento com Company
	// TODO relacionamento com Applicant
	
	
	public Vacancy() {}

	public Vacancy(Long id, String goal, String requirements, String description, float wage, int qtdCandidate) {
		super();
		this.id = id;
		this.goal = goal;
		this.requirements = requirements;
		this.description = description;
		this.wage = wage;
		this.qtdCandidate = qtdCandidate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getWage() {
		return wage;
	}

	public void setWage(float wage) {
		this.wage = wage;
	}

	public int getQtdCandidate() {
		return qtdCandidate;
	}

	public void setQtdCandidate(int qtdCandidate) {
		this.qtdCandidate = qtdCandidate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, goal, id, qtdCandidate, requirements, wage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacancy other = (Vacancy) obj;
		return Objects.equals(description, other.description) && Objects.equals(goal, other.goal)
				&& Objects.equals(id, other.id) && qtdCandidate == other.qtdCandidate
				&& Objects.equals(requirements, other.requirements)
				&& Float.floatToIntBits(wage) == Float.floatToIntBits(other.wage);
	}

	@Override
	public String toString() {
		return "Vacancy [id=" + id + ", goal=" + goal + ", requirements=" + requirements + ", description="
				+ description + ", wage=" + wage + ", qtdCandidate=" + qtdCandidate + "]";
	}
}
