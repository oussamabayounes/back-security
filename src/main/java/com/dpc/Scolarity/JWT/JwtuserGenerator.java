package com.dpc.Scolarity.JWT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dpc.Scolarity.Domain.Utilisateur;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtuserGenerator {
	@Value("${jwt.secret}")
    public String SECRET;
	
	public String generate(Utilisateur user) {


        Claims claims = Jwts.claims()
                .setSubject(user.getUsername());
        claims.put("userId", String.valueOf(user.getId()));
        claims.put("email", user.getEmail());
        claims.put("firstname", user.getNom());
        claims.put("lastname", user.getPrenom());
        claims.put("lastpasswordresetdate", user.getLastPasswordResetDate());
        claims.put("password", user.getPassword());
        claims.put("phonenumber", user.getTelephone());
        claims.put("authorities", user.getAuthorities());
        claims.put("photo", user.getPhoto());
        
        
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

}
