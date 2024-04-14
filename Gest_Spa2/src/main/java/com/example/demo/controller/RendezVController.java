package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Client;
import com.example.demo.entity.Prestation;
import com.example.demo.entity.RendezV;
import com.example.demo.entity.Salon;
import com.example.demo.services.ClientService;
import com.example.demo.services.PrestationService;
import com.example.demo.services.RendezVService;
import com.example.demo.services.SalonService;

@Controller
@RequestMapping("/rendezvs")
public class RendezVController {

    @Autowired
    private RendezVService rendevServ;
    
    @Autowired
    private SalonService salonService;
   
    @Autowired
    private PrestationService prestationService;
   
    @Autowired
    private ClientService clientService;

    
    @GetMapping
    public String showRendezV(Model model) {
        List<RendezV> rendezvs = rendevServ.getAllRendezv();
        model.addAttribute("rendezvs", rendezvs);
        return "rendezv/index";
    }

    @GetMapping("/{id}")
    public String showRendezVById(@PathVariable("id") Long id, Model model) {
        RendezV rendezv = rendevServ.getRendezv(id);
        model.addAttribute("rendezv", rendezv);
        return "rendezv/show";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
    	 List<Prestation> prestations = prestationService.getAllPrestation();
    	 model.addAttribute("prestations", prestations);
    	 List<Salon> salons = salonService.getAllSalon();
    	 model.addAttribute("salons", salons);
    	 List<Client> clients = clientService.getAllClient();
         model.addAttribute("clients", clients);
        model.addAttribute("rendezv", new RendezV());
        return "rendezv/create";
    }

    @PostMapping("/create")
    public String createRendezV(@ModelAttribute("rendezv") RendezV rendezv,@RequestParam("prestation")Long prestationId, @RequestParam("salon")Long salonId , @RequestParam("client")Long clientId) {
    	Prestation prestation=prestationService.getPrestation(prestationId);
    	rendezv.getPrestations().add(prestation);
    	Salon salon=salonService.getSalon(salonId);
    	rendezv.getSalons().add(salon);
    	Client client=clientService.getClient(clientId);
    	rendezv.getClients().add(client);
        rendevServ.saveRendezv(rendezv);
        return "redirect:/rendezvs";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
    	 List<Prestation> prestations = prestationService.getAllPrestation();
    	 model.addAttribute("prestations", prestations);
    	 List<Salon> salons = salonService.getAllSalon();
    	 model.addAttribute("salons", salons);
    	 List<Client> clients = clientService.getAllClient();
         model.addAttribute("clients", clients);
        RendezV rendezv = rendevServ.getRendezv(id);
        model.addAttribute("rendezv", rendezv);
        return "rendezv/edit";
    }

    @PostMapping("/edit")
    public String updateRendezV(@ModelAttribute("rendezv") RendezV rendezv,@RequestParam("prestation")Long prestationId, @RequestParam("salon")Long salonId , @RequestParam("client")Long clientId) {
       
    	Prestation prestation=prestationService.getPrestation(prestationId);
    	rendezv.getPrestations().add(prestation);
    	Salon salon=salonService.getSalon(salonId);
    	rendezv.getSalons().add(salon);
    	Client client=clientService.getClient(clientId);
    	rendezv.getClients().add(client);
    	rendevServ.updateRendezv(rendezv);
        return "redirect:/rendezvs";
    }

    @GetMapping("/{id}/delete")
    public String showDeleteConfirmation(@PathVariable("id") Long id, Model model) {
        RendezV rendezv = rendevServ.getRendezv(id);
        model.addAttribute("rendezv", rendezv);
        return "rendezv/delete";
    }

    @PostMapping("/delete")
    public String deleteRendezV(@ModelAttribute("rendezv") RendezV rendezv) {
        rendevServ.deleteRendezv(rendezv);
        return "redirect:/rendezvs";
    }
}
