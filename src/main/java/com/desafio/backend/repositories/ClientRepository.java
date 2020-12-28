package com.desafio.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.backend.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
