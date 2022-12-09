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
@Table(name="fournisseur")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Fournisseur {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	private String libelle;
	private String contact;
	private String email;
	private String tel;
	private String fax;
	private String matfisc;
	private String asuj;
	private String timbre;
	private double soldeInit;
	private String solde;
}
