package com.api.daoInterface;

import java.util.List;

import com.api.model.Consultation;
import com.api.model.Dossier;
import com.api.model.Patient;
import com.api.modelDto.PatientDto;

public interface IPatientService {
	
	Patient save(PatientDto patient);
	List<Patient> findAll();
	void delete(int id);
	Patient getById(int id);
	PatientDto update(PatientDto patient);
	List<Consultation> allConsultation(int id);
	Dossier getDossier(int id);

}
