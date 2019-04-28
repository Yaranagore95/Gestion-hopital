package com.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Boolean changed;

	private Boolean enabled;

	private String matricule;

	private String nom;

	private String password;

	private String photo;

	private String prenom;

	private String username;

	//bi-directional many-to-one association to Consultation
	@OneToMany(mappedBy="utilisateur")
	private List<Consultation> consultations;

	//bi-directional many-to-many association to Role
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="utilisateur_role"
		, joinColumns={
			@JoinColumn(name="utilisateur_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="role_id")
			}
		)
	private List<Role> roles;

	//bi-directional many-to-many association to Service
	@ManyToMany
	@JoinTable(
		name="utilisateur_service"
		, joinColumns={
			@JoinColumn(name="utilisateur_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="service_id")
			}
		)
	private List<Service> services;

	public Utilisateur() {
	}
	
	public Utilisateur(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getChanged() {
		return this.changed;
	}

	public void setChanged(Boolean changed) {
		this.changed = changed;
	}

	public Object getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Consultation> getConsultations() {
		return this.consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

	public Consultation addConsultation(Consultation consultation) {
		getConsultations().add(consultation);
		consultation.setUtilisateur(this);

		return consultation;
	}

	public Consultation removeConsultation(Consultation consultation) {
		getConsultations().remove(consultation);
		consultation.setUtilisateur(null);

		return consultation;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Service> getServices() {
		return this.services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

}