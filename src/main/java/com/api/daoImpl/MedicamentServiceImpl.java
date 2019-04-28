package com.api.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.daoInterface.IMedicamentService;
import com.api.daoInterface.MedicamentDao;
import com.api.model.DetailConsultation;
import com.api.model.Medicament;
import com.api.modelDto.MedicamentDto;

@Service(value="medicamentService")
public class MedicamentServiceImpl implements IMedicamentService{

	@Autowired
	MedicamentDao medicamentDao;
	
	@Override
	public Medicament save(MedicamentDto medicament) {
		Medicament newMedicament = new Medicament();
		newMedicament.setId(medicament.getId());
		newMedicament.setLibelle(medicament.getLibelle());
		return medicamentDao.save(newMedicament);
	}

	@Override
	public List<Medicament> findAll() {
		List<Medicament> allMedicament = new ArrayList<>();
		medicamentDao.findAll().iterator().forEachRemaining(allMedicament::add);
		return allMedicament;
	}

	@Override
	public void delete(int id) {
		medicamentDao.deleteById(id);
	}

	@Override
	public MedicamentDto update(MedicamentDto medicament) {
		Medicament updateMedicament = medicamentDao.getOne(medicament.getId());
		if (updateMedicament != null) {
			BeanUtils.copyProperties(updateMedicament, medicament);
		}
		return medicament;
	}

	@Override
	public List<DetailConsultation> allDetailConsultation(int id) {
		List<DetailConsultation> allDetailConsultation = new ArrayList<>();
		this.getById(id).getDetailConsultations().iterator().forEachRemaining(allDetailConsultation::add);
		return allDetailConsultation;
	}



	@Override
	public Medicament getById(int id) {
		Optional<Medicament> optionalMedicament = medicamentDao.findById(id);
		return optionalMedicament.isPresent() ? optionalMedicament.get() : null;
	}

}
