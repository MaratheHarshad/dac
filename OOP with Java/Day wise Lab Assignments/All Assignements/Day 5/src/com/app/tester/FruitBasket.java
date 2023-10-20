package com.app.tester;

import com.app.fruits.*;
import java.util.Scanner;

public class FruitBasket {

	public static void main(String[] args) {
		// creating scanner class object to wrap the standard input

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Basket size ");

		Fruit[] basket = new Fruit[sc.nextInt()];

		int counter = -1;
		boolean exit = false;

		while (!exit) {

			System.out.println("Enter Choice\n");

			System.out.println("1.Add Mango");
			System.out.println("2.Add Orange");
			System.out.println("3.Add Apple");
			System.out.println("4.Display Name of All Fruits in basket");
			System.out.println("5.Display name,color,weight , taste of all fresh fruits , in the basket");
			System.out.println("6.Mark a fruit in a basket , as stale(=not fresh)");
			System.out.println("7.Mark all sour fruits stale");
			System.out.println("8.Invoke fruit specific functionality (pulp/juice/jam");
			System.out.println("9.Exit");

			System.out.println();
			System.out.println();

			switch (sc.nextInt()) {

			case 1: {

				if (counter < basket.length - 1) {
					System.out.println("Enter color and weigh ");
					basket[++counter] = new Mango(sc.next(), sc.nextDouble());

				} else {
					System.out.println("Insufficient space !!!!");
				}

				break;
			}
			case 2: {

				if (counter < basket.length - 1) {
					System.out.println("Enter color and weigh ");
					basket[++counter] = new Orange(sc.next(), sc.nextDouble());

				} else {
					System.out.println("Insufficient space !!!!");
				}

				break;
			}
			case 3: {

				if (counter < basket.length - 1) {
					System.out.println("Enter color and weigh ");
					basket[++counter] = new Apple(sc.next(), sc.nextDouble());

				} else {
					System.out.println("Insufficient space !!!!");
				}

				break;
			}

			case 4: {

				if (counter >= 0) {
					for (Fruit f : basket) {
						if (f == null) {
							break;
						}

						System.out.println(f.getName());
					}

				} else {
					System.out.println("Basket is empty ");
				}

				break;
			}

			case 5: {

				if (counter >= 0) {
					for (Fruit f : basket) {
						if (f == null) {
							break;
						}

						if(f.isFresh()) {
							System.out.println(f + " " + f.taste());
						}
					}

				} else {
					System.out.println("Basket is empty ");
				}

				break;
			}
			
			case 6:{
//				System.out.println("6.Mark a fruit in a basket , as stale(=not fresh)");
				
				System.out.println("Enter Index ");
				int index = sc.nextInt();
				
				if(index > 0 && index <= counter) {
					
					basket[index].setFresh(false);
					
				}else {
					System.out.println("Invalid index");
				}
				
				break;
			}
			
			case 7:{
//				System.out.println("7.Mark all sour fruits stale");
				
				if (counter >= 0) {
					for (Fruit f : basket) {
						if (f == null) {
							break;
						}

						if(f.getTaste().equals("sour")) {
							f.setFresh(false);
						}
					}

				} else {
					System.out.println("Basket is empty ");
				}
				
				
				break;
			}
			
			case 8:{
//				System.out.println("8.Invoke fruit specific functionality (pulp/juice/jam");
				
				System.out.println("Enter Index ");
				int index = sc.nextInt();
				
				
				
				if(index > 0 && index <= counter) {
					
					Fruit f = basket[index];
					
//					instanceof is a operator
//					it is RTTI
//					it returns true if f is instance of Right-side class
//					otherwise returns false
					
					
					if(f instanceof Apple) {
						((Apple)(f)).jam();
					}else if(f instanceof Mango) {
						((Mango)(f)).pulp();
					}else {
						((Orange)(f)).juice();
					}
					
										
				}else {
					System.out.println("Invalid index");
				}
												
				break;
			}
			
			case 9:
				exit = true;
			
			}
		}

		sc.close();
	}

}
