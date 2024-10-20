package com.bcc.projeto.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class Profile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String telephone;
	
	@Getter
	@Setter
	private String password;
	
	// TODO relacionamento com classe Address
	
	
	public Profile() {}
	
	public Profile(Long id, String name, String email, String telephone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
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
