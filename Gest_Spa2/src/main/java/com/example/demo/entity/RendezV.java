package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class RendezV implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateRend;
    private Date dateDemande;

    @ManyToMany
    private List<Client> clients = new ArrayList<>();

    @ManyToMany
    private List<Prestation> prestations = new ArrayList<>();

    @ManyToMany
    private List<Salon> salons = new ArrayList<>();

    public RendezV() {
        super();
    }

  

    public RendezV(Long id, Date dateRend, Date dateDemande, List<Client> clients, List<Prestation> prestations,
			List<Salon> salons) {
		super();
		this.id = id;
		this.dateRend = dateRend;
		this.dateDemande = dateDemande;
		this.clients = clients;
		this.prestations = prestations;
		this.salons = salons;
	}



	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateRend() {
        return dateRend;
    }

    public void setDateRend(Date dateRend) {
        this.dateRend = dateRend;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Prestation> getPrestations() {
        return prestations;
    }

    public void setPrestations(List<Prestation> prestations) {
        this.prestations = prestations;
    }

    public List<Salon> getSalons() {
        return salons;
    }

    public void setSalons(List<Salon> salons) {
        this.salons = salons;
    }

    @Override
    public String toString() {
        return "RendezVous [id=" + id + ", dateRend=" + dateRend + ", dateDemande=" + dateDemande + ", clients="
                + clients + ", prestations=" + prestations + ", salons=" + salons + "]";
    }
}
