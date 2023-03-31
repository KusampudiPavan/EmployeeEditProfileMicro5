package com.stl.EmployeeEditDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stl.EmployeeEditDetails.model.EmployeeModel;
import com.stl.EmployeeEditDetails.service.UpdateService;

@RequestMapping("employee")
@RestController
@CrossOrigin("http://localhost:3000")
public class UpdateController {

	@Autowired
	UpdateService updateservice;
	
	//Update Employee
	@PutMapping("/update/{email}")
	public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable("email") String email,@RequestBody EmployeeModel employee){
		String pass = employee.getPassword();
		employee.setPassword(new BCryptPasswordEncoder().encode(pass));
		return new ResponseEntity<EmployeeModel> (updateservice.updateEmployee(employee, email),HttpStatus.OK);
	}
	
	
	@GetMapping("/getassignedmanager/{email}")
	public String assingedmanager(@PathVariable("email") String email) {
		return updateservice.assingedmanager(email);
	}
}
