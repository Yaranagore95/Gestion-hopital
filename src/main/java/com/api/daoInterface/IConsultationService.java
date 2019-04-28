package com.api.daoInterface;

import java.util.List;

import com.api.model.Consultation;
import com.api.model.DetailConsultation;
import com.api.model.Patient;
import com.api.model.Service;
import com.api.model.Utilisateur;
import com.api.modelDto.ConsultationDto;

public interface IConsultationService {
	Consultation save(ConsultationDto consultation);
	List<Consultation> findAll();
	Consultation getById(int id);
	void delete(int id);
	ConsultationDto update(ConsultationDto consultation);
	Patient getPatient(int id);
	Service getService(int id);
	Utilisateur getUtilisateur(int id);
	List<DetailConsultation> allDetailConsultation(int id);
}	
