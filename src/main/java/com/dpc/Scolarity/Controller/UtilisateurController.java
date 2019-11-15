package com.dpc.Scolarity.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dpc.Scolarity.Domain.*;
import com.dpc.Scolarity.Repository.*;
import com.dpc.Scolarity.param.DisableParam;


/**
 * @author slim
 *
 */





@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/user", produces = MediaType.APPLICATION_JSON_VALUE)

public class UtilisateurController {

    
    @Autowired
    IUtilisateur userRepository;
    
    @Autowired 
    IUtilisateur iUtilisateur;
    
    
    @Autowired
    IAuthority iAuthority;

    

    
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	//@PreAuthorize("hasRole('ADMIN')")
	public  @ResponseBody Map<String, Boolean> adduser(Model model ,String username, @RequestBody Utilisateur user ) {
		Boolean response;
		try {
			Utilisateur u = this.userRepository.findByUsername(username);
			
			System.out.println("profil "+user.getNom());
			String authorityname = user.getProfil().replaceAll(" ", "_");
			Authority authority = iAuthority.findByname("ROLE_"+authorityname);
			user.setAuthorities(authority);
			System.out.println("auth"+ authority.getName());
			user.setLastPasswordResetDate(new Date(System.currentTimeMillis()));
			user.setEnabled(true);
		//	user.setEtablissement(u.getEtablissement());
			user.setArchiver(false);
			userRepository.save(user);
			
			
			
			Map<String, Boolean> success = new TreeMap<String, Boolean>();
			success.put("response", true);
			
			String email=user.getEmail();
			//this.mailservice.EnvoyerEmailAddUser(user);
			
			return success;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
			Map<String, Boolean> echec = new TreeMap<String, Boolean>();
			echec.put("response", false);
			return echec;
		}
		
		
	}
	
	//@PreAuthorize("hasRole('Admi')")
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public @ResponseBody List<Utilisateur> getalluser(Model model) {
		return userRepository.findAll();
	}

	@RequestMapping(value = "/getallbyprofil", method = RequestMethod.GET)
	public @ResponseBody List<Utilisateur> getalluserbyprofil(Model model, String profil) {
		return userRepository.findByProfil(profil);
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/getbyusername", method = RequestMethod.GET)
	public  Utilisateur getalluser(Model model, String username) {
		return userRepository.findByUsername(username);
	}
	
	@RequestMapping(value = "/disable", method = RequestMethod.POST)
	public  @ResponseBody Map<String, Boolean> diableuser(Model model, @RequestBody DisableParam disableParam) {
		Utilisateur utilisateur = userRepository.findByUsername(disableParam.getUsername());
		utilisateur.setEnabled(disableParam.getDisable());
		//System.out.println(disableParam.getUsername()+disableParam.getDisable());
		try {
			 userRepository.save(utilisateur);
			 Map<String, Boolean> success = new TreeMap<String, Boolean>();
				success.put("response", true);
				return success;
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Boolean> echec = new TreeMap<String, Boolean>();
			echec.put("response", false);
			return echec;
		}		
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public   @ResponseBody Map<String, Boolean> removeuser(Model model, @RequestBody List<String> usernames) {
		Utilisateur utilisateurtodelete ;
		try {
			//System.out.println(usernames.size());
			for(int i=0; i<usernames.size();i++) {
				utilisateurtodelete = null;
				System.out.println(usernames.get(i));
				utilisateurtodelete = userRepository.findByUsername(usernames.get(i));
				if(utilisateurtodelete!=null) 
					
				userRepository.delete(utilisateurtodelete);
				
				
			
			}
			
			Map<String, Boolean> success = new TreeMap<String, Boolean>();
			success.put("response", true);
			return success;
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Boolean> echec = new TreeMap<String, Boolean>();
			echec.put("response", false);
			return echec;
		}
	}
	
	
	@RequestMapping(value = "/archiver", method = RequestMethod.POST)
	public   @ResponseBody Map<String, Boolean> archiver(Model model, @RequestBody List<String> usernames) {
		Utilisateur utilisateurtoarchive ;
		try {
			//System.out.println(usernames.size());
			for(int i=0; i<usernames.size();i++) {
				utilisateurtoarchive = null;
				System.out.println(usernames.get(i));
				utilisateurtoarchive = userRepository.findByUsername(usernames.get(i));
				
				if(utilisateurtoarchive!=null) 
					utilisateurtoarchive.setArchiver(true);
				userRepository.save(utilisateurtoarchive);
				
			
				
			
			}
			
			Map<String, Boolean> success = new TreeMap<String, Boolean>();
			success.put("response", true);
			return success;
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Boolean> echec = new TreeMap<String, Boolean>();
			echec.put("response", false);
			return echec;
		}
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Boolean> updateuser(Model model, @RequestBody Utilisateur user) {
	

		Utilisateur utilisateurtoupdate = userRepository.findByUsername(user.getUsername());
		
		if(utilisateurtoupdate!=null) {
			utilisateurtoupdate.setEmail(user.getEmail());
			utilisateurtoupdate.setTelephone(user.getTelephone());
		 try {
			 userRepository.save(utilisateurtoupdate);
			 
		
			 Map<String, Boolean> success = new TreeMap<String, Boolean>();
				success.put("response", true);
				return success;
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Boolean> echec = new TreeMap<String, Boolean>();
			echec.put("response", false);
			return echec;
		}
		}else {
			Map<String, Boolean> echec = new TreeMap<String, Boolean>();
			echec.put("response", false);
			return echec;
		}
	}
	
	
	
	@RequestMapping(value = "/profil", method = RequestMethod.GET)
	public  @ResponseBody List<Utilisateur> getbyprofil(Model model,  String profil) {
		
			return iUtilisateur.getusersbyprofil(profil);
	}
	@RequestMapping(value = "/prof", method = RequestMethod.GET)
	public  @ResponseBody List<Utilisateur> getprof(Model model) {
		String profil="Enseignant";
			return iUtilisateur.getusersbyprofil(profil);
	}

	/************************************ GetNotificationbyUserId ************************************/

}
