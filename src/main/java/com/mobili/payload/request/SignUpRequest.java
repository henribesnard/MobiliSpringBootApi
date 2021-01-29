package com.mobili.payload.request;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SignUpRequest {

	@NotBlank

	@Email
	private String email;
	@NotBlank

	private String mot_de_passe;

	private String nom;

	private String prenom;
	private String stellarid;

	private String stellarsecret;

	private String pays_de_residence;

	private String region_ou_province;

	private String ville;

	private String code_postale;

	private String addresse;

	private String numero_de_telephone;

	private Date date_de_naissance;

	private String lieu_de_naissance;

	private String pays_de_naissance;

	private String type_de_carte_identite;

	private String pays_de_delivrance_carte_identite;

	private Date date_emmission_carte_identite;

	private Date date_expiration_carte_identite;

	private String numero_carte_identite;

	private String photo_identite_resto;

	private String photo_identite_verso;

	private String adresse_ip;

	private String type_justificatif_domicile;

	private String photo_justificatif_domicile;

	private Set<String> role;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPays_de_residence() {
		return pays_de_residence;
	}

	public void setPays_de_residence(String pays_de_residence) {
		this.pays_de_residence = pays_de_residence;
	}

	public String getRegion_ou_province() {
		return region_ou_province;
	}

	public void setRegion_ou_province(String region_ou_province) {
		this.region_ou_province = region_ou_province;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCode_postale() {
		return code_postale;
	}

	public void setCode_postale(String code_postale) {
		this.code_postale = code_postale;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getNumero_de_telephone() {
		return numero_de_telephone;
	}

	public void setNumero_de_telephone(String numero_de_telephone) {
		this.numero_de_telephone = numero_de_telephone;
	}

	public Date getDate_de_naissance() {
		return date_de_naissance;
	}

	public void setDate_de_naissance(Date date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}

	public String getLieu_de_naissance() {
		return lieu_de_naissance;
	}

	public void setLieu_de_naissance(String lieu_de_naissance) {
		this.lieu_de_naissance = lieu_de_naissance;
	}

	public String getPays_de_naissance() {
		return pays_de_naissance;
	}

	public void setPays_de_naissance(String pays_de_naissance) {
		this.pays_de_naissance = pays_de_naissance;
	}

	public String getType_de_carte_identite() {
		return type_de_carte_identite;
	}

	public void setType_de_carte_identite(String type_de_carte_identite) {
		this.type_de_carte_identite = type_de_carte_identite;
	}

	public String getPays_de_delivrance_carte_identite() {
		return pays_de_delivrance_carte_identite;
	}

	public void setPays_de_delivrance_carte_identite(String pays_de_delivrance_carte_identite) {
		this.pays_de_delivrance_carte_identite = pays_de_delivrance_carte_identite;
	}

	public Date getDate_emmission_carte_identite() {
		return date_emmission_carte_identite;
	}

	public void setDate_emmission_carte_identite(Date date_emmission_carte_identite) {
		this.date_emmission_carte_identite = date_emmission_carte_identite;
	}

	public Date getDate_expiration_carte_identite() {
		return date_expiration_carte_identite;
	}

	public void setDate_expiration_carte_identite(Date date_expiration_carte_identite) {
		this.date_expiration_carte_identite = date_expiration_carte_identite;
	}

	public String getNumero_carte_identite() {
		return numero_carte_identite;
	}

	public void setNumero_carte_identite(String numero_carte_identite) {
		this.numero_carte_identite = numero_carte_identite;
	}

	public String getPhoto_identite_resto() {
		return photo_identite_resto;
	}

	public void setPhoto_identite_resto(String photo_identite_resto) {
		this.photo_identite_resto = photo_identite_resto;
	}

	public String getPhoto_identite_verso() {
		return photo_identite_verso;
	}

	public void setPhoto_identite_verso(String photo_identite_verso) {
		this.photo_identite_verso = photo_identite_verso;
	}

	public String getAdresse_ip() {
		return adresse_ip;
	}

	public void setAdresse_ip(String adresse_ip) {
		this.adresse_ip = adresse_ip;
	}

	public String getType_justificatif_domicile() {
		return type_justificatif_domicile;
	}

	public void setType_justificatif_domicile(String type_justificatif_domicile) {
		this.type_justificatif_domicile = type_justificatif_domicile;
	}

	public String getPhoto_justificatif_domicile() {
		return photo_justificatif_domicile;
	}

	public void setPhoto_justificatif_domicile(String photo_justificatif_domicile) {
		this.photo_justificatif_domicile = photo_justificatif_domicile;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getStellarid() {
		return stellarid;
	}

	public void setStellarid(String stellarid) {
		this.stellarid = stellarid;
	}

	public String getStellarsecret() {
		return stellarsecret;
	}

	public void setStellarsecret(String stellarsecret) {
		this.stellarsecret = stellarsecret;
	}
	

}
