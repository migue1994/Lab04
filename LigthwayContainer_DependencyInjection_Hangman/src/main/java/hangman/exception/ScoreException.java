package hangman.exception;


public class ScoreException extends Exception{	
	/**
	 * 
	 */
	
	public static final String INVALID_VALUE="Los valores ingresados no son validos";
	
	public ScoreException(String message) {
		super(message);
	}
	
}