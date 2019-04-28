package com.api.modelDto;

import java.util.Date;
import java.util.List;

public class DossierDto {
	
	private int id;
	private Date creatAt;
	private String numero;
	private List<AntecedentDto> antecedents;
	private PatientDto patient;
	public DossierDto(Date creatAt, String numero, PatientDto patient) {
		super();
		this.creatAt = creatAt;
		this.numero = numero;
		this.patient = patient;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreatAt() {
		return creatAt;
	}
	public void setCreatAt(Date creatAt) {
		this.creatAt = creatAt;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public List<AntecedentDto> getAntecedents() {
		return antecedents;
	}
	public void setAntecedents(List<AntecedentDto> antecedents) {
		this.antecedents = antecedents;
	}
	public PatientDto getPatient() {
		return patient;
	}
	public void setPatient(PatientDto patient) {
		this.patient = patient;
	}
	
	
	

}
