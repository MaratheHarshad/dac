package comparators;

import java.util.Comparator;

import com.app.core.Customer;

public class CustomerDobComparator implements Comparator<Customer>{
	
	
	@Override
	public int compare(Customer o1, Customer o2) {
				
		return o1.getDob().compareTo(o2.getDob());
		
	}

}
