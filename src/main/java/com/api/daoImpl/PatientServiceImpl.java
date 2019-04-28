package com.api.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.daoInterface.IPatientService;
import com.api.daoInterface.PatientDao;
import com.api.model.Consultation;
import com.api.model.Dossier;
import com.api.model.Patient;
import com.api.modelDto.PatientDto;

@Service(value="patientService")
public class PatientServiceImpl implements IPatientService{
	
	@Autowired
	PatientDao patientDao;
	
	@Autowired
	ServiceServiceImpl serviceImpl;
	
	@Autowired
	DossierServiceImpl dossierService;

	@Override
	public Patient save(PatientDto patient) {
		Patient newPatient = new Patient();
		newPatient.setAdresse(patient.getAdresse());
		newPatient.setNom(patient.getNom());
		newPatient.setDossier(dossierService.save(patient.getDossier()));
		return patientDao.save(newPatient);
	}

	@Override
	public List<Patient> findAll() {
		List<Patient> allPatient = new ArrayList<>();
		patientDao.findAll().iterator().forEachRemaining(allPatient::add);
		return allPatient;
	}

	@Override
	public void delete(int id) {
		patientDao.deleteById(id);
	}

	@Override
	public Patient getById(int id) {
		Optional<Patient> optionalPatient = patientDao.findById(id);
		return optionalPatient.isPresent() ? optionalPatient.get() : null;
	}


	@Override
	public PatientDto update(PatientDto patient) {
		Patient p = patientDao.getOne(patient.getId());
		if (patient != null) {
			BeanUtils.copyProperties(p, patient);
		}
		return patient;
	}

	@Override
	public List<Consultation> allConsultation(int id) {
		List<Consultation> allConsultation = new ArrayList<>();
		this.getById(id).getConsultations().iterator().forEachRemaining(allConsultation::add);
		return allConsultation;
	}

	@Override
	public Dossier getDossier(int id) {
		return this.getById(id).getDossier();
	}


}
