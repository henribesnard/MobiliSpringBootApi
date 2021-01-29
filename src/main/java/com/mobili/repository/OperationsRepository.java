package com.mobili.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobili.models.Operations;
import com.mobili.models.Utilisateur;

@Repository
public interface OperationsRepository extends JpaRepository<Operations, Long>{
  Collection<Operations> findByUtilisateur(Utilisateur utilisateur);
}
