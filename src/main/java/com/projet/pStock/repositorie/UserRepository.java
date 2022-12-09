package com.projet.pStock.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.pStock.model.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
   public AppUser findByUsername(String username);
}
 