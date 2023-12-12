package com.app.tester;

import java.util.Scanner;

import com.app.core.BinarySearchTree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner sc = new Scanner(System.in)) {
			
			boolean exit = false;
			
			
			
			BinarySearchTree bst = new BinarySearchTree();
			
			while (!exit) {

				System.out.println("Enter choice : ");
				System.out.println("1. add");
				System.out.println("2. inorder");
				System.out.println("3. find");
//				System.out.println("4. list display");
//				System.out.println("5. reverse ll");

				switch (sc.nextInt()) {
				case 1:
					
					System.out.println("Enter data : ");
					bst.add(sc.nextInt());
					
					break;

				case 2:
					
					bst.inorder();
				

					break;

				case 3:
					
					System.out.println("Enter data : ");
					System.out.println(bst.isPresent(sc.nextInt()));
					
					
					break;

				case 4:

					
					
					break;
					
				case 5:

					
					
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
