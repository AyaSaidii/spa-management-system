package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Proposer;

public interface ProposerRepository extends JpaRepository<Proposer, Long>{

}
