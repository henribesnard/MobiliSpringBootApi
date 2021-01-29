package com.mobili.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

@Entity
@Table(name = "operations")
public class Operations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date date;

	@NotBlank
	private String type;

	private String statut;
	
	@NotBlank
	private String montant;

	@NotBlank
	private String frais;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utilisateur", referencedColumnName = "ID")
	@JsonIdentityReference(alwaysAsId = true)
	private Utilisateur utilisateur;
	
	

	public Operations() {
		super();
	}

	public Operations(Date date, @NotBlank String type, String statut, @NotBlank String montant,
			@NotBlank String frais) {
		super();
		this.date = date;
		this.type = type;
		this.statut = statut;
		this.montant = montant;
		this.frais = frais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	

}
