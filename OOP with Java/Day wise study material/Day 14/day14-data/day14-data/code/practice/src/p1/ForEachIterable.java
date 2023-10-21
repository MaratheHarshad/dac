package p1;

import java.util.ArrayList;
import java.util.List;

import java.util.function.Consumer;

public class ForEachIterable implements Consumer<Integer>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list = new ArrayList<>(List.of(2,4,5,6,7,8,3,1));
		
//		imperative way to display all elements
//		loop throught the list and then print
		
		// Consumer is a functional interface
		// functional interface -> interface with single abstract method (SAM)
		// SAM -> accept
		// which takes parameter -> accept(T t)
		// to use this 
		// Iterables forEach functionality
		// forEach takes -> Consumer implemented instance
		// or we can simply replace it by functional programming way using lambda expression
		
		
		
		list.forEach(new ForEachIterable()); 
		System.out.println();
		
		// declarative programming
		// just logic for what to be done
		list.forEach((i)->{System.out.print(i + " ");});
		System.out.println();
//		sort list as per desc order
		
		list.sort((e1, e2) -> e2.compareTo(e1));
		list.forEach(e -> System.out.print(e + " "));

	}

	@Override
	public void accept(Integer t) {
		// TODO Auto-generated method stub
		System.out.print(t + " ");
		
	}
	
	

}


