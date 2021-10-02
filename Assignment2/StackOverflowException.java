
@SuppressWarnings("serial")
public class StackOverflowException extends Exception {

	public StackOverflowException() {
		super("Top or pop method is called on an empty stack"); 
		}
}
