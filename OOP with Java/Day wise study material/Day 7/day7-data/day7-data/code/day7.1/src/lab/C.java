//
//package lab;
//
//
//public interface A {	
//	double calculate(double d1,double d2);
//}
//public interface B {	
//	int calculate(int d1,int d2);
//}
//
//
//public class C implements A,B {
//	
//	@Override
//	public double calculate(double d1, double d2) {
//		System.out.println("Inside double d1, double d1");
//		return d1 + d2;
//	}
//	
//	@Override
//	public int calculate(int d1,int d2) {
//		System.out.println("Inside int d1, int d1");
//		return d1 + d2;
//	}
//
//	public static void main(String[] args) {
//		
//		C c = new C();
//		
//		System.out.println(c.calculate(5, 6));
//	}
//
//}
