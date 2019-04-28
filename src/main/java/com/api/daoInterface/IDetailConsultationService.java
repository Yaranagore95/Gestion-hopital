package com.api.daoInterface;

import java.util.List;

import com.api.model.Consultation;
import com.api.model.DetailConsultation;
import com.api.model.Medicament;
import com.api.modelDto.DetailConsultationDto;

public interface IDetailConsultationService {
	DetailConsultation save(DetailConsultationDto detailConsultation);
	List<DetailConsultation> findAll();
	DetailConsultation getById(int id);
	void delete(int id);
	DetailConsultationDto update(DetailConsultationDto detail);
	Consultation getConsultation(int id);
	List<Medicament> allMedicament(int id);
}
