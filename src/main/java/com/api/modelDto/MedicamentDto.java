package com.api.modelDto;

public class MedicamentDto {
	private int id;
	private String libelle;
	public MedicamentDto(String libelle) {
		super();
		this.libelle = libelle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
