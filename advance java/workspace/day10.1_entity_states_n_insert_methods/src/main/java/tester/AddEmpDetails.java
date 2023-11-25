package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmploymentType;

public class AddEmpDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			// create dao instance
			EmployeeDao empDao = new EmployeeDaoImpl();
			System.out.println(
					"Enter emp details : firstName,  lastName,  email,  password,  joinDate,	 empType,  salary");
			// create transient entity /pojo
			Employee emp = new Employee(sc.next(), sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()),
					EmploymentType.valueOf(sc.next().toUpperCase()), sc.nextDouble());
			System.out.println("emp id "+emp.getEmpId()); //null
			
			// in case of session.save(..) 
			// Hibernate forgives and PERSIST the data in db
			
			// in case of persist
//			if id is null -> record inserted
//			emp.setEmpId(123l);//non null id with not  existing rec in db -> PersistenceObjectException
//			emp.setEmpId(1l); // non null id with existing rec in db -> PersistenceObjectException
			

			// in case of saveOrUpdate
//			if id is null -> record inserted
//			emp.setEmpId(123l);//non null id with not  existing rec in db -> org.hibernate.StaleObjectStateException
//			emp.setEmpId(1l); // non null id with existing rec in db -> record generated
			
			
			System.out.println(empDao.saveEmpDetails(emp));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
