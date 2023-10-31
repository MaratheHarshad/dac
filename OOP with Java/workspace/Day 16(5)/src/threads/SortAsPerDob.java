package threads;

import static IOUtils.IOHandling.*;

import java.util.HashMap;
import java.util.Map;

import com.app.core.Customer;

public class SortAsPerDob implements Runnable {

	Map<String, Customer> customers;
	
	public SortAsPerDob(Map<String, Customer> customers) {
		this.customers = customers;
	}
	
	@Override
	public void run() {
		
		
//		Map<String, Customer> map = new HashMap<>();
		
		
//		customers.values().stream().sorted((o1, o2) -> o1.getDob().compareTo(o2.getDob()))
//		.forEach(v -> map.put(v.getEmail(), v));
//		
//		
//		writeData(map, "asperdob.ser");
//		
//		System.out.println("customer after stream");
//		System.out.println(customers);
		
		
//		here we're using extra storage (might be not correct approach)
		
		Map<String, Customer> map = new HashMap<>();
		
		
		customers.values().stream().sorted((o1, o2) -> o1.getDob().compareTo(o2.getDob()))
		.forEach(v -> map.put(v.getEmail(), v));
		
		
		writeStringData(map, "stringdob.ser");
		
		
	}

}
