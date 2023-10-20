/*
4.2
 
  Accept 2 double values from User (using Scanner). Check data type.
. If arguments are not doubles , supply suitable error message & terminate.
  If numbers are double values , print its average.
  
  Hint : Method of Scanner to use : hasNextDouble , nextDouble 
  
*/

import java.util.Scanner;

class FindDoubleAverage {
	
	public static void main(String [] args){
	
		Scanner sc = new Scanner(System.in);
	
		double number1;
		double number2;
		
		
		if(!sc.hasNextDouble()){
		
			System.out.println("Entered Number is not Doubled Number");
			sc.close();
			return;
		}
		
		number1 = sc.nextDouble();
		
		
		if(!sc.hasNextDouble()){
			System.out.println("Entered Number is not Doubled Number");
			sc.close();
			return;
		}
		
		number2 = sc.nextDouble();
		
			
		System.out.println("Average is " + ((number1 + number2) / 2));
		
		sc.close();
	
	}

}
