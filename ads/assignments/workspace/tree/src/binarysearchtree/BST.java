package binarysearchtree;

public class BST {

	Node root;

	public BST() {
		this.root = null;
	}

	public void insert(int val) {

		Node newNode = new Node(val);

		if (root == null) {
			root = newNode;
		} else {
			insert(root, newNode);
		}

	}

	public void insert(Node node, Node newNode) {

		if (node.data < newNode.data) {

			if (node.right == null) {
				node.right = newNode;
			} else {
				insert(node.right, newNode);
			}

		} else {

			// if current node data value is greater or equal to the newNode value
			// insert the newNode to the left of current node

			if (node.left == null) {
				node.left = newNode;
			} else {
				insert(node.left, newNode);
			}

		}
	}

	public void inorder() {
		
		if(root == null) {
			System.out.println("Tree is empty");
		}else {
			inorder(root);
			System.out.println();
		}
	}

	public void inorder(Node node) {

		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + " -> ");
			inorder(node.right);
		}
		
		
	}
	
	
	
	public void preorder() {
		
		if(root == null) {
			System.out.println("Tree is empty");
		}else {
			preorder(root);
			System.out.println();
		}
	}

	public void preorder(Node node) {

		if (node != null) {
			System.out.print(node.data + " -> ");
			preorder(node.left);
			preorder(node.right);
		}
		
		
	}
	
	
	
public void postorder() {
		
		if(root == null) {
			System.out.println("Tree is empty");
		}else {
			postorder(root);
			System.out.println();
		}
	}

	public void postorder(Node node) {

		if (node != null) {
			System.out.print(node.data + " -> ");
			postorder(node.left);
			postorder(node.right);
		}
		
		
	}


	class Node {

		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

}
