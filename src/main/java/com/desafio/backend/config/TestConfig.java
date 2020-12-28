package com.desafio.backend.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafio.backend.entities.Address;
import com.desafio.backend.entities.Phone;
import com.desafio.backend.entities.User;
import com.desafio.backend.repositories.AddressRepository;
import com.desafio.backend.repositories.PhoneRepository;
import com.desafio.backend.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Autowired 
	private AddressRepository addressRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
	
		User u1 = new User(null,"admin", "04736017104", "123456");
		User u2 = new User(null,"comum", "012345678910", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Address a1 = new Address(null,"QN07 Conjunto 18 Casa 37", "DF", "Brasilia", "Riacho Fundo 1",u1);
		Phone p1 = new Phone(null,"983601455", 2, u1);
		
		phoneRepository.save(p1);
		addressRepository.save(a1);
		
		u1.getPhones().add(p1);
		userRepository.save(u1);
		

		u1.getAddresses().add(a1);
		userRepository.save(u1);

		
	}
}
