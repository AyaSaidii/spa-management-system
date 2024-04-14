package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.RendezV;
import com.example.demo.repository.RendezVRepository;

@Service
public class RendezVService {
@Autowired

  private RendezVRepository rendezvRep;

  public RendezV getRendezv(Long id) {
	  return rendezvRep.findById(id).get();
  }
  public RendezV saveRendezv(RendezV p) {
	  return rendezvRep.save(p);
  }
  public RendezV updateRendezv(RendezV p) {
	  return rendezvRep.save(p);
  }
  public void deleteRendezv(RendezV p) {
	  rendezvRep.delete(p);
}
  public void deleteRendezvById(Long id) {
	  rendezvRep.deleteById(null);
	
}
  public List<RendezV>getAllRendezv(){
	 return  rendezvRep.findAll();
  }
}