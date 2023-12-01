package tester;

import static utils.HibernateUtils.getFactory;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AddressDao;
import dao.AddressDaoImpl;
import pojos.Department;

public class DisplayEmployeeLastnamesByCity {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			AddressDao dao = new AddressDaoImpl();
			
			// last names of all employees from the same city
			System.out.println("Enter city name : ");
			List<String> lastNames = dao.getLastNamesOfEmployeesByCity(sc.next());

			
			for(String lastName  : lastNames) {
				System.out.println(lastName);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
