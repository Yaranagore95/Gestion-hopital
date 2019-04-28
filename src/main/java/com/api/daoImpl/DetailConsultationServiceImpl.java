package com.api.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.daoInterface.DetailConsultationDao;
import com.api.daoInterface.IDetailConsultationService;
import com.api.model.Consultation;
import com.api.model.DetailConsultation;
import com.api.model.Medicament;
import com.api.modelDto.DetailConsultationDto;
import com.api.modelDto.MedicamentDto;

@Service(value="detaiConsultationsService")
public class DetailConsultationServiceImpl implements IDetailConsultationService{

	@Autowired
	DetailConsultationDao detailConsultationDao;
	
	@Autowired
	MedicamentServiceImpl medicamentService;
	
	@Override
	public DetailConsultation save(DetailConsultationDto detailConsultation) {
		DetailConsultation dtConsultation = new DetailConsultation();
		dtConsultation.setDosage(detailConsultation.getDosage());
		dtConsultation.setId(detailConsultation.getId());
		List<Medicament> liste = new ArrayList<>();
		for (MedicamentDto medicament : detailConsultation.getMedicaments()) {
			liste.add(medicamentService.save(medicament));
		}
		dtConsultation.setMedicaments(liste);
		return detailConsultationDao.save(dtConsultation);
	}

	@Override
	public List<DetailConsultation> findAll() {
		List<DetailConsultation> allDetail = new ArrayList<>();
		detailConsultationDao.findAll().iterator().forEachRemaining(allDetail::add);
		return allDetail;
	}

	@Override
	public DetailConsultation getById(int id) {
		Optional<DetailConsultation> optional = detailConsultationDao.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public void delete(int id) {
		detailConsultationDao.deleteById(id);
	}

	@Override
	public DetailConsultationDto update(DetailConsultationDto detail) {
		DetailConsultation dtConsultation = this.getById(detail.getId());
		if (dtConsultation != null) {
			BeanUtils.copyProperties(dtConsultation, detail);
		}
		return detail;
	}

	@Override
	public Consultation getConsultation(int id) {
		return this.getById(id).getConsultation();
	}

	@Override
	public List<Medicament> allMedicament(int id) {
		List<Medicament> allMedicament = new ArrayList<>();
		this.getById(id).getMedicaments().iterator().forEachRemaining(allMedicament::add);
		return allMedicament;
	}

}
