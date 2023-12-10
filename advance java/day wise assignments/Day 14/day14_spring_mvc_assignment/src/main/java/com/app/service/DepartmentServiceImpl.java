package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DepartmentDao;
import com.app.pojos.Department;
import com.app.pojos.Employee;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	//dep
	@Autowired
	private DepartmentDao deptDao;

	

	@Override
	public List<Employee> getAllEmpsOfDept(String dept) {
		return deptDao.getAllEmpsOfDept(dept);
	}



	@Override
	public List<String> getAllDepartments() {
		return deptDao.getAllDepartments();
	}

}
