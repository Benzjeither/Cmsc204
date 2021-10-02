
@SuppressWarnings("serial")
public class QueueOverflowException extends Exception {

	public QueueOverflowException() {
		super("Dequeue method is called on an empty queue");
	}
}
