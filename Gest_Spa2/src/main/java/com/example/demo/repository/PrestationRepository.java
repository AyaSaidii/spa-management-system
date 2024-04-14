package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.example.demo.entity.Prestation;



public interface PrestationRepository extends JpaRepository<Prestation,Long> {

}
