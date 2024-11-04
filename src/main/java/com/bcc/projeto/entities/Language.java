package com.bcc.projeto.entities;

import java.io.Serializable;
import java.util.Objects;

import com.bcc.projeto.entities.enums.Level;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_language")
public class Language implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String language;
	private Level level;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "curriculum_id")
	private Curriculum curriculum;
	
	
	public Language() {}

	public Language(Long id, String language, Level level, Curriculum curriculum) {
		super();
		this.id = id;
		this.language = language;
		this.level = level;
		this.curriculum = curriculum;
		this.curriculum.getLanguages().add(this);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	@JsonIgnore
	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, language, level);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Language other = (Language) obj;
		return id == other.id && Objects.equals(language, other.language) && level == other.level;
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", language=" + language + ", level=" + level + "]";
	}
}
