import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

class PrintDate {

	static SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");

	public static void main(String [] args) {

		
		
		try(Scanner sc = new Scanner(System.in)){
			
			// parses the string to date (specified format)
			Date date = sdf.parse(sc.next());
			System.out.println(date);
			System.out.println(sdf.format(date));
		}catch(Exception e){

		}
	}
}