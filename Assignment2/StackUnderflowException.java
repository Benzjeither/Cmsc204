
@SuppressWarnings("serial")
public class StackUnderflowException extends Exception {

	
	
	public StackUnderflowException() 
	{
		super("push method is called on a full stack");
	};
}
