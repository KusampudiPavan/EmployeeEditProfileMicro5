package com.stl.EmployeeEditDetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stl.EmployeeEditDetails.exception.ResourceNotFoundException;
import com.stl.EmployeeEditDetails.model.EmployeeModel;
import com.stl.EmployeeEditDetails.repository.UpdateRepo;

@Service
public class UpdateServiceImpl implements UpdateService{
	
	@Autowired
	UpdateRepo updaterepo;

	@Override
	public EmployeeModel updateEmployee(EmployeeModel employee, String email) {
		EmployeeModel existingEmployee = updaterepo.findById(email).orElseThrow(() -> new ResourceNotFoundException("Employee","Id",email));
		existingEmployee.setFirstname(employee.getFirstname());
		existingEmployee.setLastname(employee.getLastname());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setPhonenumber(employee.getPhonenumber());
		//existingEmployee.setPassword(employee.getPassword());
		existingEmployee.setManageremail(employee.getManageremail());
		existingEmployee.setGender(employee.getGender());
		updaterepo.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public String assingedmanager(String email) {
		return updaterepo.assingedmanager(email);
	}

	
}
 