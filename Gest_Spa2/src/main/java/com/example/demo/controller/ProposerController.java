package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Prestation;
import com.example.demo.entity.Proposer;
import com.example.demo.services.PrestationService;
import com.example.demo.services.ProposerService;

@Controller
@RequestMapping("proposers")
public class ProposerController {

    @Autowired
    private ProposerService proposerService;
    @Autowired
    private PrestationService prestationService;
    @GetMapping
    public String showProposers(Model model) {
        List<Proposer> proposers = proposerService.getAllProposer();
        model.addAttribute("proposers", proposers);
        return "proposer/index";
    }

    @GetMapping("/{id}")
    public String showProposerById(@PathVariable("id") Long id, Model model) {
        Proposer proposer = proposerService.getProposer(id);
        model.addAttribute("proposer", proposer);
        return "proposer/show";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
    	  List<Prestation> prestations = prestationService.getAllPrestation();
    	  model.addAttribute("prestations", prestations);
        model.addAttribute("proposer", new Proposer());
        return "proposer/create";
    }

    @PostMapping("/create")
    public String createProposer(@ModelAttribute("proposer") Proposer proposer,@RequestParam("prestation")Long prestationId) {
    	Prestation prestation=prestationService.getPrestation(prestationId);
    	proposer.getPrestations().add(prestation);
        proposerService.saveProposer(proposer);
        return "redirect:/proposers";
    }

  

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
    	List<Prestation> prestations = prestationService.getAllPrestation();
  	  model.addAttribute("prestations", prestations);
    	Proposer proposer = proposerService.getProposer(id);
        model.addAttribute("proposer", proposer);
        return "proposer/edit";
    }

    @PostMapping("/edit")
    public String updateProposer(@ModelAttribute("proposer") Proposer proposer,@RequestParam("prestation")Long prestationId) {
    	Prestation prestation=prestationService.getPrestation(prestationId);
    	proposer.getPrestations().add(prestation);
        proposerService.updateProposer(proposer);
        return "redirect:/proposers";
    }

    @GetMapping("/{id}/delete")
    public String showDeleteConfirmation(@PathVariable("id") Long id, Model model) {
    	Proposer proposer = proposerService.getProposer(id);
        model.addAttribute("proposer", proposer);
        return "proposer/delete";
    }

    @PostMapping("/delete")
    public String deleteProposition(@ModelAttribute("proposer") Proposer proposer) {
        proposerService.deleteProposer(proposer);
        return "redirect:/proposers";
    }
}
