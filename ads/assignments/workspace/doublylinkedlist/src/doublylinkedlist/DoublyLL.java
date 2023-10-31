package doublylinkedlist;

public class DoublyLL {
	
	Node head;
	Node tail;
	
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
		
		 if(head == null) {
			 tail = newNode;
		 }
		
		newNode.next = head;
		head = newNode;
		
	}
	
	public void insertLast(int data) {
		
		if(isEmpty()) {
			addFirst(data);
			return;
		}
		
		Node newNode = new Node(data);
		
		
		newNode.prev = tail;
		tail.next = newNode;
		tail = newNode;
		
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
		Node prev;
		
		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
			this.prev = null;
		}
		
		
		
		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
			
		}
		
	}

}
