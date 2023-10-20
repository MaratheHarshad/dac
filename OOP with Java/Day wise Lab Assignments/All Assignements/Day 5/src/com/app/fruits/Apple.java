package com.app.fruits;

public class Apple extends Fruit {

	public Apple(String color, double weight) {
		
		// TODO Auto-generated constructor stub

		super(color, weight, "Apple", "sweet and sour");
		
	}
	
	@Override
	public String toString(){
		return "Apple is " + super.getColor() + " in color and weight is " + super.getWeight(); 
	}
	
	@Override
	public String taste() {
		return "sweet and sour";
	}

//	public void jam() {Display name of the fruit + a mesg  making jam!}
	
	public void jam() {
		System.out.println("Fruit is Apple making jame");
	}
}
