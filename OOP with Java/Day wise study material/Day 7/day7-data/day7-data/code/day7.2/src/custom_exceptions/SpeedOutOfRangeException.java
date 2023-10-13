package custom_exceptions;

// SpeedOutOfRangeException is checked exception because it is inherited from Exception class rather than the RunTimeExceptionClass

// Compiler forces to handle or delegate the checked exception

public class SpeedOutOfRangeException extends Exception {
	public SpeedOutOfRangeException(String errMesg) {
		super(errMesg);
	}
}
