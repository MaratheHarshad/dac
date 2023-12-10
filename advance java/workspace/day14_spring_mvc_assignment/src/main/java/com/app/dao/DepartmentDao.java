package com.app.dao;

import java.util.List;

import com.app.pojos.Employee;

public interface DepartmentDao {

	
	// add a method to get all empl of specific department
	
	List<Employee> getAllEmpsOfDept(String dept);
	

	// add a method to get all the depts names
	List<String> getAllDepartments();
}
