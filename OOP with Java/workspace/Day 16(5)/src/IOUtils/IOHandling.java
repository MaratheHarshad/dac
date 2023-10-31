package IOUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.app.core.Customer;

public class IOHandling {

	public static void writeData(Map<String, Customer> customers, String fileName) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {

			oos.writeObject(customers);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void writeStringData(Map<String, Customer> customers, String fileName) {
		
		
		try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
			
			customers.values().stream()
			.forEach(c -> {
				try {
					pw.println(c);
				}catch(Exception e) {
					e.printStackTrace();
				}
			});
			
		}catch(Exception e){
			
		}
	}
	
	
//	public static void writeStringData(Map<String, Customer> customers, String fileName) {
//		
//		
//		try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
//			
//			customers.values().stream().sorted((o1, o2) -> o1.getDob().compareTo(o2.getDob()))
//			.forEach(c -> {
//				try {
//					pw.println(c);
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			});
//			
//		}catch(Exception e){
//			
//		}
//	}

	public static Map<String, Customer> readData(String fileName) {

		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {

			return (HashMap<String, Customer>) ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Returning empty hashmap");
			return new HashMap<String, Customer>();
		}
	}

}
