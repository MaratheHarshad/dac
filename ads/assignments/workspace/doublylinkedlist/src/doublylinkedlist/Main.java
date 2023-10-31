package doublylinkedlist;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			DoublyLL ll = new DoublyLL();

			boolean exit = false;

			while (!exit) {

				System.out.println("Enter choice : ");
				System.out.println("Show the contents of linkedlist ");
				System.out.println("Insert the data in the linkedlist ");
				System.out.println("size of linkedlist ");
				System.out.println("check is linkedlist empty ");

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

				default:
					break;
				}
			}
		}

	}

}
