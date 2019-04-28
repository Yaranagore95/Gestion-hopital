package com.api.daoInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Utilisateur;


public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {
	Utilisateur findByUsername(String username);
}
