import java.util.ArrayList;




@SuppressWarnings("rawtypes")
public class NotationQueue <T> implements QueueInterface{

	private int size;
	ArrayList<T> queue;

	public NotationQueue(int size) {
		queue = new ArrayList<T>();
		this.size = size;
	}
	
	public NotationQueue() {
	
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		boolean flag = false;
		
		if(queue.isEmpty()) {
			flag = true;
		}
		
		return flag;
	}

	/**
	 * Determines of the Queue is empty
	 * @return
	 */
	@Override
	public boolean isFull() {
		boolean flag = false;
		
		if(this.size == queue.size()) {
			flag = true;
		}
		
		return flag;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if(!isEmpty()) {
			
			return queue.remove(0);
		}
		else{ 
			throw new QueueUnderflowException();
		}
	}

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
	
		
		return queue.size();
	}

	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean enqueue(Object e) throws QueueOverflowException {
		if (queue.size() == size) {
			throw new QueueOverflowException();
		}

		queue.add((T) e);
		return true;
	}
	
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		
		String str = "";
		
		for(T x: queue) {
			str = str + x.toString();
		}
		return str;
	}

	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String str = "";
		
		for(T x: queue) {
			str += x.toString() + delimiter;

		}
		str = str.substring(0,str.length()-1);
		return str;
	}

	
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  */
	@SuppressWarnings("unchecked")
	@Override
	public void fill(ArrayList list) {
		for(Object x: list) {
			queue.add((T) x);
		}
		
	}



}
