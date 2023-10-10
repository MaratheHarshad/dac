
//2. Solve (can be solved in IDE)
//Continue with Day 2' Point2D class.
//
//2.1   Create a driver  class(for UI)  , in the "tester" package "TestPoints" , with main(..)
//
//1. Prompt user , how many points to plot? 
//Create suitable array. (Hint : array of references)
//
//
//
//2. Show following options
//
//Options
//1. Plot a point
//Inputs : array index , x  ,y
//Check boundary conditions  , check if point is already plotted , if not then store the point details
//In case of any errors , display suitable error message.
//
//2.   Display x,y co-ordinates of all the points plotted so far ,using for-each loop.
//
//3.   Accept 2 indices from user .
//Find out if the points at these indices are same or different (Hint : isEqual)
//Print the message accordingly. 
//If points are not same , display distance between these 2 points.
//(Draw mem diagram for your clarity, if needed/)
//
//0. Exit 


package com.cdac.core;

public class Point2D {
	
	private int x;
	private int y;
	
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void display() {
		System.out.println(this.x + " " + this.y);
	}
	
	public boolean isEqual(Point2D other) {
		
		return this.x == other.x && this.y == other.y;
	}
	
	public double calculateDistance(Point2D other) {
		
		
//		formula may be wrong
		
		return Math.sqrt((Math.abs(this.x - other.x)) * (Math.abs(this.x - other.x)) + (Math.abs(this.y - other.y)) * (Math.abs(this.y - other.y)));
	}

}
