package custom_exception;

public class PenStyleException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PenStyleException(String errMsg)
	{
		super(errMsg);
	}
}
