package com.projet.pStock.repositorie;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.pStock.model.Categorie;

public interface CategorieRepositorie extends JpaRepository<Categorie, Long>{
		
	}

