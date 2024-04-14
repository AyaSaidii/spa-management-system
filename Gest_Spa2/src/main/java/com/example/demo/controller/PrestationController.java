package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Prestation;
import com.example.demo.entity.Salon;
import com.example.demo.services.PrestationService;
import com.example.demo.services.SalonService;



@Controller
@RequestMapping("prestations")
public class PrestationController {

    @Autowired
    private PrestationService prestationService;
    @Autowired
    private SalonService salonService;

    @GetMapping
    public String showPrestations(Model model) {
        List<Prestation> prestations = prestationService.getAllPrestation();
        model.addAttribute("prestations", prestations);
        return "prestation/index";
    }

    @GetMapping("/{id}")
    public String showPrestationById(@PathVariable("id") Long id, Model model) {
        Prestation prestation = prestationService.getPrestation(id);
        model.addAttribute("prestation", prestation);
        return "prestation/show";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
    	 
        model.addAttribute("prestation", new Prestation());
        return "prestation/create";
    }

    @PostMapping("/create")
    public String createPrestation(@ModelAttribute("prestation") Prestation prestation) {
    	
        prestationService.savePrestation(prestation);
        return "redirect:/prestations";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
    	
        Prestation prestation = prestationService.getPrestation(id);
        model.addAttribute("prestation", prestation);
        return "prestation/edit";
    }

    @PostMapping("/edit")
    public String updatePrestation(@ModelAttribute("prestation") Prestation prestation ) {
    	
        prestationService.updatePrestation(prestation);
        return "redirect:/prestations";
    }

    @GetMapping("/{id}/delete")
    public String showDeleteConfirmation(@PathVariable("id") Long id, Model model) {
        Prestation prestation = prestationService.getPrestation(id);
        model.addAttribute("prestation", prestation);
        return "prestation/delete";
    }

    @PostMapping("/delete")
    public String deletePrestation(@ModelAttribute("prestation") Prestation prestation) {
        prestationService.deletePrestation(prestation);
        return "redirect:/prestations";
    }
}
