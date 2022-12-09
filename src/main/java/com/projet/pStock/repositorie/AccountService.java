package com.projet.pStock.repositorie;

import com.projet.pStock.model.AppUser;
import com.projet.pStock.model.AppRole;


public interface AccountService {

	public AppUser saveUser(String username,String password,String confirmPassword);
	public AppRole save(AppRole role);
	public AppUser loadByUserName(String username);
	public void addRoleToUser(String username,String role);
}
