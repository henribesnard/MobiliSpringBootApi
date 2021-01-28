package com.mobili.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobili.models.Role;
import com.mobili.models.ERole;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByNom(ERole nom);
}
