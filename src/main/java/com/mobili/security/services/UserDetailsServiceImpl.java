package com.mobili.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobili.models.Utilisateur;
import com.mobili.repository.UtilisateurRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Utilisateur utilisateur = utilisateurRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Aucun utilisateur trouvé avec le mail: " + email));

		return UserDetailsImpl.build(utilisateur);
	}
	

}
