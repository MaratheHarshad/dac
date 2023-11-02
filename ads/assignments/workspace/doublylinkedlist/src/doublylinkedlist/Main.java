package doublylinkedlist;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			DoublyLL ll = new DoublyLL();

			boolean exit = false;

			while (!exit) {

				System.out.println("Enter choice : ");
				System.out.println("1.Show the contents of linkedlist ");
				System.out.println("2.Insert the data in the linkedlist ");
				System.out.println("3.size of linkedlist ");
				System.out.println("4.check is linkedlist empty ");
				System.out.println("5.Show the contents of linkedlist (Reverse) ");

				switch (sc.nextInt()) {
				case 1:

					ll.display();

					break;

				case 2:

					System.out.println("Enter Data : ");
					ll.insertLast(sc.nextInt());

					break;

				case 3:

					System.out.println("Size : " + ll.size());

					break;

				case 4:

					System.out.println("Empty : " + ll.isEmpty());

					break;
				
				case 5:
					
					ll.displayReverse();
					
					break;

				default:
					break;
				}
			}
		}

	}

}
