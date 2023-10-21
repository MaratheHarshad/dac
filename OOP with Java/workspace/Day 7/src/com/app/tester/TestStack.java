package com.app.tester;

import com.app.core.*;
import java.util.Scanner;

public class TestStack {

	public static void main(String[] args) {

		
		try(Scanner sc = new Scanner(System.in);) {
			
			Stack obj = null;
			
			boolean exit = false;
			
			while(!exit) {
				
				System.out.println("1. FixedStack");
				System.out.println("2. GrowableStack");
				System.out.println("3. push");
				System.out.println("4. pop");
				System.out.println("5. Display");
				System.out.print("Enter choice : ");
				
				switch(sc.nextInt()) {
				
					
				case 1:{
					
					if(obj == null) {
						obj = new FixedStack();
					
					}
					break;
				}
				
				case 2: {
					if(obj == null) {
						obj = new GrowableStack();
				
					}
					break;
				}
				
				
				
				case 3:{
					
					if(obj == null) {
						System.out.println("select the stack first");
					}else {
						System.out.println("Enter Customer Details (id, name, address) ");
						obj.push(new Customer(sc.nextInt(), sc.next(), sc.next()));
					}
									
					break;
				}
				
				case 4:{
					
					if(obj == null) {
						System.out.println("select the stack first");
					}else {
						

						if(obj.isEmpty()) {
							System.out.println("Empty !!, Cannot be popped");
						}else {
							
							Customer c = obj.pop();
							
							System.out.println("Customer who is popped");
							System.out.println(c);
						}
						
					}
					
					break;
				}
				
				case 5: {
					
					// Display elements
					
					if(obj == null) {
						System.out.println("Stack is not selected");
					}else {
						obj.display();
					}
					
					break;
				}
				
				case 0: {
					exit = true;
					break;
				}
				

				default:{
					System.out.println("Invalid choice");
				}
				
				
				
				
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
			

	}

}

