package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AddressDao;
import dao.AddressDaoImpl;
import pojos.Address;

public class AssignEmpAddress {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			AddressDao dao=new AddressDaoImpl();
			System.out.println("Enter emp id");
			Long empId=sc.nextLong();
			System.out.println("Enter adr details : adrLine1,  adrLine2,  city,  state,  country,  zipCode");
			System.out.println(dao.assignEmpAddress
					(empId, new Address(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next())));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
