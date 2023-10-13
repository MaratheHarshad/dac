package com.app.fruits;

public class Orange extends Fruit {

	public Orange(String color, double weight) {
		// TODO Auto-generated constructor stub
		super(color, weight, "Orange", "sour");
		
	}

	
	@Override
	public String toString(){
		return "Orange is " + super.getColor() + " in color and weight is " + super.getWeight(); 
	}
	
	@Override
	public String taste() {
		return "sour";
	}
	
//	public void juice() {Display name n weight of the fruit + a mesg extracting juice!}
	public void juice() {
		System.out.println("Orange weight is " + super.getWeight() + " extracting juice!!!!");
	}
}
