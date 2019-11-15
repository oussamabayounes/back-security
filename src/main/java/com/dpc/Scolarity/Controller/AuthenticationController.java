package com.dpc.Scolarity.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dpc.Scolarity.Domain.Utilisateur;
import com.dpc.Scolarity.Domain.UtilisateurTokenState;
import com.dpc.Scolarity.Repository.IAuthority;
import com.dpc.Scolarity.Repository.IUtilisateur;
import com.dpc.Scolarity.common.DeviceProvider;
import com.dpc.Scolarity.security.TokenHelper;
import com.dpc.Scolarity.security.Auth.JwtAuthenticationRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
/**
 * @author slim
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class AuthenticationController {

	@Autowired
	IUtilisateur userRepository;
	
    
    @Autowired 
    IUtilisateur iUtilisateur;
    
    
    @Autowired
    IAuthority iAuthority;

	@Autowired
	TokenHelper tokenHelper;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private DeviceProvider deviceProvider;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
			HttpServletResponse response, Device device) throws AuthenticationException, IOException {

		// Perform the security
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
						authenticationRequest.getPassword()));

		// Inject into security context
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// token creation
		Utilisateur user = (Utilisateur) authentication.getPrincipal();
		   Utilisateur u = new Utilisateur();
		  u=  userRepository.findByUsername(authenticationRequest.getUsername());
		  String profile = u.getProfil();
		String jws = tokenHelper.generateToken(user.getUsername(), device);
		int expiresIn = tokenHelper.getExpiredIn(device);
		Long a = (long) expiresIn;
		// Add cookie to response
		System.out.println("aaaaaaaaaaaaaaaa"+a);

		System.out.println("expirein"+expiresIn);
		response.addCookie(createAuthCookie(jws, expiresIn));
		// Return the token
		return ResponseEntity.ok(new UtilisateurTokenState(jws, a,u.getNom(),u.getPrenom(), profile));
	}

	@RequestMapping(value = "/refresh", method = RequestMethod.GET)
	public ResponseEntity<?> refreshAuthenticationToken(HttpServletRequest request, HttpServletResponse response,
			Principal principal) {

		String authToken = tokenHelper.getToken(request);

		Device device = deviceProvider.getCurrentDevice(request);

		if (authToken != null && principal != null) {

			// TODO check user password last update
			String refreshedToken = tokenHelper.refreshToken(authToken, device);
			int expiresIn = tokenHelper.getExpiredIn(device);

			// Add cookie to response
			response.addCookie(createAuthCookie(refreshedToken, expiresIn));

			return ResponseEntity.ok(new UtilisateurTokenState(refreshedToken, expiresIn));
		} else {
			UtilisateurTokenState userTokenState = new UtilisateurTokenState();
			return ResponseEntity.accepted().body(userTokenState);
		}
	}

	private Cookie createAuthCookie(String jwt, int expiresIn) {
		Cookie authCookie = new Cookie(tokenHelper.AUTH_COOKIE, (jwt));
		authCookie.setPath("/");
		authCookie.setHttpOnly(true);
		authCookie.setMaxAge(expiresIn);
		return authCookie;
	}
}