package com.dpc.Scolarity.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dpc.Scolarity.Domain.Utilisateur;

public interface Userrepos extends JpaRepository<Utilisateur, Long> {
	
String findByProfil(String profil);


}
