package com.app.fruits;

public class Mango extends Fruit {

	public Mango(String color, double weight) {
		// TODO Auto-generated constructor stub
		super(color, weight, "Mango", "sweet");
		
	}
	
	@Override
	public String toString(){
		return "Mango is " + super.getColor() + " in color and weight is " + super.getWeight(); 
	}

	@Override
	public String taste() {
		return "sweet";
	}
	
//	sub class specific functionality
	
	public void pulp() {
//		{Display name n color of the fruit + a msg creating  pulp!}
		System.out.println("Mango is " + super.getColor() + " in color , creating pulp !!!!");
	}
}
