package com.api.daoInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Patient;

public interface PatientDao extends JpaRepository<Patient, Integer>{

}
