package com.projet.pStock.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.projet.pStock.model.AppRole;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<AppRole, Long>{
    public AppRole findByroleName(String roleName);
  
}
 