package com.app.core;

//Write a Circular Queue using array in Java which implements the following interface:  
public interface ICircularQueue <T>{
	
	// Add the given element at the REAR of the queue
	// Returns false if queue is full otherwise true is returned
	boolean add(T element);
	
	// Remove element from the FRONT of the queue
	// Returns null if the queue is empty
	T remove();
	
	// Returns the total number of elements stored in the queue
	// Returns 0 if the queue is empty
	int size();
	
	// Returns comma separated elements from FRONT to REAR
     // Returns empty string if queue is empty
	String toString();

}

