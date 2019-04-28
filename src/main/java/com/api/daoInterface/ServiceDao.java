package com.api.daoInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Service;

public interface ServiceDao extends JpaRepository<Service, Integer>{

}
