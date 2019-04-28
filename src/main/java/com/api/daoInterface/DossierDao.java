package com.api.daoInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Dossier;

public interface DossierDao extends JpaRepository<Dossier, Integer>{

}
