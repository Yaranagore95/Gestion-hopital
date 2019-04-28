package com.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medicament database table.
 * 
 */
@Entity
@NamedQuery(name="Medicament.findAll", query="SELECT m FROM Medicament m")
public class Medicament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String libelle;

	//bi-directional many-to-one association to DetailConsultation
	@ManyToMany(mappedBy="medicaments")
	private List<DetailConsultation> detailConsultations;

	public Medicament() {
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

	public List<DetailConsultation> getDetailConsultations() {
		return this.detailConsultations;
	}

	public void setDetailConsultations(List<DetailConsultation> detailConsultations) {
		this.detailConsultations = detailConsultations;
	}


}