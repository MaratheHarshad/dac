package utils;

import static utils.CustomerValidation.validateCustomer;

import java.util.List;

import core.Customer;
import exceptions.CustomerHandlingException;

public class CustomerUtils {

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
