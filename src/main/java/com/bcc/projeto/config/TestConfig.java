package com.bcc.projeto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bcc.projeto.entities.Category;
import com.bcc.projeto.entities.Company;
import com.bcc.projeto.repositories.AdressRepository;
import com.bcc.projeto.repositories.CandidateRepository;
import com.bcc.projeto.repositories.CategoryRepository;
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
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public void run(String... args) throws Exception {
		//populateCompaniesAndCategories();
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
