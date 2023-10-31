package p1;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A ref = new B();
		
		
		
//		try {
//			ref.show();
//		} catch (IOException e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
		
		System.out.println("inside  method");

	}

}

class A
{
  void show() throws IOException
  {
	  System.out.println("1");
	  throw new IOException();
  }
}

// Overriding form of a method cannot throw new checked exception


class B extends A
{
  @Override
  void show() throws /*Exception ,*/  NullPointerException
  {
	  System.out.println("2");
	  throw new NullPointerException();
  }
}
