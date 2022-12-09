package com.projet.pStock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.projet.pStock.model.Categorie;
import com.projet.pStock.model.Client;
import com.projet.pStock.repositorie.CategorieRepositorie;
import com.projet.pStock.repositorie.ClientRepositorie;

@SpringBootApplication
public class PStockApplication implements  CommandLineRunner{
	@Autowired
	private ClientRepositorie repositorie;
	@Autowired
	private CategorieRepositorie cat_repositorie;
	public static void main(String[] args) {
		SpringApplication.run(PStockApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//clientRepositorie.save(new Client("samba","samba01","sebie","samba","saa",77,"ssd"));
			repositorie.save(new Client("samba","sar","samba01","sebie","samba","saa","sssssss"));
		
		cat_repositorie.save(new Categorie("Fruit","pomme"));
	}

	@Bean
	BCryptPasswordEncoder getBCPE() {
		
		return new BCryptPasswordEncoder();
	}


	/*@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}*/

}
