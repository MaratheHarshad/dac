package com.app.tester;

import java.util.Scanner;

import com.app.core.CircularQueue;
import com.app.core.ICircularQueue;

public class Main {

	public static void main(String[] args) {

		ICircularQueue<Integer> queue = new CircularQueue<>(3);

		try (Scanner sc = new Scanner(System.in)) {

			while (true) {

				System.out.println("1. To add");
				System.out.println("2. To remove");
				System.out.println("3. To check size");
				System.out.println("4. To get list");
				System.out.println("5. exit");

				int choice = sc.nextInt();

				switch (choice) {

				case 1: {

					System.out.println("Enter Element : ");
					queue.add(sc.nextInt());
					break;
				}

				case 2: {

					queue.remove();
					break;
				}

				case 3: {

					System.out.println("Size : " + queue.size());
					break;
				}

				case 4: {

					System.out.println(queue);
					break;
				}

				case 5: {
					System.exit(0);
				}

				default: {
					System.out.println("invalid choice");
				}
				}

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
