package com.desafio.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.backend.entities.Client;
import com.desafio.backend.repositories.AddressRepository;
import com.desafio.backend.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Autowired 
	private AddressRepository addressRepository;
	
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
		client.getAddresses().forEach(x -> addressRepository.save(x));
		return repository.save(client);
	}

	
	private void updateClient(Client entity, Client client) {
		entity.setCpf(client.getCpf());
		entity.setName(client.getName());
	}
}