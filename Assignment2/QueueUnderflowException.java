
@SuppressWarnings("serial")
public class QueueUnderflowException extends Exception {

	public QueueUnderflowException() {
		super("Enqueue method is called on a full queue");
	}
}
