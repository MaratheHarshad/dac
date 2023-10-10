package com.cdac.tester;

import java.util.Scanner;

import com.cdac.core.Point2D;

public class TestPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		creating scanner class object to wrap stdin
		
		Scanner sc = new Scanner(System.in);
		

		//1. Prompt user , how many points to plot? 
		//Create suitable array. (Hint : array of references)
		
		
		System.out.println("Enter Number of Points to draw ");
		
		int counter = -1;
		Point2D [] points = new Point2D[sc.nextInt()];
		
		
		boolean flag = false;
		while(!flag) {
			
			System.out.println("1. Plot a point \n2.Display Co-ordinates of all indices \n3.Compare 2 Points\n0. Exit");
			
			switch (sc.nextInt()) {
			case 1:
//				validate whether space exists
//				take a point co-ordinates
//				check if point already exists
//				if yes -> sop (point already exist)
//				else
//				Plot a point
				
//				points length = 2
//				
//				-1, 0 , 1
				
				if(counter < points.length - 1) {
					
					System.out.println("Enter co-ordinates");
					int x = sc.nextInt();
					int y = sc.nextInt();
					
					boolean isExist = false;
					
					Point2D newPoint = new Point2D(x, y);
					
					for(Point2D p : points) {
						
						if(p != null) {
							if(p.isEqual(newPoint)) {
								isExist = true;
								break;
							}
						}else {
							break;
						}
						
					}
					
					if(isExist) {
						System.out.println("point already exist");
					}else {
						points[++counter] = newPoint;
					}
				}else {
					System.out.println("insufficient space");
				}
				
				
				
				
				break;
				
			case 2:
				
				for(Point2D pt : points) {
					
					if(pt == null) {
						break;
					}
					
					pt.display();
				}
				
				break;
				
			case 3:
				
				System.out.println("Enter point id's of 2 points to compare ");
				int first = sc.nextInt();
				int second = sc.nextInt();
				
				if(first >= 0 && first <= counter && second >= 0 && second <= counter) {
					
					if(points[first].isEqual(points[second])) {
						System.out.println("Both Points are same");
					}else {
						System.out.println("Distance between points is : " + points[first].calculateDistance(points[second]));
					}
					
				}
				else {
					
					System.out.println("one of the Point id does not exist");
				}
				
				break;
				
			case 0:
				System.exit(0);

			default:
				
				System.out.println("invalid choice");
				break;
			}
			
		}
		sc.close();

	}

}

//points[0] = {10,20}
//points[1] = {}
//obj = {10,20}


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