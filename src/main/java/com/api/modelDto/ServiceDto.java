package com.api.modelDto;

import java.util.List;

public class ServiceDto {
	private int id;
	private String libelle;
	private List<UtilisateurDto> utilisateurs;
	private List<ConsultationDto> consultations;
	
	public ServiceDto() {}
	
	public ServiceDto(String libelle) {
		super();
		this.libelle = libelle;
	}



	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<UtilisateurDto> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<UtilisateurDto> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public List<ConsultationDto> getConsultations() {
		return consultations;
	}
	public void setConsultations(List<ConsultationDto> consultations) {
		this.consultations = consultations;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
