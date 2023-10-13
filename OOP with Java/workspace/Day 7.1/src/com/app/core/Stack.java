package com.app.core;

public interface Stack {
	
//	public abstract by default
	void push(Customer obj);
	Customer pop();
	boolean isFull();
	boolean isEmpty();
}
