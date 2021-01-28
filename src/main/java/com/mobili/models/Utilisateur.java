package com.mobili.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name ="utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Size(max = 12)
	private int compteId;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	@NotBlank
	@Size(max = 120)
	private String mot_de_passe;
	
	@Size(max= 120)
	private String nom;

	@Size(max= 120)
	private String prenom;
	
	private String stellarid;
	
	private String stellarsecret;
	
	@Size(max= 20)
	private String pays_de_residence;
	
	@Size(max= 120)
	private String region_ou_province;
	
	@Size(max= 120)
	private String ville;
	
	@Size(max= 120)
	private String code_postale;
	
	@Size(max= 120)
	private String addresse;
	
	@Size(max= 120)
	private String numero_de_telephone;
	
	@Size(max= 120)
	private Date date_de_naissance;
	
	@Size(max= 120)
	private String lieu_de_naissance ;
	
	@Size(max= 120)
	private String pays_de_naissance;
	
	@Size(max= 120)
	private String type_de_carte_identite;
	
	@Size(max= 120)
	private String pays_de_delivrance_carte_identite;
	
	@Size(max= 120)
	private Date date_emmission_carte_identite;
	
	@Size(max= 120)
	private Date date_expiration_carte_identite;
	
	@Size(max= 120)
	private String numero_carte_identite;
	
	@Size(max= 120)
	private String photo_identite_resto;
	
	@Size(max= 120)
	private String photo_identite_verso;
	
	
	@Size(max= 120)
	private String adresse_ip;
	
	@Size(max= 120)
	private String type_justificatif_domicile;
	
	@Size(max= 120)
	private String photo_justificatif_domicile;
	
	@OneToMany(
			mappedBy = "destinateur",
			cascade = CascadeType.ALL,
			orphanRemoval = false
			)
	List<Payement> payementsEnvoyes = new ArrayList<>();
	
	@OneToMany(
			mappedBy = "beneficiaire",
			cascade = CascadeType.ALL,
			orphanRemoval = false)
	List<Payement> payementsRecus = new ArrayList<>();
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "utilisateur_roles", 
				joinColumns = @JoinColumn(name = "utilisateur_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
   
	public Utilisateur() {
	}

	public Utilisateur( @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String mot_de_passe, @Size(max = 120) String nom, @Size(max = 120) String prenom,
			@Size(max = 20) String pays_de_residence,
			@Size(max = 120) String region_ou_province, @Size(max = 120) String ville,
			@Size(max = 120) String code_postale, @Size(max = 120) String addresse,
			@Size(max = 120) String numero_de_telephone, @Size(max = 120) Date date_de_naissance,
			@Size(max = 120) String lieu_de_naissance, @Size(max = 120) String pays_de_naissance,
			@Size(max = 120) String type_de_carte_identite, @Size(max = 120) String pays_de_delivrance_carte_identite,
			@Size(max = 120) Date date_emmission_carte_identite, @Size(max = 120) Date date_expiration_carte_identite,
			@Size(max = 120) String numero_carte_identite, @Size(max = 120) String photo_identite_resto,
			@Size(max = 120) String photo_identite_verso, @Size(max = 120) String adresse_ip,
			@Size(max = 120) String type_justificatif_domicile, @Size(max = 120) String photo_justificatif_domicile) {
		super();
		
		this.email = email;
		this.mot_de_passe = mot_de_passe;
		this.nom = nom;
		this.prenom = prenom;
		this.pays_de_residence = pays_de_residence;
		this.region_ou_province = region_ou_province;
		this.ville = ville;
		this.code_postale = code_postale;
		this.addresse = addresse;
		this.numero_de_telephone = numero_de_telephone;
		this.date_de_naissance = date_de_naissance;
		this.lieu_de_naissance = lieu_de_naissance;
		this.pays_de_naissance = pays_de_naissance;
		this.type_de_carte_identite = type_de_carte_identite;
		this.pays_de_delivrance_carte_identite = pays_de_delivrance_carte_identite;
		this.date_emmission_carte_identite = date_emmission_carte_identite;
		this.date_expiration_carte_identite = date_expiration_carte_identite;
		this.numero_carte_identite = numero_carte_identite;
		this.photo_identite_resto = photo_identite_resto;
		this.photo_identite_verso = photo_identite_verso;
		this.adresse_ip = adresse_ip;
		this.type_justificatif_domicile = type_justificatif_domicile;
		this.photo_justificatif_domicile = photo_justificatif_domicile;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getCompteId() {
		return compteId;
	}



	public void setCompteId(int compteId) {
		this.compteId = compteId;
	}



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



	public Set<Role> getRoles() {
		return roles;
	}



	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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

	public List<Payement> getPayementsEnvoyes() {
		return payementsEnvoyes;
	}

	public void setPayementsEnvoyes(List<Payement> payementsEnvoyes) {
		this.payementsEnvoyes = payementsEnvoyes;
	}

	public Utilisateur orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}