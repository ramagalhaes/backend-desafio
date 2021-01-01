package com.desafio.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.backend.entities.Address;
import com.desafio.backend.entities.Client;
import com.desafio.backend.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> client = repository.findById(id);
		return client.get();
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public Client updateData(Long id, Client client) {
		Client entity = repository.getOne(id);
		updateClient(entity, client);
		return repository.save(entity);
	}
	
	public Client insert(Client client) {
		return repository.save(client);
	}

	
	private void updateClient(Client entity, Client client) {
		entity.setCpf(client.getCpf());
		entity.setName(client.getName());
		entity.setAddresses(client.getAddress());
		entity.setEmails(client.getEmails());
		entity.setPhones(client.getPhones());
	}
}


