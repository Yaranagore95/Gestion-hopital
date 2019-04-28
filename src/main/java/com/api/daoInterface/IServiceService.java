package com.api.daoInterface;

import java.util.List;

import com.api.model.Consultation;
import com.api.model.Service;
import com.api.model.Utilisateur;
import com.api.modelDto.ServiceDto;

public interface IServiceService {
	
	Service save(ServiceDto service);
	List<Service> findAll();
	void delete(int id);
	Service getById(int id);
	ServiceDto update(ServiceDto serviceDto);
	List<Consultation> allConsultation(int id);
	List<Utilisateur> allUtilisateur(int id);
}
