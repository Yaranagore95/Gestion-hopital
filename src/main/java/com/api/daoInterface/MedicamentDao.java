package com.api.daoInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Medicament;

public interface MedicamentDao extends JpaRepository<Medicament, Integer>{

}
