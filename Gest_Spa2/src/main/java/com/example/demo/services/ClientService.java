package com.example.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;


@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRep;
	
	public Client getClient(Long id) {
		return  clientRep.findById(id).get();
	}
	public Client saveClient(Client c) {
		return clientRep.save(c);
	}
	public Client updateClient(Client c) {
		return clientRep.save(c);
	}
	public void deleteClient(Client c) {
		clientRep.delete(c);
	}
	public void deleteClientById(Long id) {
		clientRep.deleteById(id);
	}
	public List<Client>getAllClient(){
		return clientRep.findAll();
	}
	
	

}
