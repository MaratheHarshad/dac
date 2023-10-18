package utils;

import java.util.Comparator;

import com.app.core.Vehicle;

public class VehiclePriceComparator implements Comparator<Vehicle>{


	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		// TODO Auto-generated method stub
		
		if(o1.getBasePrice() + o1.getVehicleClr().getAdditionalCost() == o2.getBasePrice() + o2.getVehicleClr().getAdditionalCost()) {
			return 0;
		}
		
		if(o1.getBasePrice() + o1.getVehicleClr().getAdditionalCost() < o2.getBasePrice() + o2.getVehicleClr().getAdditionalCost())
		{
			return -1;
		}
		
		return 1;
	}

}
