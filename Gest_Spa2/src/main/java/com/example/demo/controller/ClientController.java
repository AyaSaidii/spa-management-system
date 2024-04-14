package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Client;
import com.example.demo.services.ClientService;



import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientSer;

    @GetMapping
    public String showClients(Model model) {
    	List<Client> clients = clientSer.getAllClient();
        model.addAttribute("clients", clients);
        return "client/index";
    }

    @GetMapping("/{id}")
    public String showClientById(@PathVariable("id") Long id, Model model) {
        Client client = clientSer.getClient(id);
        model.addAttribute("client", client);
        return "client/show";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("client", new Client());
        return "client/create";
    }

    @PostMapping("/create")
    public String createClient(@ModelAttribute("client") Client client) {
    	clientSer.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Client client = clientSer.getClient(id);
        model.addAttribute("client", client);
        return "client/edit";
    }

    @PostMapping("/edit")
    public String updateClient(@ModelAttribute("client") Client client) {
    	clientSer.updateClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/{id}/delete")
    public String showDeleteConfirmation(@PathVariable("id") Long id, Model model) {
        Client client = clientSer.getClient(id);
        model.addAttribute("client", client);
        return "client/delete";
    }

    @PostMapping("/delete")
    public String deleteClient(@ModelAttribute("client") Client client) {
    	clientSer.deleteClient(client);
        return "redirect:/clients";
    }
}
