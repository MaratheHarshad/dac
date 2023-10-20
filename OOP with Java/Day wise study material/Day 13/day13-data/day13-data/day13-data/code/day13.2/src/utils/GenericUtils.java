package utils;

import java.util.Collection;
import java.util.List;

import com.app.core.Emp;

public class GenericUtils {
	/*
	 * 1. Add a method to print all elements from any of the following 
	 * Test cases :
	 * AL<String> , LL<Integer> , Vector<LocalDate> ,
	 *  HS<Double> , LHS,TS
	 */
//	public static void printElements(Collection<Object> collection) {
//		for(Object o : collection)
//			System.out.println(o);
//		
//	}
	public static void printElements(Collection<?> collection) {
		for(Object o : collection)
			System.out.println(o);
		
	}
	/*
	 * Add a method to find sum of salary of emps from any List 
Test cases : AL<Mgr> ,LL<Worker> , Vector<SM> ....
	 */
	

	public static double sumOfSalaries(List<? extends Emp> list) {
		double sum=0;
		
		for (Emp e : list) 
			sum += e.computeSalary();
			
		
		return sum;
	}
	
	/* Add a method to find the occurrence of element in a list
	 * */
	
//	generic arguments in this list tells that 
//	this method method accepts a 
//	list of any type (?) and any element type as T
//	since it is a generic method inside non-generic class
//	declaration of unknown type goes between
//	modifiers and return type (<T> here)
//	modifiers(public static) <T> return type(int)
	
	public static <T> int countOccurence(List<?> list, T elem) {
		
		int count = 0;
		
		for(Object o : list) {
			if(o.equals(elem)) {
				count++;
			}
		}
		
		return count;
	}
	
	

}

	

