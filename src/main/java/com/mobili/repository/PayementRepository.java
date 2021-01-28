package com.mobili.repository;

import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobili.models.Payement;
import com.mobili.models.Utilisateur;

@Repository
public interface PayementRepository extends JpaRepository<Payement, Long> {
	Collection<Payement> findByDestinateur(Utilisateur destinateur);
	Collection<Payement> findByBeneficiaire(Utilisateur beneficiaire);
	Collection<Payement> findByBeneficiaireOrDestinateur(Utilisateur beneficiaire, Utilisateur destinateur);
}
