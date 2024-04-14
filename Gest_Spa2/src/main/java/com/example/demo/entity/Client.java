package com.example.demo.entity;



import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long  id;
	private String nom;
	private String prenom;
	private String num_tel;
	private Date  date_Naiss;
	private String mot_passe;
		         

		public Client()    {
			
			super();
			
		}


		public Client(Long id, String nom, String prenom, String num_tel, Date date_Naiss) {
			
			super();
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.num_tel = num_tel;
			this.date_Naiss = date_Naiss;
			
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}


		public String getPrenom() {
			return prenom;
		}


		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}


		public String getNum_tel() {
			return num_tel;
		}


		public void setNum_tel(String num_tel) {
			this.num_tel = num_tel;
		}


		public Date getDate_Naiss() {
			return date_Naiss;
		}


		public void setDate_Naiss(Date date_Naiss) {
			this.date_Naiss = date_Naiss;
		}


		@Override
		public String toString() {
			return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", num_tel=" + num_tel
					+ ", date_Naiss=" + date_Naiss + "]";
		}


		public String getMot_passe() {
			return mot_passe;
		}


		public void setMot_passe(String mot_passe) {
			this.mot_passe = mot_passe;
		}


	

	
			

	

}
