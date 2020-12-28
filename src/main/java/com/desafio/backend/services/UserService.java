package com.desafio.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.backend.entities.User;
import com.desafio.backend.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public User updateData(Long id, User user) {
		User entity = repository.getOne(id);
		updateUser(entity, user);
		return repository.save(entity);
	}

	
	private void updateUser(User entity, User user) {
		entity.setCpf(user.getCpf());
		entity.setName(user.getName());
	}
}
