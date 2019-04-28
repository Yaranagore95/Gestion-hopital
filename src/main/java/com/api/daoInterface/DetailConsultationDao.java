package com.api.daoInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.DetailConsultation;

public interface DetailConsultationDao extends JpaRepository<DetailConsultation, Integer>{

}
