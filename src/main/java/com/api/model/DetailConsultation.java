package com.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the detail_consultation database table.
 * 
 */
@Entity
@Table(name="detail_consultation")
@NamedQuery(name="DetailConsultation.findAll", query="SELECT d FROM DetailConsultation d")
public class DetailConsultation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String dosage;

	//bi-directional many-to-one association to Consultation
	@ManyToOne
	private Consultation consultation;

	//bi-directional many-to-may association to Medicament
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="detailConsultation_medicament"
		, joinColumns={
			@JoinColumn(name="detailConsultation_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="medicament_id")
			}
		)
	private List<Medicament> medicaments;	
	
	public DetailConsultation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDosage() {
		return this.dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public Consultation getConsultation() {
		return this.consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public List<Medicament> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}

	

}