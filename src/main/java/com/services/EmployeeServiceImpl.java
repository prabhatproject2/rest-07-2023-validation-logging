package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmployeeDao;
import com.dto.EmployeeDTO;
//import com.dao.EmployeeDao;
import com.entity.EmployeeEntity;


@Service
@Transactional

public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired 
	EmployeeDao  employeeDao;
	
	
	@Override
	public void saveEmployee(EmployeeDTO employeeDTO) {	
		EmployeeEntity employeeEntity=new EmployeeEntity();
		BeanUtils.copyProperties(employeeDTO, employeeEntity);		
		employeeDao.save(employeeEntity);//It is not mandatory to mention this save() in repository(dao interface as it is inbuilt method)			
		
	}
	
	@Override
	public EmployeeEntity authenticate(String email, String pswd) {		
		EmployeeEntity employeeEntity=employeeDao.findByEmailIdAndPassword(email,pswd);	//derived method
		return employeeEntity;
	}

	@Override
	public List<EmployeeDTO> findAllEmployee() {
		
	List<EmployeeEntity> employeeEntityList=employeeDao.findAll();	
	
	List<EmployeeDTO> empDTOList=new ArrayList<>();
	for(EmployeeEntity employeeEntity  :employeeEntityList) {
		EmployeeDTO employeeDTO =new EmployeeDTO();		
		BeanUtils.copyProperties(employeeEntity, employeeDTO);	
		empDTOList.add(employeeDTO);
		
	}
		
		return empDTOList;
	}
	
	@Override
	public void deleteEmp(int employeeId) {
		
		employeeDao.deleteById(employeeId);
	}
	
	@Override
	public EmployeeDTO findByEmployeeId(int employeeId) {
		
		Optional<EmployeeEntity> optional=employeeDao.findById(employeeId);
		if(optional.isPresent()) {
			
			EmployeeEntity employeeEntity=optional.get();
			EmployeeDTO employeeDTO =new EmployeeDTO();		
			BeanUtils.copyProperties(employeeEntity, employeeDTO);				
			
			return employeeDTO;
		}
		
		
	
		return null;
	}
	
	@Override
	public void updateEmployee(EmployeeDTO employeeDTO) {	
		
		EmployeeEntity employeeEntity =new EmployeeEntity();		
		BeanUtils.copyProperties(employeeDTO, employeeEntity);
		
		employeeDao.save(employeeEntity);		
	}


	
}
