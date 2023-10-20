package comparators;

import java.util.Comparator;

import com.app.core.Customer;

public class CustomerDescComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		
		
		return o2.compareTo(o1);
//		return o2.toString().compareTo(o1.toString());
		
	}
		

}
