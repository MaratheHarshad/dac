package exceptions;

public class StockOutOfBoundException extends Exception {
	
	public StockOutOfBoundException(String errMsg) {
		super(errMsg);
	}

}
