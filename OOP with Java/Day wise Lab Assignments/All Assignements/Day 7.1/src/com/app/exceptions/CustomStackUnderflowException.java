package com.app.exceptions;

//import java.lang.*;

public class CustomStackUnderflowException extends RuntimeException {
	
	public CustomStackUnderflowException(String errMsg) {
		super(errMsg);
	}

}
