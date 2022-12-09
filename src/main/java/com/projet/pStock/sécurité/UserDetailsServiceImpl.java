
  package com.projet.pStock.sécurité;
  
  import java.util.ArrayList; import java.util.Collection;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.security.core.GrantedAuthority; import
  org.springframework.security.core.authority.SimpleGrantedAuthority; import
  org.springframework.security.core.userdetails.User; import
  org.springframework.security.core.userdetails.UserDetails; import
  org.springframework.security.core.userdetails.UserDetailsService; import
  org.springframework.security.core.userdetails.UsernameNotFoundException;
  import org.springframework.stereotype.Service;
  
  import com.projet.pStock.model.AppUser; import
  com.projet.pStock.repositorie.AccountService;
  
  @Service public class UserDetailsServiceImpl implements UserDetailsService{
  
  @Autowired private AccountService accountService;
  
  @Override public UserDetails loadUserByUsername(String username) throws
  UsernameNotFoundException {
  
  AppUser appUser=accountService.loadByUserName(username); 
  if(appUser==null)
  throw new UsernameNotFoundException("Invaled User");
  Collection<GrantedAuthority> authorities=new ArrayList<>();
  appUser.getRole().forEach(r ->{ authorities.add(new
  SimpleGrantedAuthority(r.getRoleName())); });
  
  return new User(appUser.getUsername(),appUser.getPassword(),authorities);
  
  }
  
  }
 