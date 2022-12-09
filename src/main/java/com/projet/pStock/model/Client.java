package com.projet.pStock.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="client")
@Data @NoArgsConstructor  @ToString 
public class Client {
	public Client(String libelle, String contact, String email, String tel, String fax, String login,
			String pwd) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.contact = contact;
		this.email = email;
		this.tel = tel;
		this.fax = fax;
		this.login = login;
		this.pwd = pwd;
	}
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	//private String code;
	private String libelle;
	private String contact;
	private String email;
	private String tel;
	private String fax;
	private String login;
	private String pwd;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<AppRole> roles=new ArrayList<AppRole>();
	
	
}