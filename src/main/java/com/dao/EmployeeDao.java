package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.EmployeeEntity;

public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {

	EmployeeEntity findByEmailIdAndPassword(String email, String pswd);  //must to mention this method here as it is a derived method
	
	List<EmployeeEntity> findAll();//it is not mandatory to mention this method here (as it is inbuilt method)
	
}
