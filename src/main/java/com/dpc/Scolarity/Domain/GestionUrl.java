package com.dpc.Scolarity.Domain;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * @author slim
 *
 */
@Entity
public class GestionUrl implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String gestion;
	private String getallop;
	private String getbyidop;
	private String addop;
	private String updateop;
	private String removeop;

	@OneToMany(mappedBy = "gestionUrl")
	private List<AccessUrl> accessUrls;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGestion() {
		return gestion;
	}

	public void setGestion(String gestion) {
		this.gestion = gestion;
	}

	public String getGetallop() {
		return getallop;
	}

	public void setGetallop(String getallop) {
		this.getallop = getallop;
	}

	public String getGetbyidop() {
		return getbyidop;
	}

	public void setGetbyidop(String getbyidop) {
		this.getbyidop = getbyidop;
	}

	public String getAddop() {
		return addop;
	}

	public void setAddop(String addop) {
		this.addop = addop;
	}

	public String getUpdateop() {
		return updateop;
	}

	public void setUpdateop(String updateop) {
		this.updateop = updateop;
	}

	public String getRemoveop() {
		return removeop;
	}

	public void setRemoveop(String removeop) {
		this.removeop = removeop;
	}

	@JsonIgnore
	public List<AccessUrl> getAccessUrls() {
		return accessUrls;
	}

	public void setAccessUrls(List<AccessUrl> accessUrls) {
		this.accessUrls = accessUrls;
	}

}
