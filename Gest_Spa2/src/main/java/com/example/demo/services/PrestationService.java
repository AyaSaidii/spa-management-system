package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Prestation;
import com.example.demo.repository.PrestationRepository;

@Service
public class PrestationService {
@Autowired

  private PrestationRepository prestatRep;

  public Prestation getPrestation(Long id) {
	  return prestatRep.findById(id).get();
  }
  public Prestation savePrestation(Prestation p) {
	  return prestatRep.save(p);
  }
  public Prestation updatePrestation(Prestation p) {
	  return prestatRep.save(p);
  }
  public void deletePrestation(Prestation p) {
	  prestatRep.delete(p);
}
  public void deletePrestationById(Long id) {
	  prestatRep.deleteById(null);
	
}
  public List<Prestation>getAllPrestation(){
	 return  prestatRep.findAll();
  }
}
