package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {
   
	@Query("SELECT c FROM Client c WHERE c.nom = :nom AND c.mot_passe = :mot_passe")
	Client findByNomAndMot_passe(@Param("nom") String nom, @Param("mot_passe") String mot_passe);

	
}
