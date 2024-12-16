package com.bcc.projeto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bcc.projeto.entities.Candidate;
import com.bcc.projeto.entities.Candidature;
import com.bcc.projeto.entities.Category;
import com.bcc.projeto.entities.Company;
import com.bcc.projeto.entities.Vacancy;
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
		//populateCompaniesAndCategories();
		seedCandidatures();
	}
	
	private void seedCandidatures() {
		
		Vacancy vac1 = new Vacancy(null, "Tech Lead TI", null, null, 0, 0, null);
		Vacancy vac2 = new Vacancy(null, "Desenvolvedor Front-end", null, null, 0, 0, null);
		Vacancy vac3 = new Vacancy(null, "Desenvolvedor FullStack", null, null, 0, 0, null);
		Vacancy vac4 = new Vacancy(null, "Scrum Master", null, null, 0, 0, null);
		vacancyRepo.save(vac1);
		vacancyRepo.save(vac2);
		vacancyRepo.save(vac3);
		vacancyRepo.save(vac4);
		
		Candidate c1 = new Candidate(null, "joão", "joao@gmail.com", "4491111111", "joao123", "11111111111", 'M', null);
		Candidate c2 = new Candidate(null, "Maria", "maria@gmail.com", "44922222222", "maria123", "22222222222", 'F', null);
		candidateRepo.save(c1);
		candidateRepo.save(c2);
		
		Candidature can1 = new Candidature(null, c1, vac1);
		Candidature can2 = new Candidature(null, c2, vac2);
		Candidature can3 = new Candidature(null, c2, vac3);
		candidatureRepo.save(can1);
		candidatureRepo.save(can2);
		candidatureRepo.save(can3);
	}
	
	private void populateCompaniesAndCategories() {
		Company com1 = new Company(
				null,
				"Coamo Agroindustrial",
				"atendimento@coamo.com",
				"4435682222",
				"coamo123",
				"COAMO AGROINSDUSTRIAL LTDA",
				"11222333000244",
				250,
				"www.coamo.com.br",
				null,
				"brasil");
		
		Company com2 = new Company(
				null,
				"Appmoove",
				"atendimento@appmoove.com",
				"1122223333",
				"appmoove123",
				"APPMOOVE SOLUCOES TECNOLOGICAS LTDA",
				"00111222000100",
				88,
				"www.appmoove.com.br",
				null,
				"brasil");
		
		Category cat1 = new Category("tecnologia", null);
		Category cat2 = new Category("Varejo", null);
		Category cat3 = new Category("Agro", null);
		
		cat1.getCompanies().add(com2);
		cat3.getCompanies().add(com1);
		//com2.setCategory(cat1);
		//com1.setCategory(cat3);
		
		categoryRepo.save(cat1);
		categoryRepo.save(cat2);
		categoryRepo.save(cat3);
		companyRepo.save(com1);
		companyRepo.save(com2);
		
	}
}
