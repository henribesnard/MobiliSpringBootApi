package com.mobili.payload.request;

import com.mobili.models.ERole;

public class RoleRequest {
	private ERole nom;

	public RoleRequest() {
		super();
	}

	public RoleRequest(ERole nom) {
		super();
		this.nom = nom;
	}

	public ERole getNom() {
		return nom;
	}

	public void setNom(ERole nom) {
		this.nom = nom;
	}

}
