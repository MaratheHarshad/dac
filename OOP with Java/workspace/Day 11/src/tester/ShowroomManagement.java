package tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.app.core.Color;
import com.app.core.Vehicle;

import custom_exceptions.VehicleHandlingException;
import utils.ShowroomUtils;
import utils.VehiclePriceComparator;
import utils.VehicleValidationRules;
import static utils.VehicleValidationRules.*;
import static utils.ShowroomUtils.*;

public class ShowroomManagement {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// init phase
			// create suitable D.S : AL (empty)
//			List<Vehicle> vehicleList = new ArrayList<>();// up casting , size=0, initCapa=10
//			populate vehicle list from populateShowroom method
			List<Vehicle> vehicleList = populateShowroom();

			boolean exit = false;
			while (!exit) {
				// servicing phase : UI
				System.out.println("Options : 1 . Add a vehicle 2.Display All \n" + "3. Get Specific Vehicle details \n"
						+ "4. Apply discount \n 5. Removed vehicle\n");
				System.out.println("6. Remove vehicles by color\n");
				System.out.println("7. Sort vehicles\n");
				System.out.println("8. Sort vehicles by net price\n");
				System.out.println("Choose an option");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter vehicle details :  chasisNo,  vehicleClr,  basePrice,  manufactureDate, company");
						// Tester invokes all validation rules
						Vehicle validatedVehicle = validateAllInputs(sc.next(), sc.next(), sc.nextInt(), sc.next(),
								sc.next(), vehicleList);
						// successful validations
						vehicleList.add(validatedVehicle);
						System.out.println("added vehicle to the showroom");
						break;
					case 2: // display all
						System.out.println("Showroom details");
						// via for-each
						for (Vehicle v : vehicleList)
							System.out.println(v);// toString : Vehicle (with clr based net price)
						break;
					case 3:
						System.out.println("Enter ch no , to get vehicle details");
						// Tester invokes : Showroom Utils method
						Vehicle vehicle = findByChasisNo(sc.next(), vehicleList);
						// => found
						System.out.println(vehicle);
						break;
					case 4:
						System.out.println("Enter ch no n discount");
						vehicle = findByChasisNo(sc.next(), vehicleList);
						// => found , set price
						vehicle.setBasePrice(vehicle.getBasePrice() - sc.nextInt());
						System.out.println("discount applied....");
						break;

					case 5:

						// 6. Objective :
						// Remove specific vehicle details
						// i/p : chasis no
						// o/p : valid ch no : del details o.w throw custom exc

						System.out.println("Enter the ch no to remove vehicle");

						boolean removed = vehicleList.remove(new Vehicle(sc.next()));

						if (!removed) {

							throw new VehicleHandlingException("Vehicle with this ch no does not exist");
						}

						System.out.println("Success fully removed");

						break;

					case 6:

//							7. Objective :
//							Remove all vehicle details by a specific color
//							i/p : color

						System.out.println("Enter color to remove vehicle ");
						Color color = parseAndValidateColor(sc.next());

//						for(Vehicle v : vehicleList) {

//							System.out.println(color == v.getVehicleClr());
//							System.out.println(color.equals(v.getVehicleClr()));

//							both ==, and equals return same results as there are enum supports only 1 object per self reference type

//							throws ConcurrentModificationException
//							if(color.equals(v.getVehicleClr())) {
//								vehicleList.remove(v);
//							}
//					}

						// i.e where iterator comes into the picture

						Iterator<Vehicle> vehicleItr = vehicleList.iterator();

//							vehicleList.set(0,new Vehicle("abc-111", Color.SILVER, 10000, LocalDate.now(),"BMW"));
//							unstructured manipulation i.e not error (no shuffling of indices)

//							vehicleList.remove(0);
//							structured manipulation, throws ConcurrentModificationException

						while (vehicleItr.hasNext()) {

							if (vehicleItr.next().getVehicleClr().equals(color)) {
								vehicleItr.remove();
							}
						}

						System.out.println("Removed successfully ");

						break;

					case 7:

					//8. Objective :
					//Sort the vehicles as per asc ch no(using natural ordering)
						
//						Collections is a utility class for collections
//						sort takes Comparable<T> argument 
//						and internally calls the compareTo according to sorting criteria
//						to sort the collection using natural ordering
						Collections.sort(vehicleList);
						
						break;
						
					case 8:
						
//						9. Objective :
//							Sort the vehicles as per price no(using custom ordering)
						
						
						
//						Collections is a utility class for collections
//						sort takes List<T>, Comparator<T> ref argument 
//						and internally calls the compare according to sorting criteria
//						to sort the collection using customer ordering
						Collections.sort(vehicleList, new VehiclePriceComparator() );


						break;

					case 0: // shut down (destroy phase)
						exit = true;
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("Pls retry....");
					// to read off all pending i/ps
					sc.nextLine();
				}
			}

		} // sc.close()
		System.out.println("main over....");

	}

}
