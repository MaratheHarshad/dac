package com.app.tester;

import java.util.LinkedList;
import java.util.Scanner;

import com.app.core.SinglyLLGeneric;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner sc = new Scanner(System.in)) {
			
			boolean exit = false;
			
			
			
			
			SinglyLLGeneric<Integer> ll = new SinglyLLGeneric<>();

			while (!exit) {

				System.out.println("Enter choice : ");
				System.out.println("1. add first");
				System.out.println("2. add");
				System.out.println("3. add at specific position");
				System.out.println("4. list display");
				System.out.println("5. reverse ll");

				switch (sc.nextInt()) {
				case 1:

					System.out.println("Enter Data : ");
					ll.addFirst(sc.nextInt());

					break;

				case 2:

					System.out.println("Enter Data : ");
					ll.add(sc.nextInt());

					break;

				case 3:

					System.out.println("Enter Data and Index ");
					ll.add(sc.nextInt(), sc.nextInt());
					break;

				case 4:

					ll.list();
					
					break;
					
				case 5:

					ll.reverse();
					
					break;


				default:
					break;
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
