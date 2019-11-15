package com.dpc.Scolarity.Domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * @author slim
 *
 */
@Entity
public class AccessUrl implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	
	@ManyToOne
	private GestionUrl gestionUrl;

	
	@ManyToOne
	private Authority authority;

	private Boolean getallop;
	private Boolean getbyidop;
	private Boolean addop;
	private Boolean updateop;
	private Boolean removeop;




	public AccessUrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public GestionUrl getGestionUrl() {
		return gestionUrl;
	}

	public void setGestionUrl(GestionUrl gestionUrl) {
		this.gestionUrl = gestionUrl;
	}

	@JsonIgnore
	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public Boolean getGetallop() {
		return getallop;
	}

	public void setGetallop(Boolean getallop) {
		this.getallop = getallop;
	}

	public Boolean getGetbyidop() {
		return getbyidop;
	}

	public void setGetbyidop(Boolean getbyidop) {
		this.getbyidop = getbyidop;
	}

	public Boolean getAddop() {
		return addop;
	}

	public void setAddop(Boolean addop) {
		this.addop = addop;
	}

	public Boolean getUpdateop() {
		return updateop;
	}

	public void setUpdateop(Boolean updateop) {
		this.updateop = updateop;
	}

	public Boolean getRemoveop() {
		return removeop;
	}

	public void setRemoveop(Boolean removeop) {
		this.removeop = removeop;
	}
	
	public String getGestion() {
		System.out.println(gestionUrl.getGestion());
		return gestionUrl.getGestion();
	}

}
