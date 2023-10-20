package tester;

import static utils.CustomerUtils.populateCustomers;
import static utils.CustomerValidationRules.authenticateCustomer;
import static utils.CustomerValidationRules.validateAllInputs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.core.Customer;

import comparators.CustomerDescComparator;
import comparators.CustomerDobComparator;

public class CMS {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			// D.S : exam tip : start with populated sample data
			
			Map<String, Customer> customers = populateCustomers();
			
			while (!exit) {
				
				System.out.println("1. SignUP 2. Signin 3.Change Password 4.Un subscribe 5. Display 6. sort according email(primary key) 7. Sort according email descending 8. sort according to dob 0.Exit");
				
				try {
					switch (sc.nextInt()) {
					case 1: // reg
						System.out.println(
								"Enter firstName,  lastName,  email,  password, regAmount,  dob(yr-mon-day),  plan");
						Customer customer = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(), customers);
						customers.put(customer.getEmail(), customer);
						System.out.println("customer signed up !");
						break;
					case 2: // sign in
						System.out.println("Enter email n pwd");
						customer=authenticateCustomer(sc.next(), sc.next(), customers);
						System.out.println("Login successful , your details " + customer);

						break;
					case 3:
						
						// change password
						System.out.println("Enter email n old pwd and new pwd");
						customer=authenticateCustomer(sc.next(), sc.next(), customers);
						
						customer.setPassword(sc.next());
						
						
						System.out.println("pwd cng fr ctmr");
						
						

						break;
					case 4:
						
						System.out.println("Enter email and pwd to unsubarcribe");
						customer=authenticateCustomer(sc.next(), sc.next(), customers);
						
						customers.remove(customer.getEmail());
						
						System.out.println("Customer removed successfully");
						break;
						
					case 5:
						
						// display all
						for(Customer c: customers.values()) {
							System.out.println(c);
						}
						
						break;
						
						
					case 6:
						
						// sort according email(primary key)
						
						TreeMap<String, Customer> tmap = new TreeMap<>(customers);
						
						
						for(Customer c: tmap.values()) {
							System.out.println(c);
						}
						
						break;
						
					case 7:
//						
//						Collection<Customer> cust = customers.values();
//						
//						List<Customer> list = new ArrayList<>(cust);
//						
//						Collections.sort(list);
//						
//						LinkedHashMap<String, Customer> lhm = new LinkedHashMap<>();
//						
//						for(Customer c : list )
//						{
//							lhm.put(c.getEmail(), c);
//						}
//						
//						
//						System.out.println(lhm);
						
						
						
						
						
						
//						TreeMap<String, Customer> dtmap = new TreeMap<>(Collections.reverseOrder());
//						dtmap.putAll(customers);
//						
//						System.out.println(dtmap);
						
						
						
						TreeMap<String, Customer> dtmap = new TreeMap<>(new CustomerDescComparator());
						dtmap.putAll(customers);
						
						for(Customer c: dtmap.values()) {
							System.out.println(c);
						}
						
						break;

					case 8:
						
//						sort according to dob
						
						Collection<Customer> list = customers.values();
						List<Customer> l = new ArrayList<>(list);
						Collections.sort(l, new CustomerDobComparator());
						
						
						for(Customer c : l) {
							System.out.println(c);
						}
						
						
						
						break;
					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
					
				}
			}

		}

	}

}
