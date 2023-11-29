package tester;

import static utils.HibernateUtils.getFactory;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import pojos.Department;

public class DisplayAllDepartmentAndEmpDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			DepartmentDao dao = new DepartmentDaoImpl();
			
			List<Department> departments = dao.getDeptAndEmployees();
//			System.out.println("Dept details ");
//			System.out.println(department);
//			System.out.println("Emp details ");
			
			for(Department department  : departments) {
				System.out.println(department);
				department.getEmployees().forEach(System.out::println);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
