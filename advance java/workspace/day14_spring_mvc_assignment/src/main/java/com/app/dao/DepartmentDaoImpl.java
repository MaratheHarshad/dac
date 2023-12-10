package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;
import com.app.pojos.Employee;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	//dep : 
	@Autowired //byType
	private SessionFactory sf;

	@Override
	public List<Employee> getAllEmpsOfDept(String deptName) {
		
		// approach 1
		// in Dept Data Access Object layer
		// get the list of employees
		// return the list
		
		
		
		String jpql = "select d from Department d left join fetch d.employees where d.name = :deptName";
		
		Department d = sf.getCurrentSession().createQuery(jpql, Department.class).setParameter("deptName", deptName).getSingleResult();
		
		return d.getEmployees();
	}

	@Override
	public List<String> getAllDepartments() {
		String jpql = "select d.name from Department d";
		return sf.getCurrentSession().createQuery(jpql, String.class).getResultList();
	}

}
