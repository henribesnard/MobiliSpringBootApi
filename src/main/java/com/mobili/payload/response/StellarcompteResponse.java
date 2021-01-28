package com.mobili.payload.response;

public class StellarcompteResponse {
	private int id;
	private String email;
	private String nom;
	private String prenom;
	private String stellarid;
	
	public StellarcompteResponse() {
		super();
	}

	public StellarcompteResponse(int id, String email, String nom, String prenom, String stellarid) {
		super();
		this.id = id;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.stellarid = stellarid;
	}





	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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


	public String getStellarid() {
		return stellarid;
	}


	public void setStellarid(String stellarid) {
		this.stellarid = stellarid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
