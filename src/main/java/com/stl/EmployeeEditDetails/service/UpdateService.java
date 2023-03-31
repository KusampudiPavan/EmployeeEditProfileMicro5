package com.stl.EmployeeEditDetails.service;

import com.stl.EmployeeEditDetails.model.EmployeeModel;

public interface UpdateService {

	EmployeeModel updateEmployee(EmployeeModel employee, String email);
	String assingedmanager(String email);
}
