package utils;

import static java.time.LocalDate.parse;

import java.util.HashMap;

import com.app.core.Customer;
import com.app.core.ServicePlan;

public class CustomerUtils {
	
	public static HashMap<String,Customer> populateCustomers(){
		
		HashMap<String,Customer> customerList = new HashMap<>();
		
		customerList.put("jatin@g.com", new Customer("jatin", "mitrani", "jatin@g.com", "password", 10000, parse("2000-01-01"),
				ServicePlan.PLATINUM));
		
		customerList.put("amar@g.com", new Customer("Amar", "phadtare", "amar@g.com", "amar", 10000, parse("2002-01-24"),
				ServicePlan.PLATINUM));
		
		
		customerList.put("manishahir@gmail.com", new Customer("manish", "ahir", "manishahir@gmail.com", "manya", 10000, parse("2000-01-15"),
				ServicePlan.PLATINUM));
		
		
		customerList.put("prashant@gmail.com", new Customer("prashant", "phadtare", "prashant@gmail.com", "amar", 10000, parse("2000-02-18"),
				ServicePlan.PLATINUM));
		
		
		return customerList;
	}

}
