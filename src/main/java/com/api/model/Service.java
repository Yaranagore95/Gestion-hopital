package com.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the service database table.
 * 
 */
@Entity
@NamedQuery(name="Service.findAll", query="SELECT s FROM Service s")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String libelle;

	//bi-directional many-to-one association to Consultation
	@OneToMany(mappedBy="service")
	private List<Consultation> consultations;

	//bi-directional many-to-many association to Utilisateur
	@ManyToMany(mappedBy="services")
	private List<Utilisateur> utilisateurs;

	public Service() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Consultation> getConsultations() {
		return this.consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

	public Consultation addConsultation(Consultation consultation) {
		getConsultations().add(consultation);
		consultation.setService(this);

		return consultation;
	}

	public Consultation removeConsultation(Consultation consultation) {
		getConsultations().remove(consultation);
		consultation.setService(null);

		return consultation;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

}