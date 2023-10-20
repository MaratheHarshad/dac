package generics;

import java.util.ArrayList;


import java.util.LinkedList;
import java.util.List;

import static utils.GenericUtils.*;

// lab work : day 13

public class Test6 {
	
	public static void main(String[] args) {
		
		
		ArrayList<Integer> list1 = new ArrayList<>(List.of(1,2,3,4,5,5,5,6,7,8,7,9));
		System.out.println(countOccurence(list1, 7));
		
		
		
		LinkedList<Integer> list2 = new LinkedList<>(List.of(1,2,3,4,5,5,5,6,7,8,7,9));
		
		System.out.println(countOccurence(list2, 3));
		System.out.println(countOccurence(list2, "count")); // return 0
		
		
	}
}
