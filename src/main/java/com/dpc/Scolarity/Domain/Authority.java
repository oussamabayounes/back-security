package com.dpc.Scolarity.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
/**
 * @author slim
 *
 */
@Entity
@Table(name = "AUTHORITY")
public class Authority implements GrantedAuthority, Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@OneToMany(mappedBy = "authorities")
	private List<Utilisateur> users;

	@OneToMany(fetch=FetchType.EAGER, mappedBy = "authority")
	private List<AccessUrl> accessUrls;

	@Column(name = "name" )
	String name;
 
	@Column(name = "description")
	String description;

	private Boolean archiver ;
	



	@Override
	public String getAuthority() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// @JsonIgnore
	public String getName() {
		return name;
	}

	// @JsonIgnore
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public List<Utilisateur> getUsers() {
		return users;
	}

	public void setUsers(List<Utilisateur> users) {
		this.users = users;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public List<AccessUrl> getAccessUrls() {
		return accessUrls;
	}

	public void setAccessUrls(List<AccessUrl> accessUrls) {
		this.accessUrls = accessUrls;
	}

	public Boolean getArchiver() {
		return archiver;
	}

	public void setArchiver(Boolean archiver) {
		this.archiver = archiver;
	}

}
