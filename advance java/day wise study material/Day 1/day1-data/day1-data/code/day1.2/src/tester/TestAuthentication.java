package tester;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import dao.UserDaoImpl;
import pojos.User;

public class TestAuthentication {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			
			System.out.println("Enter email and password for authentication");
			System.out.println(dao.authenticateUser(sc.next(), sc.next()));
			// clean up;
			dao.cleanUp();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
