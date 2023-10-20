package generics;

import java.util.ArrayList;
import java.util.List;

public class Test7 {
	
	public static void main(String[] args) {
		
		
		// lab work	
			
				// create an unmodifiable list
				List<Integer> unmodifiableList = List.of(1,2,3,4);
//				unmodifiableList.set(0,9);
//				java.lang.UnsupportedOperationException
//				data is read only
				
				
				List<Integer> list = new ArrayList<>(List.of(1,2,3,4));
				System.out.println(list);
				
				// removes element from index 3
				System.out.println(list.remove(3));
				

	}

}
