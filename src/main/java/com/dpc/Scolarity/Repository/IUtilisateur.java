package com.dpc.Scolarity.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dpc.Scolarity.Domain.Authority;

import com.dpc.Scolarity.Domain.Utilisateur;



public interface IUtilisateur extends JpaRepository<Utilisateur, Long> {


	
	
	@Query("SELECT p FROM Utilisateur p WHERE p.authorities = :authority ")
    public List<Utilisateur> getusersinauthority(@Param("authority") Authority authority);
	

	@Query("SELECT p FROM Utilisateur p WHERE p.profil = :profil ")
    public List<Utilisateur> getusersbyprofil(@Param("profil") String profil);
	
	Utilisateur findByUsername( String username );
	List<Utilisateur> findByProfil(String profil);
	
	

Utilisateur findByEmail(String email);


	Utilisateur findByNomAndPrenom(String nom , String Prenom );


	public List<Utilisateur> findByProfilAndArchiverIsFalse(String profil);


	public Utilisateur findById(Long id);



	
	
}
