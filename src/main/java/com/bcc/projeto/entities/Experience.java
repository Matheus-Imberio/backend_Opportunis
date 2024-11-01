package com.bcc.projeto.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_experience")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Experience implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String organization;
	private String description;
	private Instant dateBegin;
	private Instant dateEnd;
	
	
	public Experience() {}
	
	public Experience(long id, String organization, String description, Instant dateBegin, Instant dateEnd) {
		super();
		this.id = id;
		this.organization = organization;
		this.description = description;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Instant getDateBegin() {
		return dateBegin;
	}
	public void setDateBegin(Instant dateBegin) {
		this.dateBegin = dateBegin;
	}
	public Instant getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Instant dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dateBegin, dateEnd, description, id, organization);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Experience other = (Experience) obj;
		return Objects.equals(dateBegin, other.dateBegin) && Objects.equals(dateEnd, other.dateEnd)
				&& Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(organization, other.organization);
	}
	
	@Override
	public String toString() {
		return "Experience [id=" + id + ", organization=" + organization + ", description=" + description
				+ ", dateBegin=" + dateBegin + ", dateEnd=" + dateEnd + "]";
	}
}
