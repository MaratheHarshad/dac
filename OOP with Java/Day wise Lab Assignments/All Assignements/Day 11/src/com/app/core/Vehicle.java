package com.app.core;

import java.time.LocalDate;

/*
 * state : chasisNo(string) : Unique ID, color(enum) , 
 * basePrice(int) , manufactureDate(LocalDate),company,isAvailable
 */
public class Vehicle implements Comparable<Vehicle>{
	private String chasisNo;
	private Color vehicleClr;
	private int basePrice;
	private LocalDate manufactureDate;
	private String company;
	private boolean available;

	public Vehicle(String chasisNo, Color vehicleClr, int basePrice, LocalDate manufactureDate, String company) {
		super();
		this.chasisNo = chasisNo;
		this.vehicleClr = vehicleClr;
		this.basePrice = basePrice;
		this.manufactureDate = manufactureDate;
		this.company = company;
		this.available = true;
	}

	// overloaded ctor to wrap PK (UID)
	public Vehicle(String chasisNo) {
		super();
		this.chasisNo = chasisNo;
	}

	// toString
	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", vehicleClr=" + vehicleClr + ", netPrice="
				+ (basePrice + vehicleClr.getAdditionalCost()) + ", manufactureDate=" + manufactureDate + ", company="
				+ company + ", available=" + available + "]";
	}

	// override equals to replace ref equality by contents equality : UID : chasisNo
	@Override
	public boolean equals(Object o) {
		System.out.println("in vehicle's eq");
		if (o instanceof Vehicle) {
			Vehicle anotherVehicle = (Vehicle) o;
			return this.chasisNo.equals(anotherVehicle.chasisNo);
		}
		return false;

	}
	//adding s/g for price

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
	
	

	public Color getVehicleClr() {
		return vehicleClr;
	}

	public void setVehicleClr(Color vehicleClr) {
		this.vehicleClr = vehicleClr;
	}

	@Override
	public int compareTo(Vehicle o) {
		
		return this.chasisNo.compareTo(o.chasisNo);
		
	}

	

}
