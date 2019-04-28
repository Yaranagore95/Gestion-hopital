package com.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the dossier database table.
 * 
 */
@Entity
@NamedQuery(name="Dossier.findAll", query="SELECT d FROM Dossier d")
public class Dossier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creat_at")
	private Date creatAt;

	private String numero;

	//bi-directional many-to-many association to Antecedent
	@ManyToMany(mappedBy="dossiers")
	private List<Antecedent> antecedents;
	
	//bi-directional one-to-one association to Patient
	@OneToOne(mappedBy="dossier", cascade=CascadeType.ALL,optional=false)
	private Patient patient;

	public Dossier() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatAt() {
		return this.creatAt;
	}

	public void setCreatAt(Date creatAt) {
		this.creatAt = creatAt;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Antecedent> getAntecedents() {
		return this.antecedents;
	}

	public void setAntecedents(List<Antecedent> antecedents) {
		this.antecedents = antecedents;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	

}