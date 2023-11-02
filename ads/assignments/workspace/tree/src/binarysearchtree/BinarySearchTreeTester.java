package binarysearchtree;

import java.util.Scanner;

public class BinarySearchTreeTester {

	public static void main(String[] args) {

		BST bst = new BST();

//		a. Insert the data into the binary search tree
//		b. Show the contents using Inorder traversal
//		c. Show the contents using preorder traversal
//		d. Show the contents using postoder traversal

		try (Scanner sc = new Scanner(System.in)) {

			boolean exit = false;

			while (!exit) {

				System.out.println("Enter Choice : ");
				System.out.println("Insert Data: ");
				System.out.println("Inorder ");
				System.out.println("Preorder ");
				System.out.println("Postorder ");

				switch (sc.nextInt()) {
				case 1:

					// TC O(log n)

					System.out.print("Enter int value : ");
					bst.insert(sc.nextInt());

					break;

				case 2:

//					O(N)
					bst.inorder();
					break;

				case 3:

//					O(N)
					bst.preorder();
					break;

				case 4:

//					O(N)
					bst.postorder();
					break;
					
				default:
					break;
				}
			}
		}

	}

}
