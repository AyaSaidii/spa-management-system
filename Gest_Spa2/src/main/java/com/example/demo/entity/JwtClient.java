package com.example.demo.entity;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ClientRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class JwtClient {
	@Autowired
	private ClientRepository clientRepository; 
	
	private static final String KEY="uNFr74o3CWeIyMV/K5Up/m52C5mm5vt6pbfZav4zz3k=";   //static accessible par clasee ne peut pas se modifier
    private static final long EXPIRATION =3600000;//1h
    public static String generateToken(Long id) {
    	 Date currentDate=new Date();
    	 Date expirationDate=new Date(currentDate.getTime()+EXPIRATION);
    	
    	return  Jwts.builder().setSubject(String.valueOf(id)).setIssuedAt(currentDate).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS256, KEY).compact();
   }
    public static boolean TestValidationToken(String token) {
    	try {
    			Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
    			return true;
    	}
    	catch(Exception e) {
    		
    		return false;
    	}
    	
    	
    }
    public String login(String nom,String motPasse) {
    	
    	Client client =clientRepository.findByNomAndMot_passe(nom, motPasse);//cherche le client avec le nom et mot_pass
        if(client!=null) {
        	return generateToken(client.getId());
        }
        return null;
    }
    
    
    
    
}
