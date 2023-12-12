package com.app.core;

public class BinarySearchTree {

	// internal class Node (TreeNode)

	// root node
	TreeNode root;

	public BinarySearchTree() {
		this.root = root;
	}

	// class functionality

	// traversals
	
	public void inorder() {
		
		System.out.print("[");
		inorder(root);
		System.out.println("]");
	}

	public void inorder(TreeNode root) {
		
		if(root == null) {
			return;
		}
		
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public void preorder(TreeNode root) {

	}

	public void postorder(TreeNode root) {

	}
	
	public void add(int data) {
		
		TreeNode newNode = new TreeNode(data);
		
		// if root is null
		if(root == null) {
			root = newNode;
			
		}else {
			// otherwise insert the newNode at appropriate position
			
			insert(root, newNode);
			
			
		}
	}
	
	public void insert(TreeNode node, TreeNode newNode) {
		
		if(node.data < newNode.data) {
			
			if(node.right == null) {
				
				node.right = newNode;
				return;
			}else {
				insert(node.right, newNode);
			}
		}else {
			
			if(node.left == null) {
				
				node.left = newNode;
				return;
			}else {
				insert(node.left, newNode);
			}
		}
	}
	
	// add a method to verify element is present or not
	// abstraction method for user
	public boolean isPresent(int data) {
		
		return root == null ? false : isPresent(root, data);
	}
	
	// helper method
	public boolean isPresent(TreeNode node, int data) {
		
		if(node.data == data) {
			return true;
		}
		
		if(node.data < data) {
			return isPresent(node.right, data);
		}else {
			return isPresent(node.left, data);
		}
	}
	
	

	private class TreeNode {

		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {

			this.data = data;

		}

	}
}
