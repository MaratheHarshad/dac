package com.app.core;

import com.app.exceptions.CustomStackOverFlowException;
import com.app.exceptions.CustomStackUnderflowException;

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
	public void push(Customer obj) throws CustomStackOverFlowException{
		// TODO Auto-generated method stub
		
		if(this.isFull()) {
//			throw exception stack is full or simply display message
			throw new CustomStackOverFlowException("stack is full");
			
		}
		
		arr[++count] = obj;
		
	}

	@Override
	public Customer pop() throws CustomStackUnderflowException{
		// TODO Auto-generated method stub
		
		if(this.isEmpty()) {
//			throw exception stack is empty or display message
//			return null;
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
