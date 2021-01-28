package com.mobili.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mobili.models.Utilisateur;
import com.mobili.payload.response.StellarcompteResponse;
import com.mobili.repository.UtilisateurRepository;
import com.mobili.exception.ResourceNotFoundException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UtilisateurController {
	@Autowired
	private UtilisateurRepository userRepository;
	
	
	// RECUPERER TOUS LES COMPTES 
		@GetMapping("/users")
		@PreAuthorize("hasRole('ADMIN')")
		public List<Utilisateur> getAllUsers(){
			return userRepository.findAll();
		}
		
		//RECUPERER UN COMPTE EN FONCTION DE L'ID
	    @GetMapping("/user/{id}")
	    @PreAuthorize(" hasRole('USER') or hasRole('ADMIN') or hasRole('MODERATEUR')")
	    public ResponseEntity<Utilisateur> getUserById(@PathVariable(value = "id") Long id)
	    		 throws ResourceNotFoundException {
	        Utilisateur user = userRepository.findById(id)
	          .orElseThrow(() -> new ResourceNotFoundException("Aucun compte trouver avec l'ID :: " + id));
	        return ResponseEntity.ok().body(user);
	    }
	    
	  //RECUPERER UN COMPTE STELLAR EN FONCTION DE L'IDCOMPTE
	    @GetMapping("/stellar/{compteid}")
	    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')or hasRole('MODERATEUR')")
	    public ResponseEntity<?> getStellarId(@PathVariable(value = "compteid") int compteid)
	    		 throws ResourceNotFoundException {
	        Utilisateur user = userRepository.findByCompteId(compteid)
	          .orElseThrow(() -> new ResourceNotFoundException("Aucun compte n'existe avec le numéro : " + compteid));
	        
			return ResponseEntity.ok(new StellarcompteResponse (
					user.getId(),
					user.getEmail(),
	        		user.getNom(),
	        	    user.getPrenom(),
	        	    user.getStellarid()
	        		) );
	    }
	    
	    
	  //MODIFIER UN USER
	    @PutMapping("/user/{id}")
	    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	    public ResponseEntity<Utilisateur> updateUser(@PathVariable(value = "id") Long id,
	         @Valid @RequestBody Utilisateur userDetails) throws ResourceNotFoundException {
	        Utilisateur user = userRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Aucun compte trouver avec l'ID :: " + id));
	        
	        user.setAddresse(userDetails.getAddresse());
	        user.setCode_postale(userDetails.getCode_postale());
	        user.setDate_emmission_carte_identite(userDetails.getDate_emmission_carte_identite());
	        user.setDate_expiration_carte_identite(userDetails.getDate_expiration_carte_identite());
	        user.setNumero_carte_identite(userDetails.getNumero_carte_identite());
	        user.setNumero_de_telephone(userDetails.getNumero_de_telephone());
	        user.setPays_de_delivrance_carte_identite(userDetails.getPays_de_delivrance_carte_identite());
	        user.setPays_de_naissance(userDetails.getPays_de_naissance());
	        user.setPays_de_residence(userDetails.getPays_de_residence());
	        user.setPhoto_identite_resto(userDetails.getPhoto_identite_resto());
	        user.setPhoto_identite_verso(userDetails.getPhoto_identite_verso());
	        user.setPhoto_justificatif_domicile(userDetails.getPhoto_justificatif_domicile());
	        user.setRegion_ou_province(userDetails.getRegion_ou_province());
	        user.setType_de_carte_identite(userDetails.getType_de_carte_identite());
	        user.setType_justificatif_domicile(userDetails.getType_justificatif_domicile());
	        user.setVille(userDetails.getVille());
	        
	        final Utilisateur updatedUser = userRepository.save(user);
	        return ResponseEntity.ok(updatedUser);
	    }
	    
	  //SUPPRIMER UN COMPTE
	    @DeleteMapping("/user/{id}")
	    @PreAuthorize("hasRole('ADMIN')")
	    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
	         throws ResourceNotFoundException {
	        Utilisateur user = userRepository.findById(userId)
	       .orElseThrow(() -> new ResourceNotFoundException("Aucun compte trouver avec le numéro :: " + userId));

	        userRepository.delete(user);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("Suppression", Boolean.TRUE);
	        return response;
	        
	    }    		
	
	
}
