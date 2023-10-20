package utils;

import static utils.CustomerValidation.validateCustomer;

import java.util.ArrayList;
import java.util.List;

import core.Customer;
import core.ServicePlan;
import exceptions.CustomerHandlingException;

import static java.time.LocalDate.*;

public class CustomerUtils {
	
	
//	add a method to populat the list of Customers
	
	
	public static List<Customer> populateCustomers(){
		
		List<Customer> customerList = new ArrayList<>();
		
		
		customerList.add(new Customer("Harshad", "Marathe", "harshadmarathe1@gmail.com", "pass",  10000, parse("2002-04-20"), parse("2023-03-01"), ServicePlan.PLATINUM));
		
		
		customerList.add(new Customer("Nayan", "Marathe", "nayanmarathe1@gmail.com", "pass",  10000, parse("2004-07-29"), parse("2023-09-30"), ServicePlan.PLATINUM));
		
		return customerList;
	}

	public static Customer signInCustomer(String email, String password, List<Customer> customerList) throws CustomerHandlingException {

		int index = validateCustomer(email, password, customerList);

		return customerList.get(index);

	}

	public static Customer unSubscribeCustomer(String email, String password, List<Customer> customerList) throws CustomerHandlingException {

		int index = validateCustomer(email, password, customerList);
		
		return customerList.remove(index);
	}

	public static Customer changePassword(String email, String password, String newPassword, List<Customer> customerList) throws CustomerHandlingException {

		int index = validateCustomer(email, password, customerList);
		
		customerList.get(index).setPassword(newPassword);
		
		return customerList.get(index);
	}

}
