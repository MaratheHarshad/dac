package com.app.core;

public class FixedStack implements Stack{
	
	private final int SIZE;
	private final Customer [] arr;
	private int count;

	public FixedStack() {
		// TODO Auto-generated constructor stub
		SIZE = 2;
		arr = new Customer[SIZE];
		count = -1;
	}

	@Override
	public void push(Customer obj) {
		// TODO Auto-generated method stub
		
		if(this.isFull()) {
//			throw exception stack is full or simply display message
			System.out.println("Array is full");
			return;
		}
		
		arr[++count] = obj;
		
	}

	@Override
	public Customer pop() {
		// TODO Auto-generated method stub
		
		if(this.isEmpty()) {
//			throw exception stack is empty or display message
			return null;
		}
		
		Customer obj = arr[count];
		arr[count] = null;
		count--;
		
		return obj;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
	
		return count + 1 == SIZE;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return count == -1;
	}

	@Override
	public void display() {
		
		for(Customer cust : arr) {
			if(cust != null) {
				System.out.println(cust);
			}
		}
	}
}	
