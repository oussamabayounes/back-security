package com.dpc.Scolarity.service.implementation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dpc.Scolarity.Domain.Utilisateur;
import com.dpc.Scolarity.Repository.IUtilisateur;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUtilisateur userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return (UserDetails) user;
        }
    }
}
