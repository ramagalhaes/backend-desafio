package com.desafio.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.backend.entities.User;
import com.desafio.backend.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> deleteById(@PathVariable Long id) {
			service.deleteById(id);
			return ResponseEntity.noContent().build();
		}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> updateData(@PathVariable Long id, @RequestBody User user){
			user = service.updateData(id, user);
			return ResponseEntity.ok().body(user);
	}
	
	
	} 
