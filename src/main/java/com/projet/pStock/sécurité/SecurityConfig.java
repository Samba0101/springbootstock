
  package com.projet.pStock.sécurité;
  
  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import
  org.springframework.context.annotation.Configuration;
import
  org.springframework.http.HttpMethod;
import
  org.springframework.security.config.annotation.authentication.builders.
  AuthenticationManagerBuilder;
import
  org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.
  EnableWebSecurity;
import
  org.springframework.security.config.annotation.web.configuration.
  WebSecurityConfigurerAdapter;
import
  org.springframework.security.config.http.SessionCreationPolicy;
import
  org.springframework.security.core.userdetails.UserDetailsService;
import
  org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
  
  
  @Configuration
  
  @EnableWebSecurity public class SecurityConfig extends
  WebSecurityConfigurerAdapter{
  
  @Autowired private UserDetailsService userDetailsService;
  
  @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	/*
	 * @Bean public PasswordEncoder encoder() { return new BCryptPasswordEncoder();
	 * }
	 */
  
  @Override protected void configure(AuthenticationManagerBuilder auth) throws
  Exception {
  
  auth.userDetailsService(userDetailsService).passwordEncoder(
  bCryptPasswordEncoder);
  
  }
  
  @Override protected void configure(HttpSecurity http) throws Exception {
  
  //http.formLogin(); 
  http.csrf().disable();
  http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
  STATELESS);
  //http.csrf().disable();
  http.authorizeRequests() .antMatchers(HttpMethod.OPTIONS).permitAll();
  http.authorizeRequests().antMatchers("/login/**","/register/**").permitAll();
  http.authorizeRequests().antMatchers("/appUsers/**","/appRoles/**").hasAuthority("ADMIN"); 
 // http.authorizeRequests().antMatchers(HttpMethod.PUT, "/Categories/**").hasAuthority("ADMIN");
  http.authorizeRequests().antMatchers(HttpMethod.PUT, "/Categories/**").hasAuthority("ADMIN");
  http.authorizeRequests() .antMatchers(HttpMethod.DELETE).hasAuthority("ADMIN");
  http.authorizeRequests().anyRequest().authenticated();
  http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
  http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
  
  }
  }
  
  
  
  
 