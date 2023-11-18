package tester;

import java.util.Scanner;

import dao.UserDao;
import dao.UserDaoImpl;
import pojos.User;


public class TestUpdateVotingStatus {
	
	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)){
			
			// init phase
			UserDao userDao = new UserDaoImpl();
			
			// servicing phase
			
			// authenticate the user
			User user = userDao.authenticateUser(sc.next(), sc.next());
			
			if(user == null) {
				
				System.out.println("user does not exist");
				
			}else {
				// if user is valid
				
				userDao.updateVotingStatus(user);
				
			}
			
			
			// destroy phase
			
			userDao.cleanUp();
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
}
