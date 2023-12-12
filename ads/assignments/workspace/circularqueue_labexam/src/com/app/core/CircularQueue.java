package com.app.core;

import java.util.ArrayList;

// create a class for string type of circular queue (by default size = 10, if not supplied by user)
public class CircularQueue <T> implements ICircularQueue  <T>{
	
	// class variables
	
	
	int size;
	
	int length;
	
	// queue pointers
	int front;
	int rear;
	
	// queue elements list
	ArrayList<T> queue;
	
	public CircularQueue() {
		this(10);
	}
	
	
	public CircularQueue(int length) {
		this.front = 0;
		this.rear = 0;
		this.size = 0;
		this.length = length;
		queue = new ArrayList<T>(length);
		
	}

	@Override
	public boolean add(T element) {
		
		// verify the list isFull or not
		// if full -> return false
		// else add element to the queue
		
		if(isFull()) {
			return false;
		}
		
		queue.add(element);
//		rear = (rear + 1) % length;
		size++;
	
		
		return true;
	}

	@Override
	public T remove() {
		
		// verify if list isEmpty return null
		// other wise return the string at front
		
		if(isEmpty()) {
			return null;
		}
		
		T element = queue.remove(0);
//		front = (front + 1) % length;
		size--;
		
		return element;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		
		if(isEmpty()) {
			return null;
		}
		
		String list = "";
		
		for(T t : queue) {
			list += t + ", ";
		}
		
//		for(int i = 0; i < size; i++) {
//			
//			if(i == size - 1) {
//				list = list + queue.get(ptr);
//			}else {
//				list = list + queue.get(ptr) + ", ";
//			}
//			
//			
//			ptr = (ptr + 1) % length;
//		}
		
		return list;
		
	}
	
	public boolean isFull() {
		return size == length;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

}
