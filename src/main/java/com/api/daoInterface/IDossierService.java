package com.api.daoInterface;

import java.util.List;

import com.api.model.Antecedent;
import com.api.model.Dossier;
import com.api.modelDto.DossierDto;

public interface IDossierService {
	Dossier save(DossierDto dossier);
	List<Dossier> findAll();
	Dossier getById(int id);
	void delete(int id);
	DossierDto update(DossierDto dossier);
	List<Antecedent> allAntecedent(int id);
}
