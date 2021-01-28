package com.mobili.payload.request; 

import javax.validation.constraints.NotBlank;

public class PayementRequest {
	
	@NotBlank
	private String montant;
	
	@NotBlank
	private String frais;
	
    private String commentaire;
	
	private int destinateurId;
	private int beneficiaireId;
	
	public String getMontant() {
		return montant;
	}
	public void setMontant(String montant) {
		this.montant = montant;
	}
	public String getFrais() {
		return frais;
	}
	public void setFrais(String frais) {
		this.frais = frais;
	}
	public int getDestinateurId() {
		return destinateurId;
	}
	public void setDestinateurId(int destinateurId) {
		this.destinateurId = destinateurId;
	}
	public int getBeneficiaireId() {
		return beneficiaireId;
	}
	public void setBeneficiaireId(int beneficiaireId) {
		this.beneficiaireId = beneficiaireId;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	
	
}
