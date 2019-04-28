package com.api.modelDto;

import java.util.List;

public class DetailConsultationDto {

	private int id;
	private String dosage;
	private ConsultationDto consultation;
	private List<MedicamentDto> medicaments;
	public DetailConsultationDto(String dosage, ConsultationDto consultation) {
		super();
		this.dosage = dosage;
		this.consultation = consultation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public ConsultationDto getConsultation() {
		return consultation;
	}
	public void setConsultation(ConsultationDto consultation) {
		this.consultation = consultation;
	}
	public List<MedicamentDto> getMedicaments() {
		return medicaments;
	}
	public void setMedicaments(List<MedicamentDto> medicaments) {
		this.medicaments = medicaments;
	}
	
	
}
