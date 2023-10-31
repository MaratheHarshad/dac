package singlylinkedlist;

public class SinglyLL {
	
	Node head;
	
	public int size() {
		int size = 0;
		
		Node temp = head;
		
		while(temp != null) {
			size++;
			temp = temp.next;
		}
		
		return size;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addFirst(int data) {
		
		Node newNode = new Node(data);
		
		newNode.next = head;
		head = newNode;
		
	}
	
	public void insertLast(int data) {
		
		if(isEmpty()) {
			addFirst(data);
			return;
		}
		
		Node newNode = new Node(data);
		
		Node temp = head;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = newNode;
		
		
	}
	
	public void display() {
		
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		
		System.out.println();
		
		
	}
	
	
	
	
	class Node {
		
		int data;
		Node next;
		
		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}
		
		
		
		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
		
	}

}
