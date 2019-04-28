package com.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the consultation database table.
 * 
 */
@Entity
@NamedQuery(name="Consultation.findAll", query="SELECT c FROM Consultation c")
public class Consultation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date date;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	private Patient patient;

	//bi-directional many-to-one association to Service
	@ManyToOne
	private Service service;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	private Utilisateur utilisateur;

	//bi-directional many-to-one association to DetailConsultation
	@OneToMany(mappedBy="consultation")
	private List<DetailConsultation> detailConsultations;

	public Consultation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<DetailConsultation> getDetailConsultations() {
		return this.detailConsultations;
	}

	public void setDetailConsultations(List<DetailConsultation> detailConsultations) {
		this.detailConsultations = detailConsultations;
	}

	public DetailConsultation addDetailConsultation(DetailConsultation detailConsultation) {
		getDetailConsultations().add(detailConsultation);
		detailConsultation.setConsultation(this);

		return detailConsultation;
	}

	public DetailConsultation removeDetailConsultation(DetailConsultation detailConsultation) {
		getDetailConsultations().remove(detailConsultation);
		detailConsultation.setConsultation(null);

		return detailConsultation;
	}

}