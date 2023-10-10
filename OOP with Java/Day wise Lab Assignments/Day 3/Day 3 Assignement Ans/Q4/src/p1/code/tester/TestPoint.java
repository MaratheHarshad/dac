package p1.code.tester;
import p1.code.core.Point;

public class TestPoint
{
	public static void main(String [] args){

		

		Point obj1 = new Point(15,7);
		Point obj2 = new Point(23,8);
		
		
		System.out.println(obj1.show());
		System.out.println(obj2.show());

		System.out.println(obj1.isEqual(obj2));
		System.out.println(obj1.calculateDistance(obj2));
		
	}
}