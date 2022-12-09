package com.projet.pStock.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.pStock.model.Client;





public interface ClientRepositorie extends JpaRepository<Client, Long> {
	
	
}
