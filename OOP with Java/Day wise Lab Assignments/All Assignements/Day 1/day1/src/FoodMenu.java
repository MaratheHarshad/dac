/*
4) Display food menu to user. User will select items from menu along with the quantity. (eg 1. Dosa 2. Samosa 3. Idli ... 10 . Generate Bill ) Assign fixed prices to food items(hard code the prices)
When user enters 'Generate Bill' option(10) , display total bill & exit.
*/

import java.util.Scanner;

class FoodMenu {

	public static void main(String [] args){
	
		// creating instance of scanner class to wrap the input from -> stdin (System.in)                		
		Scanner sc = new Scanner(System.in);
	
		// Declaring prices of food items
		int DOSA = 30;
		int SAMOSA = 15;
		int IDLI = 20;
		
		
		int totalBill = 0;
		
		int choice = 0;
		
		System.out.println("Welcome To Sneh Services");
		
		
		while(true){
		
			
			
			System.out.println("Select Food item");
			System.out.println("1. Dosa");
			System.out.println("2. Samosa");
			System.out.println("3. Idli");
			System.out.println("4. Total Bill");
			
			choice = sc.nextInt();
			
			
			if (choice == 4){
				break;
			}
			
			System.out.print("Enter Quantity : ");
			int quantity = sc.nextInt();
			
			
			switch(choice){
				
				// for dosa
				case 1:{
					
			
					totalBill = totalBill + (DOSA * quantity);
						
					break;
				}
				
				case 2:{
					
					totalBill = totalBill + (SAMOSA * quantity);
						
					break;
				}
				
				case 3:{
					
					totalBill = totalBill + (IDLI * quantity);
				
					break;
				}
				
				default: {
					System.out.println("Invalid Choice");
				}
				
			}
		
		}
		
		
		System.out.println("Total Bill : " + totalBill );
		
		
		sc.close();
		
		
	
	
	}


}




