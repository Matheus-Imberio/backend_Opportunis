package com.bcc.projeto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bcc.projeto.repositories.AdressRepository;
import com.bcc.projeto.repositories.CandidateRepository;
import com.bcc.projeto.repositories.CompanyRepository;
import com.bcc.projeto.services.CurriculumService;

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
