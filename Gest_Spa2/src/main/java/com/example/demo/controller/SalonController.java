package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Prestation;
import com.example.demo.entity.Salon;
import com.example.demo.services.SalonService;
import com.example.demo.services.PrestationService;
import org.springframework.ui.Model; 

@Controller
@RequestMapping("salons")
public class SalonController {
@Autowired
private SalonService salonServ;
@Autowired
private PrestationService prestationService;
@GetMapping

public String showSalon(Model m) {
	List<Salon>salons=salonServ.getAllSalon();
	m.addAttribute("salons", salons);
	return "salon/index";
}
@GetMapping("/{id}")
public String showSalonById(@PathVariable("id") Long id,Model m) {//laisse passer notre var a html
	//pathvariable retourne les variable qui passe dans le path
	Salon salon=salonServ.getSalon(id);
	m.addAttribute("salon", salon);
	return "salon/show";
	
}
@GetMapping("/create")
public String showCreateForm(Model m) {//laisse passer notre var a html
	//pathvariable retourne les variable qui passe dans le path
	   List<Prestation> prestations = prestationService.getAllPrestation();
       m.addAttribute("prestations", prestations);
	m.addAttribute("salon", new Salon());
	return "salon/create";
	
}
@PostMapping("/create")
public String createSalon(@ModelAttribute("salon") Salon salon,@RequestParam("prestation")Long prestationId) {//laisse passer notre var a html
	//pathvariable retourne les variable qui passe dans le path
	Prestation prestation=prestationService.getPrestation(prestationId);
	salon.getPrestations().add(prestation);
	salonServ.saveSalon(salon);
	return "redirect:/salons";
	
}
@GetMapping("/{id}/edit")
public String showEditForm(@PathVariable("id") Long id,Model m) {//laisse passer notre var a html
	//pathvariable retourne les variable qui passe dans le path
	 List<Prestation> prestations = prestationService.getAllPrestation();
      m.addAttribute("prestations", prestations);
	Salon salon=salonServ.getSalon(id);
	m.addAttribute("salon", salon);
	return "salon/edit";
	
}
@PostMapping("/edit")
public String updateSalon(@ModelAttribute("salon") Salon salon ,@RequestParam("prestation")Long prestationId) {//laisse passer notre var a html
	//pathvariable retourne les variable qui passe dans le path
	Prestation prestation=prestationService.getPrestation(prestationId);
	salon.getPrestations().add(prestation);
	salonServ.updateSalon(salon);
	return "redirect:/salons";
	
}
@GetMapping("/{id}/delete")
public String showDeleteConfirmation(@PathVariable("id") Long id,Model m) {//laisse passer notre var a html
	//pathvariable retourne les variable qui passe dans le path
	Salon salon=salonServ.getSalon(id);
	m.addAttribute("salon",salon);
	return "salon/delete";
	
}
@PostMapping("/delete")
public String deleteSalon(@ModelAttribute("salon") Salon salon) {//laisse passer notre var a html
	//pathvariable retourne les variable qui passe dans le path
	salonServ.deleteSalon(salon);
	return "redirect:/salons";
}




}
