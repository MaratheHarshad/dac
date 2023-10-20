package utils;

import exceptions.SpeedOutOfRangeException;
import exceptions.LicenceExpireException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VehicleValidationRules {
	// declare static constants : speed range
	public static final int MIN_SPEED;
	public static final int MAX_SPEED;
	private static SimpleDateFormat sdf;
	static {
		MIN_SPEED=40;
		MAX_SPEED=80;
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}

//add a static method for speed validation
	public static void validateSpeed(int speed) throws SpeedOutOfRangeException{
		if(speed < MIN_SPEED)
			throw new SpeedOutOfRangeException("Speed too slow");
		if(speed > MAX_SPEED)
			throw new SpeedOutOfRangeException("Speed too fast , FATAL!!!!!!");
		System.out.println("speed within range....");
	}
	
	public static void validateLicence(String s) throws IllegalArgumentException, NullPointerException, LicenceExpireException, ParseException {
		
		
		
		Date d = sdf.parse(s);
		
		if (d.after(new Date())) {
			throw new LicenceExpireException("Licence is Expired !! Renew the Licence");
		}
		
		
		
	}
}
