package tester;

import static utils.CustomerUtils.populateCustomers;
import static utils.CustomerValidationRules.authenticateCustomer;
import static utils.CustomerValidationRules.validateAllInputs;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Customer;


import static IOUtils.IOHandling.*;


public class CMS {

	public static void main(String[] args) {
		
		Map<String, Customer> customers = null;
		
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			// D.S : exam tip : start with populated sample data
			
//			read file stored data at a time entering a application
			customers = readData();
			
//			write data in a file, as object stream (at a time leaving the application)

			
			while (!exit) {
				
				System.out.println(" 1. SignUP\n 2. Signin\n 3. Change Password\n 4. Un subscribe\n 5. Display\n 6. sort according email(primary key)\n 7. Sort according email descending\n 8. sort according to dob 0.Exit\n ");
				
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
						
						
//						for(Customer c: customers.values()) {
//							System.out.println(c);
//						}
						
//						declarative way
						customers.forEach((k,v) -> System.out.println(v));
						
						break;
						
						
					case 6:
						
						// sort according email(primary key)
						
//						TreeMap<String, Customer> tmap = new TreeMap<>(customers);
//						
//						
//						for(Customer c: tmap.values()) {
//							System.out.println(c);
//						}
						
						customers.values().stream().sorted().forEach(System.out::println);
						
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
						
						
						
//						TreeMap<String, Customer> dtmap = new TreeMap<>(new CustomerDescComparator());
//						dtmap.putAll(customers);
//						
//						for(Customer c: dtmap.values()) {
//							System.out.println(c);
//						}
						
						
//						using functional programming , stream api, lambda expression
//						convert map to Collection then create stream of Stream<Customer> then sort according to the comparator(lambda expression), and print simply using termination operation forEach
						
						customers.values().stream().sorted((o1, o2)-> o2.getEmail().compareTo(o1.getEmail())).forEach(System.out::println);
						
						
						
						break;

					case 8:
						
//						sort according to dob
						
//						Collection<Customer> list = customers.values();
//						List<Customer> l = new ArrayList<>(list);
//						Collections.sort(l, new CustomerDobComparator());
//						
//						
//						for(Customer c : l) {
//							System.out.println(c);
//						}
						
						customers.values().stream().sorted((o1, o2)-> o1.getDob().compareTo(o2.getDob())).forEach(v -> System.out.println(v));
						
						
						
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
			

		}finally {
			writeData(customers, "data.ser");
		}
		

	}

}

// every time application is started fetched data from the -> file
// every time closing the application save the data in -> file
// use stream api
// use lambda expression for functionalinterface(interface with sam)


