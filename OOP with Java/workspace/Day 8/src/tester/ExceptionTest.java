package tester;

import static utils.VehicleValidationRules.*;
import exceptions.*;

import java.text.ParseException;
import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) /* throws SpeedOutOfRangeException */ {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter curnt speed");
			// invoke a static method for speed validation.
			validateSpeed(sc.nextInt());
			System.out.println("end of try...");
			
			System.out.println("Enter licence expiray date ");
			validateLicence(sc.next());
		} // JVM : sc.close()
		catch (SpeedOutOfRangeException e) {
		//	System.out.println(e.getMessage());
			e.printStackTrace();
		}catch (LicenceExpireException  | ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("main cntd....");

	}
}
