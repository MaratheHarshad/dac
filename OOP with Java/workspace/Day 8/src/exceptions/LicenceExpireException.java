package exceptions;

//LicenceExpireException is checked exception because it is inherited from Exception class rather than the RunTimeExceptionClass

//Compiler forces to handle or delegate the checked exception

public class LicenceExpireException extends Exception {
	
	public LicenceExpireException(String errMesg) {
		super(errMesg);
	}
}

