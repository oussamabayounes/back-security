package com.dpc.Scolarity.Domain;

import java.io.Serializable;
/**
 * @author slim
 *
 */
public class UtilisateurTokenState implements Serializable{
    private String access_token;
    private Long expires_in;
	private String  Nom;
	private String Prenom ;
	private String Photo ;
	private String profil;
	private String username;
	private String password;
	private String email ;
	private Long Cin ;
	
    public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCin() {
		return Cin;
	}

	public void setCin(Long cin) {
		Cin = cin;
	}

	public UtilisateurTokenState(String access_token, Long expires_in, String nom, String prenom, String profil) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in;
		Nom = nom;
		Prenom = prenom;
		this.profil = profil;
	}

	public UtilisateurTokenState(String access_token, Long expires_in, String nom, String prenom, String profil,
			String username, String email) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in;
		Nom = nom;
		Prenom = prenom;
		this.profil = profil;
		this.username = username;
		this.email = email;
	}

	public UtilisateurTokenState(String access_token, Long expires_in, String profil) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in;
		this.profil = profil;
	}

	public UtilisateurTokenState() {
        this.access_token = null;
        this.expires_in = null;
        this.profil = null ;
    }

    public UtilisateurTokenState(String access_token, long expires_in) {
        this.access_token = access_token;
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }
}