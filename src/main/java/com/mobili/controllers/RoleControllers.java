package com.mobili.controllers;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobili.models.Role;
import com.mobili.payload.request.RoleRequest;
import com.mobili.payload.response.MessageResponse;
import com.mobili.repository.RoleRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/role")
public class RoleControllers {
	@Autowired
	RoleRepository roleRepository;

	@PostMapping("/ajout")
	public ResponseEntity<?> role(@Valid @RequestBody RoleRequest roleRequest) throws IOException {
		Role role = new Role(roleRequest.getNom());

		roleRepository.save(role);

		return ResponseEntity.ok(new MessageResponse("Role enregistré"));
	}

}
