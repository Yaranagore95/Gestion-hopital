package com.api.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.daoInterface.DossierDao;
import com.api.daoInterface.IDossierService;
import com.api.model.Antecedent;
import com.api.model.Dossier;
import com.api.modelDto.AntecedentDto;
import com.api.modelDto.DossierDto;

@Service(value="dossierService")
public class DossierServiceImpl implements IDossierService{
	
	@Autowired
	DossierDao dossierDao;
	
	@Autowired
	PatientServiceImpl patientService;
	@Override
	public Dossier save(DossierDto dossier) {
		Dossier newDossier = new Dossier();
		newDossier.setCreatAt(dossier.getCreatAt());
		newDossier.setId(dossier.getId());
		newDossier.setNumero(dossier.getNumero());
		newDossier.setPatient(patientService.save(dossier.getPatient()));
		List<Antecedent> liste = new ArrayList<>();
		for (AntecedentDto ant : dossier.getAntecedents()) {
			Antecedent antecedent = new Antecedent();
			antecedent.setId(ant.getId());
			antecedent.setLibelle(ant.getLibelle());
			liste.add(antecedent);
		}
		newDossier.setAntecedents(liste);
		return dossierDao.save(newDossier);
	}

	@Override
	public List<Dossier> findAll() {
		List<Dossier> allDossier = new ArrayList<>();
		dossierDao.findAll().iterator().forEachRemaining(allDossier::add);
		return allDossier;
	}

	@Override
	public Dossier getById(int id) {
		Optional<Dossier> optionalDossier = dossierDao.findById(id);
		return optionalDossier.isPresent() ? optionalDossier.get() : null;
	}

	@Override
	public void delete(int id) {
		dossierDao.deleteById(id);
	}

	@Override
	public DossierDto update(DossierDto dossier) {
		Dossier updateDossier = this.getById(dossier.getId());
		if (updateDossier != null) {
			BeanUtils.copyProperties(updateDossier, dossier);
		}
		return dossier;
	}

	@Override
	public List<Antecedent> allAntecedent(int id) {
		List<Antecedent> allAntecedent = new ArrayList<>();
		this.getById(id).getAntecedents().iterator().forEachRemaining(allAntecedent::add);
		return allAntecedent;
	}

}
