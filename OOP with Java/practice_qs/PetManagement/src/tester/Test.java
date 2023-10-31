package tester;

import static utils.PetValidations.*;
import static utils.UserValidation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import core.Order;
import core.Pet;
import exceptions.InvalidPetIdException;
import exceptions.StockOutOfBoundException;

public class Test {

	public static void main(String[] args) {

		// functionality to be created
		
		// almost  completed
		
		
//			Pet Store Application Menu: 
//			Login
//			Add new Pet (Admin only functionality)
//			Update Pet details (Admin only functionality)
//			Display all available pets
//			Order a Pet
//			Check order status by Order Id
//			Update order status (Admin only functionality)
//			Exit

		List<Pet> petList = new ArrayList<Pet>();
		List<Order> orders = new ArrayList<>();

		try (Scanner sc = new Scanner(System.in)) {

			boolean exit = false;
			boolean isAdmin = false;
			boolean isUser = false;

			while (!exit) {

				try {

					System.out.println("1. Login");
					System.out.println("2. Add New Pet");
					System.out.println("3. Update Pet details");
					System.out.println("4. Display all");
					System.out.println("5. Order a pet");
					System.out.println("6. Check order status by order id");
					System.out.println("7. Update Order status");
					System.out.println("0. Exit");
					System.out.println();

					switch (sc.nextInt()) {

					case 1:

//					login

						System.out.println("Enter username and password : ");

						String username = sc.next();
						String password = sc.next();

						if (authenticateAdmin(username, password)) {
							isAdmin = true;
							isUser = false;
						} else {
							authenticateUser(username, password);
							isUser = true;
							isAdmin = false;
						}

						sc.nextLine();

						break;

					case 2:

//					Add new Pet (Admin only functionality)

//					would throw an error if logged in person is not admin
						authorizedAdmin(isAdmin, isUser);

						System.out.println("Enter name, category, unitPrice, stocks to add new pet ");

						// after entering choice, and pressing new line (new line is stored in scanner
						// buffered)
						if (sc.hasNextLine()) {
							sc.nextLine();
						}

						String name = sc.nextLine();
						String cat = sc.next();
						double unitPrice = sc.nextDouble();
						int stocks = sc.nextInt();

						Pet newPet = validateInputs(name, cat.toUpperCase(), unitPrice, stocks);

						petList.add(newPet);
						System.out.println("New Pet added " + newPet);

						break;

					case 3:

//						update pet details (Admin only functionality)

//						would throw an error if logged in person is not admin
						authorizedAdmin(isAdmin, isUser);

						System.out.println("Enter Pet Id to update details : ");

						Pet p = findById(sc.nextInt(), petList);

//							update details here, taking from user (using nested switch case block)

						break;

					case 4:

						displayAll(petList);

						break;

					case 5:

						System.out.println("Enter id , quantity to order pet : ");
						Order o = orderPet(sc.nextInt(), sc.nextInt(), petList);
						
						orders.add(o);
						
						System.out.println("order placed ");

						break;
					}
					
					

				} catch (Exception e) {

					e.printStackTrace();
					
					if(sc.hasNextLine()) {
						
						sc.nextLine(); // in case of invalid input written
					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static Order orderPet(int id, int quantity, List<Pet> petList) throws InvalidPetIdException, StockOutOfBoundException {

		return validateOrder(id, quantity, petList);

	}

	private static void displayAll(List<Pet> petList) {

//		using method reference
		petList.forEach(System.out::println);

	}

}
