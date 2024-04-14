package com.example.demo.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Salon implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	private String Nom;
	private String Adresse;
	
	@ManyToMany
	private List<Prestation>prestations=new ArrayList<>();
	
	
	public Salon() {
		
		    super();
	}

	
	public Salon(Long id, String nom, String adresse) {
		super();
		this.id = id;
		Nom = nom;
		Adresse = adresse;
	}
	
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNom() {
		return Nom;
	}
	
	public void setNom(String nom) {
		Nom = nom;
	}
	
	public String getAdresse() {
		return Adresse;
	}
	
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	@Override
	public String toString() {
		return "Salon [id=" + id + ", Nom=" + Nom + ", Adresse=" + Adresse + "]";
	}


	public List<Prestation> getPrestations() {
		return prestations;
	}


	public void setPrestations(List<Prestation> prestations) {
		this.prestations = prestations;
	}
	
	
	
	
	
}
