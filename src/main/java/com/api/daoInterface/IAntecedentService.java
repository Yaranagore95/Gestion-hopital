package com.api.daoInterface;

import java.util.List;

import com.api.model.Antecedent;
import com.api.model.Dossier;
import com.api.modelDto.AntecedentDto;

public interface IAntecedentService {
	Antecedent save(AntecedentDto antecedent);
	List<Antecedent> findAll();
	Antecedent geById(int id);
	void delete(int id);
	AntecedentDto update(AntecedentDto antecedent);
	List<Dossier> allDossier(int id);
}
