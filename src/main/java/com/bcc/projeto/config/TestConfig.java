package com.bcc.projeto.config;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bcc.projeto.entities.Candidate;
import com.bcc.projeto.entities.Candidature;
import com.bcc.projeto.entities.Category;
import com.bcc.projeto.entities.Company;
import com.bcc.projeto.entities.Curriculum;
import com.bcc.projeto.entities.Vacancy;
import com.bcc.projeto.entities.pk.CandidaturePk;
import com.bcc.projeto.repositories.AdressRepository;
import com.bcc.projeto.repositories.CandidateRepository;
import com.bcc.projeto.repositories.CandidatureRepository;
import com.bcc.projeto.repositories.CategoryRepository;
import com.bcc.projeto.repositories.CompanyRepository;
import com.bcc.projeto.repositories.VacancyRepository;
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

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private VacancyRepository vacancyRepo;

	@Autowired
	private CandidatureRepository candidatureRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Candidate c1 = new Candidate(null, "joao", "joao@gmail", null, "joao123", "00000000000", 'M', null);
		Candidate c2 = new Candidate(null, "antonio", "antonio@gmail", null, "antonio123", "11111111111", 'M', null);
		Candidate c3 = new Candidate(null, "maria", "maria@gmail", null, "maria123", "22222222222", 'F', null);
		Candidate c4 = new Candidate(null, "vitoria", "vitoria@gmail", null, "vitoria123", "33333333333", 'F', null);
		
		Curriculum curr1 = new Curriculum(null, "Desenvolvedor Junior", "presencial", c1);
		Curriculum curr2 = new Curriculum(null, "Desenvolvidor Senior", "Somente remoto", c3);
		Curriculum curr3 = new Curriculum(null, "Estágio em TI", "Busca por experiência", c4);
	
		candidateRepo.saveAll(Arrays.asList(c1, c2, c3, c4));
		curriculumService.save(curr1);
		curriculumService.save(curr2);
		curriculumService.save(curr3);
	}
}
