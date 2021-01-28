package com.mobili.payload.response;

import java.util.Date;

public class PayementResponse {
    private Long id;
    private String type;
	private Date date;
	private String montant;
	private String frais;
	
	public PayementResponse() {
		super();
	}

	public PayementResponse(Long id, String type, Date date, String montant, String frais) {
		super();
		this.id = id;
		this.type = type;
		this.date = date;
		this.montant = montant;
		this.frais = frais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

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
	
	
	
	
	

}
