package exceptions;

public class UnauthorizedUserException extends Exception {
	
	public UnauthorizedUserException(String errMsg) {
		super(errMsg);
	}

}