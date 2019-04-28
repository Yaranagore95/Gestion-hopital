package com.api.daoInterface;

import java.util.List;

import com.api.model.DetailConsultation;
import com.api.model.Medicament;
import com.api.modelDto.MedicamentDto;

public interface IMedicamentService {
	Medicament save(MedicamentDto medicament);
	List<Medicament> findAll();
	Medicament getById(int id);
	void delete(int id);
	MedicamentDto update(MedicamentDto medicament);
	List<DetailConsultation> allDetailConsultation(int id);
}
