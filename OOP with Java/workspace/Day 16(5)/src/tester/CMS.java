package tester;

import static IOUtils.IOHandling.readData;
import static IOUtils.IOHandling.writeData;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Customer;

import threads.SortAsPerDob;
import threads.SortAsPerEmail;

import static utils.CustomerUtils.*;

public class CMS {

	public static void main(String[] args) {
		
//		writeData(populateCustomers(), "data.ser");
		
		
		

		try (Scanner sc = new Scanner(System.in)) {

			Map<String, Customer> customers = readData("data.ser");
			
			Thread th1 = new Thread(new SortAsPerEmail(customers));
			Thread th2 = new Thread(new SortAsPerDob(customers));

			

			th1.start();
			th2.start();
			
			// join method ensures that , main method wait until th1, th2 complete execution
			th1.join();
			th2.join();
			
			

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

//5. Apply threads to Collections n I/O
//practical usage of threads.
//Create a multi threaded app to solve these objective in a parallel manner
//1. Get a map of products with sample (hard coded) data
//2. Sort the products as per date n save the sorted results (on separate lines) in the text file (u can replace it by bin file using ser. as extra task)
//3. Sort the products as per price n save the sorted results (on separate lines) in the text file (u can replace it by bin file using ser. as extra task)
//4. Ensure no orphans.

// case 2: sorted as per email
// case 3: sorted as per dob
