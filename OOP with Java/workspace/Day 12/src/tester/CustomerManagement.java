package tester;

import static utils.CustomerUtils.changePassword;
import static utils.CustomerUtils.populateCustomers;
import static utils.CustomerUtils.signInCustomer;
import static utils.CustomerUtils.unSubscribeCustomer;
import static utils.CustomerValidation.validateAll;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import core.Customer;
import core.ServicePlan;

public class CustomerManagement {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)){
			
//			initialization phase
			
//			List<Customer> customerList = new ArrayList<>();
			// populate the list from the CustomerUtils
			
			List<Customer> customerList = populateCustomers();
			boolean exit = false;
			
//			user interaction phase
			while(!exit) {
				
				try {
					
					System.out.println("Customer Management System");
					System.out.println("1. Sign up");
					System.out.println("2. Sign in");
					System.out.println("3. Change Password");
					System.out.println("4. Un Subscribe Customer");
					System.out.println("5. Display All Customers");
					
					System.out.println("Available Subscriptions ");
					for(ServicePlan p : ServicePlan.values()) {
						System.out.println(p + " " + p.getAmount());
					}
					
					
					switch(sc.nextInt()) {
					
					
					// sign up the user	
					case 1:{
						
						 System.out.println("Enter the details: firsName, lastName, email, password, registrationAmount, dob(yyyy-mm-dd) , plan");
						 
						 Customer cust = validateAll(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(), customerList);
						
						 customerList.add(cust);
						 
						 System.out.println("Sign Up Successfully");
						
						break;
					}
					
					
					// sign in the user
					
					case 2:{
						
						System.out.println("Enter The email and password for sign in ");
						
						Customer validateCustomer = signInCustomer(sc.next(), sc.next(), customerList);
						
						
						System.out.println("Customer sign in successfully");
						break;
					}
					
					case 3:{
//						change password
//						take email, oldpass, newpass from user
						
						System.out.println("Enter user name, old password and new password");
						Customer validateCustomer = changePassword(sc.next(), sc.next(), sc.next() , customerList);
						
						// whatever the third input to scanner has already stored in the buffer , i.e sc.next() no need to take separated input (automatically ready from the buffer)
//						validateCustomer.setPassword(sc.next());
						
						System.out.println("Password updated successfully ");				
						break;
					}
					
					case 4:{
						
						// Un subscribe customer
						// take user name and password
						System.out.println("Enter user name and password");
						Customer cust = unSubscribeCustomer(sc.next(), sc.next(), customerList);
						
						System.out.println("Unsubscribe Customer");
						System.out.println(cust);
						
						
						break;
					}
					
					case 5: {
						// display all the customers
						
						for(Customer c : customerList) {
							System.out.println(c);
						}
						
						break;
					}
					
					
					case 6:{
						
						System.out.println("Remove all those customer details whose subscription is pending for last 6 months");
						
						ListIterator<Customer> custItr = customerList.listIterator();
						
						LocalDate today = LocalDate.now();
						
						while(custItr.hasNext()) {
							Period p  = Period.between(custItr.next().getLastSubscriptionDate(), today);
							if(p.toTotalMonths() > 6) {
								custItr.remove();
							}
						}
						
						break;
					}
					
					}
				}catch(Exception e) {
					System.out.println(e);
					System.out.println("pls retry...");
					sc.nextLine();
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
		

	}

}
//Remove all those customer details whose subscription is pending for last 6 months?
//(as discussed earlier)



/*
 * Customer management system Supply Options 1. Sign up (customer registration)
 * 2. Sign in (login) i/p : email n password 3. Change password i/p : email n
 * old password n new password 4. Un subscribe customer i/p : customer email
 */