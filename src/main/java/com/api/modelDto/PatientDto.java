package com.api.modelDto;

import java.util.List;

public class PatientDto {

	private int id;
	private String adresse;
	private String nom;
	private String prenom;
	private List<ConsultationDto> consultations;
	private DossierDto dossier;
	public PatientDto(int id, String adresse, String nom, String prenom, DossierDto dossier) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.nom = nom;
		this.prenom = prenom;
		this.dossier = dossier;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	public List<ConsultationDto> getConsultations() {
		return consultations;
	}
	public void setConsultations(List<ConsultationDto> consultations) {
		this.consultations = consultations;
	}
	public DossierDto getDossier() {
		return dossier;
	}
	public void setDossier(DossierDto dossier) {
		this.dossier = dossier;
	}
	
	
}
