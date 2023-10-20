package com.app.core;

public class Customer {
	
	private int id;
	private String name;
	private String address;

	public Customer(int id, String name, String address) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
//	Overriding toString to replace the class information with actual content
	@Override
	public String toString() {
		
		return "id : " + id + " name is " + name + " lives in " + address ;

	}

}

