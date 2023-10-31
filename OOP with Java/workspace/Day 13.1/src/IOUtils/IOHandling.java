package IOUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.app.core.Customer;

public class IOHandling {

	public static void writeData(Map<String, Customer> customers, String fileName) {
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			
			oos.writeObject(customers);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static Map<String, Customer> readData() {
		
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("data.ser")))){
			
			
			return (HashMap<String, Customer>)ois.readObject();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Returning empty hashmap");
			return new HashMap<String, Customer>();
		}
	}

}

