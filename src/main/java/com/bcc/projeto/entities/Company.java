package com.bcc.projeto.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_company")
@Inheritance(strategy = InheritanceType.JOINED)
public class Company extends Profile {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private String socialName;
	
	@Getter
	@Setter
	private String cnpj;
	
	@Getter
	@Setter
	private int qtdEmployee;
	
	@Getter
	@Setter
	private String site;
	
	@Getter
	@Setter
	private String companySector;
	
	@Getter
	@Setter
	private String nationality;
	
	// TODO relacionamento com Feedback
	// TODO relacionamento com Vacancy
	
	
	public Company() {}

	public Company(Long id, String name, String email, String telephone, String password, Address address,
			String socialName, String cnpj, int qtdEmployee, String site, String companySector, String nationality) {
		super(id, name, email, telephone, password, address);
		this.socialName = socialName;
		this.cnpj = cnpj;
		this.qtdEmployee = qtdEmployee;
		this.site = site;
		this.companySector = companySector;
		this.nationality = nationality;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cnpj, companySector, nationality, qtdEmployee, site, socialName);
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
		Company other = (Company) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(companySector, other.companySector)
				&& Objects.equals(nationality, other.nationality) && qtdEmployee == other.qtdEmployee
				&& Objects.equals(site, other.site) && Objects.equals(socialName, other.socialName);
	}

	@Override
	public String toString() {
		return "Company [socialName=" + socialName + ", cnpj=" + cnpj + ", qtdEmployee=" + qtdEmployee + ", site="
				+ site + ", companySector=" + companySector + ", nationality=" + nationality + "]";
	}
}
