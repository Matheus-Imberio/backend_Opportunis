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
		
		Candidate candidate1 = new Candidate(null, "Ruan", "ruan@gmail.com", "44988882222", "123r", "11122233344", 'M', null);
		Candidate candidate2 = new Candidate(null, "Matheus", "matheus@gmail.com", "11877776666", "math321", "00011100022", 'M', null);
		Candidate candidate3 = new Candidate(null, "Victor", "victor@gmail.com", "10988880000", "vetor987", "22233344455", 'M', null);
		Candidate candidate4 = new Candidate(null, "Hudson", "hudson@gmail.com", "439000011111", "1928hud", "33344455566", 'M', null);
		
		Curriculum curr1 = new Curriculum(null, "desenvolvedor Backend", "gosta de gatos", candidate1);
		Curriculum curr2 = new Curriculum(null, "desenvolvedor Frontend", null, candidate2);

		Professional professional1 = new Professional(null, "hacken", null, null, null, curr1);
		Professional professional2 = new Professional(null, "Magalu Cloud", null, null, null, curr2);
		AcademicBackground acadBkg1 = new AcademicBackground(null, "UTFPR", "cursou a graduação em BCC", null, null, curr1);
		AcademicBackground acadBkg2 = new AcademicBackground(null, "UFRJ", "cursou a graduação em Sistemas de Informações", null, null, curr2);
		Course course1 = new Course(null, "Alura", null, null, null, curr1);
		Language lang1 = new Language(null, "Ingles", Level.ADVANCED, curr2);
		Skill skill1 = new Skill(null, "Acender fósforo com apenas uma mão", curr1);
		Skill skill2 = new Skill(null, "ficar mais de 5 min debaixo da água", curr2);
		
		Company company1 = new Company(null, "Alura cursos online", "alura@gmail.com", "44999999999", "123", "ALURA C O LTDA", "11222333000144", 25, "wwww.alura.com.br", "educação", "brasileira");
		Company company2 = new Company(null, "Dona Maura Boate", "maura@gmail.com", "44988888888", "321", "DONA MAURA B LTDA", "222222220000222", 15, null, "educação", "brasileira");
		
		Address ender1	= new Address(null, "Rua Ricardão", "000", "centro", "mambore", "87340000", "perto da praça", candidate1);
		Address ender2	= new Address(null, "Rua Paula Tejano", "69", "vila cesar", "campo mourão", "11234000", null, candidate2);
		Address ender3	= new Address(null, "Av. Sujiro Kimimami", "24", "centro", "Campo mourão", "22333000", "prox ao terminal", candidate1);
		Address ender4	= new Address(null, "Av. Jacinto Leite", "11", "campo belo", "maringá", "33444000", null, candidate3);
		Address ender5	= new Address(null, "Rua Cuca Beludo", "000", "logo ali", "xique xique bahia", "11222000", null, candidate4);
		Address ender6	= new Address(null, "Av Caio Debbocan Pinto ", "555", "Jardim 2", "xique xique bahia", "11111000", null, company1);
		Address ender7	= new Address(null, "Rua Zeca gado", "1020", "Jardim 1", "xique xique bahia", "11111000", null, company2);
		
		candidateRepo.saveAll(Arrays.asList(candidate1, candidate2, candidate3, candidate4));
		companyRepo.saveAll(Arrays.asList(company1, company2));
		adressRepo.saveAll(Arrays.asList(ender1, ender2, ender3, ender4, ender5, ender6, ender7));
		curriculumService.save(curr1);
		curriculumService.save(curr2);
	}
}
