package com.bcc.projeto.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@Setter
	private String street;
	
	@Getter
	@Setter
	private String number;
	
	@Getter
	@Setter
	private String district;
	
	@Getter
	@Setter
	private String city;
	
	@Getter
	@Setter
	private String cep;
	
	@Getter
	@Setter
	private String complement;
	
	// TODO relacionamento com a classe User
	
	public Address() {}

	public Address(Long id, String street, String number, String district, String city, String cep, String complement) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.district = district;
		this.city = city;
		this.cep = cep;
		this.complement = complement;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, city, complement, district, id, number, street);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(city, other.city)
				&& Objects.equals(complement, other.complement) && Objects.equals(district, other.district)
				&& Objects.equals(id, other.id) && Objects.equals(number, other.number)
				&& Objects.equals(street, other.street);
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", number=" + number + ", district=" + district + ", city="
				+ city + ", cep=" + cep + ", complement=" + complement + "]";
	}
}
