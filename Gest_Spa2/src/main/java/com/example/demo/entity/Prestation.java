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
public class Prestation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

		private Long id;
		private String Libelle;
		
		
		@ManyToMany
		private List<Salon>salons=new ArrayList<>();

        
		public Prestation()    {
			
			super();
			
		}


		public Prestation(Long id, String libelle, List<Salon> salons) {
			super();
			this.id = id;
			Libelle = libelle;
			this.salons = salons;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getLibelle() {
			return Libelle;
		}


		public void setLibelle(String libelle) {
			Libelle = libelle;
		}


		public List<Salon> getSalons() {
			return salons;
		}


		public void setSalons(List<Salon> salons) {
			this.salons = salons;
		}


		@Override
		public String toString() {
			return "Prestation [id=" + id + ", Libelle=" + Libelle + ", salons=" + salons + "]";
		}
		
		
		
	

}
