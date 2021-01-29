package com.mobili.payload.request;

import javax.validation.constraints.NotBlank;

public class OperationsRequest {
	@NotBlank
	private String type;

	@NotBlank
	private String montant;

	private int utilisateur;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}

	public int getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(int utilisateur) {
		this.utilisateur = utilisateur;
	}

}
