package com.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the antecedents database table.
 * 
 */
@Entity
@Table(name="antecedents")
@NamedQuery(name="Antecedent.findAll", query="SELECT a FROM Antecedent a")
public class Antecedent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String libelle;

	//bi-directional many-to-many association to Dossier
	@ManyToMany
	@JoinTable(
		name="antecedents_dossier"
		, joinColumns={
			@JoinColumn(name="antecedents_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="dossier_id")
			}
		)
	private List<Dossier> dossiers;

	public Antecedent() {
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

	public List<Dossier> getDossiers() {
		return this.dossiers;
	}

	public void setDossiers(List<Dossier> dossiers) {
		this.dossiers = dossiers;
	}

}