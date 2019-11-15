/**
 * 
 */
package com.dpc.Scolarity.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpc.Scolarity.Domain.AccessUrl;
import com.dpc.Scolarity.Domain.Authority;
import com.dpc.Scolarity.Domain.GestionUrl;
import com.dpc.Scolarity.Domain.Utilisateur;
import com.dpc.Scolarity.Repository.IAccessUrl;
import com.dpc.Scolarity.Repository.IAuthority;
import com.dpc.Scolarity.Repository.IGestionUrl;
import com.dpc.Scolarity.Repository.IUtilisateur;

/**
 * @author slim
 *
 */
@Service
public class AccessUrlService {
	@Autowired
	IAccessUrl iAccessUrl;
	@Autowired
	IGestionUrl iGestionUrl;
	@Autowired
	IAuthority iAuthority;
    @Autowired
    IUtilisateur userRepository;
	public AccessUrl getAccessByGestionAndRole(String gestion,String role,String username){
		System.out.println("username"+username);
		Utilisateur u = this.userRepository.findByUsername(username);
		System.out.println("gestion a lentree"+gestion);
		System.out.println("role a lentree"+role);
		GestionUrl gestionurl = new GestionUrl();
		Authority authority = new Authority();
		
		
		gestionurl=this.iGestionUrl.findByGestion(gestion);
		System.out.println("Gestion des roles"+gestionurl);
		//authority =this.iAuthority.findByDescriptionAndEtablissement(role,u.getEtablissement());
		System.out.println("role"+authority);
		return this.iAccessUrl.findByauthorityAndGestionUrl(authority, gestionurl);
		
		
		
		
	}

}
