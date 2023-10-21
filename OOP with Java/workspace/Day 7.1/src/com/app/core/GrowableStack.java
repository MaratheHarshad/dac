package com.app.core;

import com.app.exceptions.CustomStackUnderflowException;

public class GrowableStack implements Stack{
	
	private int SIZE;
	private Customer [] arr;
	private int count;

	public GrowableStack() {
		// TODO Auto-generated constructor stub
		SIZE = 2;
		arr = new Customer[SIZE];
		count = -1;
	}

	@Override
	public void push(Customer obj) {
		// TODO Auto-generated method stub
		
		if(this.isFull()) {
			
//			create new array of double size , insert all prev into this newly created array
			arr = createNew();
		}
		
		arr[++count] = obj;
		
	}

	private Customer[] createNew() {
		
		Customer [] newArr = new Customer[this.SIZE * 2 + 2];
		
		for(int i = 0; i < this.arr.length; i++) {
			newArr[i] = arr[i];
		}
		
		return newArr;
		
	}

	@Override
	public Customer pop() {
		// TODO Auto-generated method stub
		
		if(this.isEmpty()) {
//			throw exception stack is empty or display message
			throw new CustomStackUnderflowException("Stack is empty");
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

}
