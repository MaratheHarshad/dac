package p1.code.core;

public class Point {

	private int x;
	private int y;

	public Point(int x, int y){
		this.x = x;
		this.y = y;
		
	}
	
	public String show(){
		
		return "Co-ordinates are : x -> " + this.x + ", y -> " + this.y;
		

		
	}


	public boolean isEqual(Point other){
		
		return this.x == other.x && this.y == other.y ? true : false;
	}

	public double calculateDistance(Point other){
		
		return Math.sqrt((Math.abs(this.x - other.x) * Math.abs(this.x - other.x)) + (Math.abs(this.y - other.y) * Math.abs(this.y - other.y)));

	}

}