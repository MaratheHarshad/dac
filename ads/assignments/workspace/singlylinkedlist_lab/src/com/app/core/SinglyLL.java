package com.app.core;

// singly ll for int type 
public class SinglyLL {

//	class members

//	head
//	tail

	private Node head;
	private Node tail;

	int size;

	public SinglyLL() {
		head = null;
		tail = null;
		size = 0;
	}

	// add element at tail
	public void add(int data) {

		// create new node
		Node newNode = new Node(data);

		// update tail, head according to the condition

		// if head is null means tail also null, so update both
		if (head == null) {
			addFirst(data);
		} else {
			// add node to the tail
			tail.next = newNode;
			tail = newNode;
			size++;

		}


	}

	// add element at head

	public void addFirst(int data) {

		// create new node
		Node newNode = new Node(data);

		// if head is null means tail also null, so update both
		if (head == null) {
			head = newNode;
			tail = newNode;
		}else {
			
			newNode.next = head;
			head = newNode;
		}
		
		size++;
		
		

	}

	// add element at spcific index

	public void add(int data, int index) throws IndexOutOfBoundsException {

		// if index is not valid throw an exception
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(index + " is out of bound for size " + size);
		}
		
		// if element to be added in the first position
		if(index == 0) {
			addFirst(data);
			
			// if element to be added in the last position
		}else if(index == size) {
			add(data);
		}else {
			
			// add node at specific index
			
			// create new node
			Node newNode = new Node(data);
			
			Node curr = null;
			
			// move the curr pointer till the prev index of spcified index
			while(index != 0) {
				
				curr = curr == null ? head : curr.next;
				index--;
			}
			
			newNode.next = curr.next;
			curr.next = newNode;
			
		}
		
		
	}

	// remove all occurrences of element
	public void remove(int data) {

	}

	// list() — Display all elements.
	public void list() {
		
		Node temp = head;
		
		System.out.print("[");
		while(temp != null) {
			
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.print("]");
		System.out.println();
		

	}

	// reverse() — Reverse the linked list.
	public void reverse() {
		
		// helper function
		if(head != null) {
			tail = head;
			head = reverse(head, null);
		}

	}

	// find(X) – Returns the position of X in the list. Returns -1 if X does not
	// exists in the list.

	
	// logic to reverse the linkedlist
	private Node reverse(Node curr, Node prev) {
		
		if(curr.next == null) {
			
			curr.next = prev;
			
			return curr;
		}
		
		Node h = reverse(curr.next, curr);
		curr.next = prev;
		
		return h;
		
		
	}

	public int find(int data) {

		return 0;
	}

	// isSorted() – Returns true if the list is sorted else false.

	public boolean isSorted() {

		return true;
	}

//	require inner class Node
//	with data members
//	next ptr of same type
//	data

	private class Node {

		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

}
