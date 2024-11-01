package com.bcc.projeto.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bcc.projeto.entities.Address;
import com.bcc.projeto.entities.Candidate;
import com.bcc.projeto.repositories.AdressRepository;
import com.bcc.projeto.repositories.CandidateRepository;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private CandidateRepository candidateRepo;
	
	@Autowired
	private AdressRepository adressRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		// TODO classe Candidate não precisa ter o campo endereço em seu construtor
		Candidate candidate1 = new Candidate(null, "Ruan", "ruan@gmail.com", "44988882222", "123r", "11122233344", 'M', null, null);
		Candidate candidate2 = new Candidate(null, "Matheus", "matheus@gmail.com", "11877776666", "math321", "00011100022", 'M', null, null);
		Candidate candidate3 = new Candidate(null, "Victor", "victor@gmail.com", "10988880000", "vetor987", "22233344455", 'M', null, null);
		Candidate candidate4 = new Candidate(null, "Hudson", "hudson@gmail.com", "439000011111", "1928hud", "33344455566", 'M', null, null);
	
		Address ender1	= new Address(null, "Rua Ricardão", "000", "centro", "mambore", "87340000", "perto da praça", candidate1);
		Address ender2	= new Address(null, "Rua Paula Tejano", "69", "vila cesar", "campo mourão", "11234000", null, candidate2);
		Address ender3	= new Address(null, "Av. Sujiro Kimimami", "24", "centro", "Campo mourão", "22333000", "prox ao terminal", candidate1);
		Address ender4	= new Address(null, "Av. Jacinto Leite", "11", "campo belo", "maringá", "33444000", null, candidate3);
		Address ender5	= new Address(null, "Rua Cuca Beludo", "000", "logo ali", "xique xique bahia", "11222000", null, candidate4);
		
		candidate1.addNewAddress(ender1);
		candidate1.addNewAddress(ender3);
		candidate2.addNewAddress(ender2);
		candidate3.addNewAddress(ender4);
		candidate4.addNewAddress(ender5);
		
		candidateRepo.saveAll(Arrays.asList(candidate1, candidate2, candidate3, candidate4));
		adressRepo.saveAll(Arrays.asList(ender1, ender2, ender3, ender4, ender5));
	}

}
