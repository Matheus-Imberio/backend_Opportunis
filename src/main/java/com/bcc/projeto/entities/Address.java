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
@Table(name = "tb_address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String street;
	private String number;
	private String district;
	private String city;
	private String cep;
	private String complement;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Profile owner;
	
	
	public Address() {}

	public Address(Long id, String street, String number, String district, String city, String cep, String complement, Profile owner) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.district = district;
		this.city = city;
		this.cep = cep;
		this.complement = complement;
		this.owner = owner;
		this.owner.addNewAddress(this);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Profile getOwner() {
		return owner;
	}

	public void setOwner(Profile owner) {
		this.owner = owner;
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
