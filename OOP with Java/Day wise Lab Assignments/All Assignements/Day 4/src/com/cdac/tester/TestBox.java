package com.cdac.tester;
import java.util.Scanner;
import com.cdac.core.Box;


class TestBox {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//create scanner cls instance to wrap stdin
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Number Of Boxes To store : ");
		
//		box array class is loaded into method area and , array object is created in heap containing cp, length, indexes initialized with default values as null because it is an array of references
		Box [] boxes = new Box[sc.nextInt()];
		
		
		
		System.out.println("Before init ");
		for(Box b : boxes) {
			System.out.println(b);
		}
		
//		create boxes.length objects and store object references of them in the array indexes
		for(int i = 0; i < boxes.length; i++) {
			System.out.println("Enter Dimensions of Box");
			boxes[i] = new Box(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
		}
		
		System.out.println("After init ");
		for(Box b : boxes) {
			System.out.println(b.getBoxDetails());
			System.out.println(b.getBoxVolume());
		}
		
		
		System.out.println("Changing the Width (width * 2) of boxes having volume >  100 using for-each loop");
		
		
		for(Box b: boxes) {
			
			if(b.getBoxVolume() > 100) {
				b.setWidth(b.getWidth() * 2);
			}
		}
		
		System.out.println("After changing Width");
		for(Box b : boxes) {
			System.out.println(b.getBoxDetails());
		}

				
		
		sc.close();
		
		
		
                
	
	}
}