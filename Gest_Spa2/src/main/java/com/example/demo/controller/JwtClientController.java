package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Client;
import com.example.demo.entity.JwtClient;
import com.example.demo.entity.Login;

@Controller
public class JwtClientController {
	@Autowired
	
	private JwtClient jwtClient;
	
	 @GetMapping("/login")
	    public String showLoginForm(Model model) {
	        model.addAttribute("login", new Login());
	        return "login/index";
	    }

	 @PostMapping("/login")
	    public String login(@ModelAttribute("login") Login login) {
	        String token = jwtClient.login(login.getNom(), login.getMotPasse());
	        if (token != null) {
	            
	            return "redirect:/";
	        } else {
	           
	            return "redirect:/login";
	        }
	    }
	   
}
