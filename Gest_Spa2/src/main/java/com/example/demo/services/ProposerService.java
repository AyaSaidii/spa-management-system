package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Proposer;
import com.example.demo.repository.ProposerRepository;



@Service
public class ProposerService {
@Autowired

  private ProposerRepository proposeRep;

  public Proposer getProposer(Long id) {
	  return proposeRep.findById(id).get();
  }
  public Proposer saveProposer(Proposer p) {
	  return proposeRep.save(p);
  }
  public Proposer updateProposer(Proposer p) {
	  return proposeRep.save(p);
  }
  public void deleteProposer(Proposer p) {
	  proposeRep.delete(p);
}
  public void deleteProposerById(Long id) {
	  proposeRep.deleteById(null);
	
}
  public List<Proposer>getAllProposer(){
	 return  proposeRep.findAll();
  }

}
