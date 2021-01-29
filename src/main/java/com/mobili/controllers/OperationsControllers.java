package com.mobili.controllers;

import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobili.models.Operations;
import com.mobili.models.Utilisateur;
import com.mobili.payload.request.OperationsRequest;
import com.mobili.payload.response.MessageResponse;
import com.mobili.repository.OperationsRepository;
import com.mobili.repository.UtilisateurRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/operations")
public class OperationsControllers {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	EntityManager entityManager;

	@Autowired
	private OperationsRepository operationsrepository;

	// RECURER TOUTES LES OPERATIONS d'un UTILISATEUR
	@GetMapping("/operations/{utilisateurId}")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')or hasRole('MODERATEUR')")
	public Collection<Operations> getAlloperations(@PathVariable(value = "utilisateurId") int utilisateurId) {
		Utilisateur user = utilisateurRepository.findUserById(utilisateurId);
		return operationsrepository.findByUtilisateur(user);
	}

	// ENREGISTREMENT UNE OPERATION
	@PostMapping("/operation")
	public ResponseEntity<?> opretations(@Valid @RequestBody OperationsRequest operationsRequest) {
		Utilisateur user = utilisateurRepository.findUserById(operationsRequest.getUtilisateur());

		Date date = new Date();

		Operations operations = new Operations(date, operationsRequest.getType(), "Statut",
				operationsRequest.getMontant(), "frais");

		operations.setDate(date);
		operations.setUtilisateur(user);
		operationsrepository.save(operations);

		return ResponseEntity.ok(new MessageResponse(
				"votre  " + operations.getType() + " de " + operations.getMontant() + " est soumis avec succés !"));
	}

}
