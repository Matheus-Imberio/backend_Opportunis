package com.bcc.projeto.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_vacancy")
public class Vacancy implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String goal;
	private String requirements;
	private String description;
	private float wage;
	private int qtdCandidate;
	private boolean activate = true;
	private int clicks = 0;
	private String url_image;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id")
	private Company company;

	@OneToMany(mappedBy = "id.vacancy")
	private List<Candidature> candidatures = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Vacancy(Long id, String goal, String requirements, String description, float wage, int qtdCandidate, Category category, Company company) {
		super();
		this.id = id;
		this.goal = goal;
		this.requirements = requirements;
		this.description = description;
		this.wage = wage;
		this.qtdCandidate = qtdCandidate;
        this.category = category;
		this.company = company;
    }

	public Vacancy() {

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
	
	public void addCandidate() {
		qtdCandidate++;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@JsonIgnore
	public List<Candidature> getCandidatures() {
		return candidatures;
	}

	public boolean isActivate() {return activate;}

	public void setActivate(boolean activate) {this.activate = activate;}

	public int getClicks(){
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
