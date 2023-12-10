package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.DepartmentService;

@Controller // mandatory cls level anno , to tell SC ,
//following class is req handling  spring bean : singleton n eager
@RequestMapping("/dept")
public class DepartmentController {
	
	
//	dependency
	
	@Autowired
	private DepartmentService departmentService;
	
	public DepartmentController() {
		System.out.println("in ctor of " + getClass());
	}
	
	
	@GetMapping("/list")
	public String getDepartments(Model model) {
		System.out.println("in get departments method of " + getClass());
		
		model.addAttribute("dept_list", departmentService.getAllDepartments());
		
		return "/dept/deptlist";
	}
	
	
	
	//how to tell SC , following method is going handle a rq ending in /hello
	@GetMapping("/employees")
	//SC will add the  entry : HandlerMapping bean
	//key : /dept/employees
	//Value : com.app.controller.DepartmentController.getEmployeesByDepartment
	public String getEmployeesByDepartment(@RequestParam String deptName, Model model) {
		System.out.println("in display Employees");
		
		
		// SC maps this returned list with this key(employees)
		model.addAttribute("emp_list", departmentService.getAllEmpsOfDept(deptName));
		
		return "/dept/employees";//LVN --D.S ----> V.R
		// AVN http://host:port/day14_spring_mvc_assignment/dept/employees.jsp
	}
}
