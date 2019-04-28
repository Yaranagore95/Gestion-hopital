package com.api.modelDto;

import java.util.List;

public class UtilisateurDto {
	private int id;
	private Boolean changed;
	private Boolean enabled;
	private String matricule;
	private String nom;
	private String password;
	private String photo;
	private String prenom;
	private String username;
	private List<RoleDto> roles;
	
	public UtilisateurDto() {
		
	}

	
	public UtilisateurDto(Boolean changed, Boolean enabled, String matricule, String nom, String password, String photo,
			String prenom, String username) {
		super();
		this.changed = changed;
		this.enabled = enabled;
		this.matricule = matricule;
		this.nom = nom;
		this.password = password;
		this.photo = photo;
		this.prenom = prenom;
		this.username = username;
	}
	
	public List<RoleDto> getRole() {
		return roles;
	}


	public void setRole(List<RoleDto> role) {
		this.roles = role;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Boolean getEnabled() {
		return enabled;
	}



	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}



	public String getMatricule() {
		return matricule;
	}



	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public Boolean getChanged() {
		return changed;
	}



	public void setChanged(Boolean pwdChanged) {
		this.changed = pwdChanged;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
