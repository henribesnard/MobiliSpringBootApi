package com.mobili.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.mobili.models.Utilisateur;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	Optional<Utilisateur> findByCompteId(int compteId);
	Optional<Utilisateur>  findByEmail(String email);
	Utilisateur findUserById(int id);
	Boolean existsByCompteId(int compteId);
	Boolean existsByEmail(String email);

}
