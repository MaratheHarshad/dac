package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AddressDao;
import dao.AddressDaoImpl;

public class DisplayEmployeeAddress {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			AddressDao dao = new AddressDaoImpl();
			
			System.out.println("Enter empid to get address : ");
			
			System.out.println(dao.getEmpAddress(sc.nextLong()));
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
