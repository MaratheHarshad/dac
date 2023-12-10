package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface DepartmentService {

	
	// add a method to get all empl of specific department
	
	List<Employee> getAllEmpsOfDept(String dept);
	
	
	// add a method to get all the depts
	List<String> getAllDepartments();
	
}
