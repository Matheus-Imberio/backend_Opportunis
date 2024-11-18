package com.bcc.projeto.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bcc.projeto.entities.AcademicBackground;
import com.bcc.projeto.entities.Address;
import com.bcc.projeto.entities.Candidate;
import com.bcc.projeto.entities.Company;
import com.bcc.projeto.entities.Course;
import com.bcc.projeto.entities.Curriculum;
import com.bcc.projeto.entities.Language;
import com.bcc.projeto.entities.Professional;
import com.bcc.projeto.entities.Skill;
import com.bcc.projeto.entities.enums.Level;
import com.bcc.projeto.repositories.AdressRepository;
import com.bcc.projeto.repositories.CandidateRepository;
import com.bcc.projeto.repositories.CompanyRepository;
import com.bcc.projeto.service.CurriculumService;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private CandidateRepository candidateRepo;
	
	@Autowired
	private AdressRepository adressRepo;
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@Autowired
	private CurriculumService curriculumService;
	
	@Override
	public void run(String... args) throws Exception {
	}
}
