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
@Table(name="article")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Article {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	private String libelle;
	private int pa;
	private int tva;
	private int fodec;
	private int pv;
	private int stkinit;
	private int stock;
	private String image;
	private long id_cat;
	private long id_souscat;
}
