package com.desafio.backend.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafio.backend.entities.Address;
import com.desafio.backend.entities.Client;
import com.desafio.backend.entities.Phone;
import com.desafio.backend.entities.User;
import com.desafio.backend.repositories.AddressRepository;
import com.desafio.backend.repositories.ClientRepository;
import com.desafio.backend.repositories.PhoneRepository;
import com.desafio.backend.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Autowired 
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "admin", "123456", 1);
		User u2 = new User(null, "comum", "123456", 2);
	
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		Client c1 = new Client(null,"Raphael Magalhães", "12345678901",null,null,null);
		Client c2 = new Client(null,"Walter Pereira", "78945612307",null,null,null);
		
		clientRepository.saveAll(Arrays.asList(c1, c2));
		
		/*Address a1 = new Address(null,"QN07 Conjunto 18 Casa 37", "DF", "Brasilia", "Riacho Fundo 1",c1);
		Phone p1 = new Phone(null,"983601455", 2, c1);
		
		phoneRepository.save(p1);
		addressRepository.save(a1);
		
		
		c1.getPhones().add(p1);
		clientRepository.save(c1);
		

		c1.getAddresses().add(a1);
		clientRepository.save(c1);		*/
	}
}
