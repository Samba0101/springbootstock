package com.projet.pStock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.projet.pStock.model.AppUser;
import com.projet.pStock.model.Categorie;
import com.projet.pStock.model.Client;
import com.projet.pStock.repositorie.AccountService;
import com.projet.pStock.repositorie.CategorieRepositorie;
import com.projet.pStock.repositorie.ClientRepositorie;
import com.projet.pStock.repositorie.UserRepository;

@SpringBootApplication
public class PStockApplication implements  CommandLineRunner{
	@Autowired
	private ClientRepositorie repositorie;
	@Autowired
	private CategorieRepositorie cat_repositorie;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AccountService accountServie ;
	public static void main(String[] args) {
		SpringApplication.run(PStockApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//clientRepositorie.save(new Client("samba","samba01","sebie","samba","saa",77,"ssd"));
			repositorie.save(new Client("samba","sar","samba01","sebie","samba","saa","sssssss"));
		
		//cat_repositorie.save(new Categorie("Fruit","pomme"));
		/*accountServie.saveUser("kine", "kine", "kine");
		accountServie.saveUser("fatou", "1234", "1234");*/
		//accountServie.saveUser("anna", "anna", "anna");
		//accountServie.saveUser("yaya", "yaya","yaya");
		//accountServie.saveUser("yacine", "1234", "1234");
		//userRepository.save(new AppUser("fatou", "1234", "1234"));
		
	
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
