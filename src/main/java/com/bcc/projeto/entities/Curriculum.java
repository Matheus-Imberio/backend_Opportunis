package com.bcc.projeto.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	// TODO relacionamento com Candidate
	
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
