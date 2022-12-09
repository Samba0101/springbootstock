package com.projet.pStock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projet.pStock.model.AppUser;
import com.projet.pStock.repositorie.AccountService;

import lombok.Data;

@RestController
public class UserController {
	
	 @Autowired
	 private AccountService accountService;
	 
	 @PostMapping("/register")
	public AppUser register(@RequestBody UserForm userForm) {
		
		return accountService.saveUser(userForm.getUsername(),userForm.getPassword(),userForm.getConfirmPassword());
	}

}
 @Data
 class UserForm{
	private String username;
	private String password;
	private String confirmPassword;
	
	
}