package threads;

import static IOUtils.IOHandling.writeStringData;

import java.util.HashMap;
import java.util.Map;

import com.app.core.Customer;

public class SortAsPerEmail implements Runnable {

	Map<String, Customer> customers;
	
	public SortAsPerEmail(Map<String, Customer> customers) {
		this.customers = customers;
	}
	
	@Override
	public void run() {
		
		
		Map<String, Customer> map = new HashMap<>();
		
		
		customers.values().stream().sorted((o1, o2) -> o2.getEmail().compareTo(o1.getEmail()))
		.forEach(v -> map.put(v.getEmail(), v));
		
		
		writeStringData(map, "stringemail.ser");
		
	}

}
