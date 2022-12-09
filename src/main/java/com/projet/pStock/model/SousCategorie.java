package com.projet.pStock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="souscategorie")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class SousCategorie {
	

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	private String codecategorie;
	private String libelle;
	//private long id_cat;
}
