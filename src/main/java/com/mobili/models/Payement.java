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
@Table(name = "payement")
public class Payement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date date;

	@NotBlank
	private String titre;

	private String commentaire;

	@NotBlank
	private String montant;

	@NotBlank
	private String frais;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destinateur", referencedColumnName = "ID")
	@JsonIdentityReference(alwaysAsId = true)
	private Utilisateur destinateur;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiaire", referencedColumnName = "ID")
	@JsonIdentityReference(alwaysAsId = true)
	private Utilisateur beneficiaire;

	public Payement() {
		super();
	}

	public Payement(Date date, @NotBlank String titre, String commentaire, @NotBlank String montant,
			@NotBlank String frais) {
		super();
		this.date = date;
		this.titre = titre;
		this.commentaire = commentaire;
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

	public Utilisateur getDestinateur() {
		return destinateur;
	}

	public void setDestinateur(Utilisateur destinateur) {
		this.destinateur = destinateur;
	}

	public Utilisateur getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(Utilisateur beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

}
