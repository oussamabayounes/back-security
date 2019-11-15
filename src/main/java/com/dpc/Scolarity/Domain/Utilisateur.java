package com.dpc.Scolarity.Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * @author slim
 *
 */

@Entity
public class Utilisateur implements UserDetails, Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private    Long id ;
	private String  nom;
	private String prenom ;
	private String remarque ;
	@Temporal(TemporalType.DATE)
	private Date date_naissance ;
	private String sexe ;
	private String SituationFamiliale ;
	private String Photo ;
	private Long Cin ;
	private Boolean parain ;
	@Column(name = "last_password_reset_date")
	private Date lastPasswordResetDate;
	@ManyToOne
	private Authority authorities;
	@Column(name = "phone_number")
	private String telephone;
	private Boolean archiver ;
	@Temporal(TemporalType.DATE)
	private Date datedembauche ;
	private Long nbrheures;
	private Long anciennete;
	

	
	
	
	public Boolean getArchiver() {
		return archiver;
	}
	public void setArchiver(Boolean archiver) {
		this.archiver = archiver;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	@Column(name = "enabled")
	private boolean enabled;
	@Column(name = "username", unique = true)
	private String username;
	private String password;
	public void setPassword(String password) {
		this.password = password;
	}
	
	private String email ;
	private String num_passport ;
	@Column(name = "profil")
	private String profil;
	
	

	 
	 
	 
	 
	 
	 
	 public Date getDatedembauche() {
		return datedembauche;
	}
	public void setDatedembauche(Date datedembauche) {
		this.datedembauche = datedembauche;
	}
	public Long getNbrheures() {
		return nbrheures;
	}
	public void setNbrheures(Long nbrheures) {
		this.nbrheures = nbrheures;
	}
	public Long getAnciennete() {
		return anciennete;
	}
	public void setAnciennete(Long anciennete) {
		this.anciennete = anciennete;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getSituationFamiliale() {
		return SituationFamiliale;
	}
	public void setSituationFamiliale(String situationFamiliale) {
		SituationFamiliale = situationFamiliale;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public Long getCin() {
		return Cin;
	}
	public void setCin(Long cin) {
		this.Cin = cin;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNum_passport() {
		return num_passport;
	}
	public void setNum_passport(String num_passport) {
		this.num_passport = num_passport;
	}
	public Utilisateur() {
		super();
	}
	

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<Authority> auth = new ArrayList<Authority>();
		auth.add(authorities);
		return auth;
	}
	public void setAuthorities(Authority authorities) {
		this.authorities = authorities;
	}
	public Boolean getParain() {
		return parain;
	}
	public void setParain(Boolean parain) {
		this.parain = parain;
	}
	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}
	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}


	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	

	

	
	

}
