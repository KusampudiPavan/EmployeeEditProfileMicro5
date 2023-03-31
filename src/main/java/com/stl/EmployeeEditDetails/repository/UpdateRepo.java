package com.stl.EmployeeEditDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stl.EmployeeEditDetails.model.EmployeeModel;


public interface UpdateRepo extends JpaRepository<EmployeeModel, String> {


	@Query(value = "select manageremail from employee where email = ?;", nativeQuery = true)
	public String assingedmanager(String email);
}
