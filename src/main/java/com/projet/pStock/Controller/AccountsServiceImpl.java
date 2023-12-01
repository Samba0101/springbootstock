
  package com.projet.pStock.Controller;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
  org.springframework.stereotype.Service; import
  org.springframework.transaction.annotation.Transactional;
  
  import com.projet.pStock.model.AppRole; import
  com.projet.pStock.model.AppUser; import
  com.projet.pStock.repositorie.AccountService; import
  com.projet.pStock.repositorie.RoleRepository; import
  com.projet.pStock.repositorie.UserRepository;
  
  @Service
  @Transactional 
  public class AccountsServiceImpl implements AccountService{
  
  @Autowired 
  private UserRepository userRepository;
  
  @Autowired 
  private RoleRepository roleRepository;
  
  @Autowired 
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  
  @Override 
  public AppUser saveUser(String username, String password, String confirmPassword) {
	  AppUser user=userRepository.findByUsername(username);
  if(user != null) throw new RuntimeException("L'utilisateur existe déja");
  //if(!password.equals(confirmPassword))
  if (!password.equals(confirmPassword))throw new
  RuntimeException("Confirmer votre mot de passe"); 
  AppUser appUser=new AppUser();
  appUser.setActived(true); 
  appUser.setUsername(username);
  appUser.setPassword(bCryptPasswordEncoder.encode(password));
  //appUser.setPassword(password);
  userRepository.save(appUser);
  addRoleToUser(username, "USER");
  return appUser; }
  
  @Override public AppRole save(AppRole role) { // TODO Auto-generated method
 return roleRepository.save(role); }
  
  @Override public AppUser loadByUserName(String username) { return
  userRepository.findByUsername(username); }
  
  @Override 
  public void addRoleToUser(String username, String role) 
  {
	  AppUser appUser =userRepository.findByUsername(username); 
	  AppRole appRole =roleRepository.findByroleName(role); 
	  appUser.getRole().add(appRole); 
	  }
  }
 