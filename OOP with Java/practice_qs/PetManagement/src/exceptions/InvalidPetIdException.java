package exceptions;

public class InvalidPetIdException extends Exception {
	
	public InvalidPetIdException(String errMsg) {
		super(errMsg);
	}

}
