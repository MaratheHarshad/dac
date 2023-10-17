package p2;

public class Main {

	public static void main(String[] args) {
		

//		String s="Hello";
//		s.toUpperCase();
//		s.concat("12345");
//		System.out.println(s);
//		String s1="testing strings";
//		String s2=new String(s1);
//		System.out.println(s1==s2);
//		System.out.println(s1.equals(s2));
//		String s3="He"+"llo";
//		String s4="He".concat("llo");
//		String s5="hello";
//		String s6="he";
//		String s7="llo";
//		String s8=s6+s7;
//		System.out.println(s==s3);
//		System.out.println(s==s4);
//		System.out.println(s==s5);
//		System.out.println(s5==s8);

		
		String s1="hello";
		String s2="hello";
		String s3=new String(s1);
		String s4=s3.intern();
		String s9=new String(s1.toUpperCase());
                String s10=s9.intern();
		//concat vs + operator
		String s5="he"+"llo";
		String s6="he".concat("llo"); 
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1==s4);
		System.out.println(s1==s5);
		System.out.println(s1==s6);
		System.out.println(s3==s6);

		String s7=new String("Hello");
		String s8=new String("hello");
		String s11="HELLO";
		System.out.println(s10==s11);
		
		

  }
}
