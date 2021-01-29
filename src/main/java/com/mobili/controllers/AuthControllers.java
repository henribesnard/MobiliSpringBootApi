package com.mobili.controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobili.repository.RoleRepository;
import com.mobili.repository.UtilisateurRepository;
import com.mobili.security.jwt.JwtUtils;
import com.mobili.payload.request.LoginRequest;
import com.mobili.payload.response.JwtResponse;
import com.mobili.security.services.UserDetailsImpl;
import com.mobili.models.ERole;
import com.mobili.models.Role;
import com.mobili.models.Utilisateur;
import com.mobili.payload.request.SignUpRequest;
import com.mobili.payload.response.MessageResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthControllers {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UtilisateurRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, roles, userDetails.getId(), userDetails.getCompteId(),
				userDetails.getEmail(), userDetails.getNom(), userDetails.getPrenom(),
				userDetails.getPays_de_residence(), userDetails.getRegion_ou_province(), userDetails.getVille(),
				userDetails.getCode_postale(), userDetails.getAddresse(), userDetails.getNumero_de_telephone(),
				userDetails.getDate_de_naissance(), userDetails.getLieu_de_naissance(),
				userDetails.getPays_de_naissance(), userDetails.getType_de_carte_identite(),
				userDetails.getPays_de_delivrance_carte_identite(), userDetails.getDate_emmission_carte_identite(),
				userDetails.getDate_expiration_carte_identite(), userDetails.getNumero_carte_identite(),
				userDetails.getPhoto_identite_resto(), userDetails.getPhoto_identite_verso(),
				userDetails.getAdresse_ip(), userDetails.getType_justificatif_domicile(),
				userDetails.getPhoto_justificatif_domicile(), userDetails.getStellarid(),
				userDetails.getStellarsecret()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) throws IOException {

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Erreur: Email déjà utilisé"));
		}
		
		int min = 10000000;
		int max = 99999999;
		int range = max - min + 1;
		int numeroCompte = (int) (Math.random() * range) + min;

		// CREER UN COMPTE UTILISATEUR
		Utilisateur user = new Utilisateur(signUpRequest.getEmail(), encoder.encode(signUpRequest.getMot_de_passe()),
				signUpRequest.getNom(), signUpRequest.getPrenom(), signUpRequest.getPays_de_residence(),
				signUpRequest.getRegion_ou_province(), signUpRequest.getVille(), signUpRequest.getCode_postale(),
				signUpRequest.getAddresse(), signUpRequest.getNumero_de_telephone(),
				signUpRequest.getDate_de_naissance(), signUpRequest.getLieu_de_naissance(),
				signUpRequest.getPays_de_naissance(), signUpRequest.getType_de_carte_identite(),
				signUpRequest.getPays_de_delivrance_carte_identite(), signUpRequest.getDate_emmission_carte_identite(),
				signUpRequest.getDate_expiration_carte_identite(), signUpRequest.getNumero_carte_identite(),
				signUpRequest.getPhoto_identite_resto(), signUpRequest.getPhoto_identite_verso(),
				signUpRequest.getAdresse_ip(), signUpRequest.getType_justificatif_domicile(),
				signUpRequest.getPhoto_justificatif_domicile());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role defaultRole = roleRepository.findByNom(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Erreur: Role non trouvé."));
			roles.add(defaultRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByNom(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Erreur: Role non trouvé."));
					roles.add(adminRole);

					break;
				case "mod":
					Role moderateurRole = roleRepository.findByNom(ERole.ROLE_MODERATEUR)
							.orElseThrow(() -> new RuntimeException("Erreur: Role non trouvé."));
					roles.add(moderateurRole);
					break;
				default:
					Role defaultRole = roleRepository.findByNom(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Erreur: Role non trouvé."));
					roles.add(defaultRole);
				}
			});
		}
		user.setCompteId(numeroCompte);
		user.setRoles(roles);

		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("inscription réussie"));
	}

}
