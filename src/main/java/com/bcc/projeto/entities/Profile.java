package com.bcc.projeto.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_profile")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Profile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String telephone;
	private String password;
	
	@OneToMany(mappedBy = "owner")
	private List<Address> addresses = new ArrayList<>();
	
	public Profile() {}
	
	public Profile(Long id, String name, String email, String telephone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
	}
	
	@JsonIgnoreProperties
	public void addNewAddress(Address address) {
		addresses.add(address);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, password, telephone);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(telephone, other.telephone);
	}
	
	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", email=" + email + ", telephone=" + telephone + ", password="
				+ password + "]";
	}	
}
