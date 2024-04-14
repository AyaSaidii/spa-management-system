package com.example.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Salon;
import com.example.demo.repository.SalonRepository;


@Service

public class SalonService {
	@Autowired
	private SalonRepository   salonR;
	
	public Salon getSalon(Long id){
		return salonR.findById(id).get();
	}
	public Salon saveSalon(Salon m) {
		return salonR.save(m);
		}
	public Salon updateSalon(Salon m) {
		return salonR.save(m);
		}
	public void deleteSalon(Salon m) {
		salonR.delete(m);
		}
	public void deleteSalonById(Long id) {
		salonR.deleteById(id);
		}
	public List<Salon> getAllSalon(){
		return salonR.findAll();
	}
	

}

