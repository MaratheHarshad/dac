package doublylinkedlist;

public class DoublyLL {

	Node head;
	Node tail;

	public int size() {
		int size = 0;

		Node temp = head;

		while (temp != null) {
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

		if (head == null) {
			tail = newNode;
			head = newNode;
			return;
		}

		newNode.next = head;
		head.prev = newNode;
		head = newNode;

	}

	public void insertLast(int data) {

		// if initially list is empty we can directly invoke the addFirst method
		// instead of writing same logic here
		
		if (isEmpty()) {
			addFirst(data);
			return;
		}

		Node newNode = new Node(data);

		newNode.prev = tail;
		tail.next = newNode;
		tail = newNode;

	}

	// internally call the insertLast method
	public void insert(int data) {
		insertLast(data);
	}

	public void display() {

		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}

		System.out.println();

	}

	public void displayReverse() {
		
		// keep the pointer on tail
		Node temp = tail;

		// traverse backward till the null occurs
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.prev;
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
