package com.api.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.daoInterface.IServiceService;
import com.api.daoInterface.ServiceDao;
import com.api.model.Consultation;
import com.api.model.Service;
import com.api.model.Utilisateur;
import com.api.modelDto.ServiceDto;

@org.springframework.stereotype.Service(value="serviceService")
public class ServiceServiceImpl implements IServiceService{

	@Autowired
	ServiceDao serviceDao;
	@Override
	public Service save(ServiceDto service) {
		Service src = new Service();
		src.setId(service.getId());
		src.setLibelle(service.getLibelle());
		return serviceDao.save(src);
	}

	@Override
	public List<Service> findAll() {
		List<Service> allService = new ArrayList<>();
		serviceDao.findAll().iterator().forEachRemaining(allService::add);
		return allService;
	}

	@Override
	public void delete(int id) {
		serviceDao.deleteById(id);
	}

	@Override
	public Service getById(int id) {
		Optional<Service> optionalService = serviceDao.findById(id);
		return optionalService.isPresent() ? optionalService.get() : null;
	}

	@Override
	public ServiceDto update(ServiceDto serviceDto) {
		Service updateService = serviceDao.getOne(serviceDto.getId());
		if (updateService != null) {
			BeanUtils.copyProperties(updateService, serviceDto);
		}
		return serviceDto;
	}

	@Override
	public List<Consultation> allConsultation(int id) {
		List<Consultation> allConsultation = new ArrayList<>();
		this.getById(id).getConsultations().iterator().forEachRemaining(allConsultation::add);
		return allConsultation;
	}

	@Override
	public List<Utilisateur> allUtilisateur(int id) {
		List<Utilisateur> allUtilisateur = new ArrayList<>();
		this.getById(id).getUtilisateurs().iterator().forEachRemaining(allUtilisateur::add);
		return allUtilisateur;
	}

}
