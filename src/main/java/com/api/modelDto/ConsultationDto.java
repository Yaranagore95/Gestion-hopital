package com.api.modelDto;

import java.util.Date;
import java.util.List;

public class ConsultationDto {
	private int id;
	private Date date;
	private PatientDto patient;
	private ServiceDto service;
	private UtilisateurDto utilisateur;
	private List<DetailConsultationDto> detailConsultations;
	public ConsultationDto(Date date, PatientDto patient, ServiceDto service, UtilisateurDto utilisateur) {
		super();
		this.date = date;
		this.patient = patient;
		this.service = service;
		this.utilisateur = utilisateur;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public PatientDto getPatient() {
		return patient;
	}
	public void setPatient(PatientDto patient) {
		this.patient = patient;
	}
	public ServiceDto getService() {
		return service;
	}
	public void setService(ServiceDto service) {
		this.service = service;
	}
	public UtilisateurDto getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(UtilisateurDto utilisateur) {
		this.utilisateur = utilisateur;
	}
	public List<DetailConsultationDto> getDetailConsultations() {
		return detailConsultations;
	}
	public void setDetailConsultations(List<DetailConsultationDto> detailConsultations) {
		this.detailConsultations = detailConsultations;
	}
	
	

}
