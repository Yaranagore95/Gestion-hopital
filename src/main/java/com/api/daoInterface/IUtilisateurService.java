package com.api.daoInterface;

import java.util.List;

import com.api.model.Consultation;
import com.api.model.Role;
import com.api.model.Utilisateur;
import com.api.modelDto.UtilisateurDto;

public interface IUtilisateurService {
	
	Utilisateur save(UtilisateurDto utilisateur);
	List<Utilisateur> findAll();
	void delete(int id);
	Utilisateur findOne(String username);
	Utilisateur getById(int id);
	UtilisateurDto update(UtilisateurDto userDto);
	List<Consultation> allConsultation(int id);
	List<Role> allRole(int id);
}
