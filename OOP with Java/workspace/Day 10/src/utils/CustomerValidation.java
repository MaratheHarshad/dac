package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import core.Customer;
import core.ServicePlan;
import exceptions.CustomerHandlingException;;

public class CustomerValidation {

		public static Customer validateAll(String firsName, String lastName, String email, String password, double registrationAmount,
				String dob, String plan, List<Customer> list) throws CustomerHandlingException, DateTimeParseException, IllegalArgumentException
		{
			validateEmail(email);
			// if control comes over means email is valid and parsable
			validateDups(email, list);
			// if control reaches over means 
			ServicePlan p = validatePlan(plan);
			// if control reaches here, means user entered service plan is valid
			validateRegistrationAmount(registrationAmount, p);
			LocalDate dateOfBirth = validateAndParseDob(dob);
			
			// if till now exception is not throws means all the data validated
			
			Customer customer = new Customer(firsName, lastName, email, password, registrationAmount, dateOfBirth, p);
			
			
			return customer;
			
		}
		
		
		public static int validateCustomer(String email, String password, List<Customer> customerList) throws CustomerHandlingException {
			
			
			
//			parse the email first
			validateEmail(email);
//			check whether Customer with email exist in list
			Customer cust = new Customer(email);
			
			int index = customerList.indexOf(cust);
			
			if(index == -1) {
				throw new CustomerHandlingException("Customer Does Not exist, Invalid email");
				
			}
			
			if(!customerList.get(index).getPassword().equals(password)) {
				throw new CustomerHandlingException("Password Did not match");
			}
			
			return index;
			
		}
		
		public static void validateDups(String email, List<Customer> list) throws CustomerHandlingException {
			
			Customer c = new Customer(email);
			
			if(list.contains(c)) {
				throw new CustomerHandlingException("Customer Already Exists !!!!!");
			}
			
			
		}
		
		// email validation
		// if email is not valid throw exception other wise continue
		public static void validateEmail(String email) throws CustomerHandlingException{
			
			 String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";  
		     
		     Pattern pattern = Pattern.compile(regex);  
		        
		     //Create instance of matcher   
		     Matcher matcher = pattern.matcher(email);  
		         
		     if (!matcher.matches()) {
		    	 throw new CustomerHandlingException("Invalid email Exception");
		     }
		
		}
		
		// dob 
		// parse the String if parsable other wise throw the exception (whatever exception)
//		if parsable return LocalDate format
		
		public static LocalDate validateAndParseDob(String dob) throws DateTimeParseException {
			
			
			LocalDate d = LocalDate.parse(dob);
			
			
			return d;
		}
		
		public static ServicePlan validatePlan(String plan) throws IllegalArgumentException {
			
			ServicePlan p = ServicePlan.valueOf(plan.toUpperCase());
			
			return p;
		} 
		
		
		// validate registration amount match with PLAN or not 
		public static void validateRegistrationAmount(double amount, ServicePlan plan) throws CustomerHandlingException {
			
//			narrowing -> double to int for amount comparison
			if (plan.getAmount() != (int)amount) {
				throw new CustomerHandlingException("Registratio Amount Did not match with the Service Plan");
			}
		}
}
