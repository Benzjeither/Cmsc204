import java.util.ArrayList;
import java.util.Stack;

@SuppressWarnings("rawtypes")
public class NotationStack <T> implements StackInterface {

	private int size;
	Stack<T> stack = new Stack<T>();

	public NotationStack(int size) {
		this.size = size;
	}
	
	public NotationStack() {
		
	}

	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		
		boolean flag = false;
		if(stack.isEmpty()) {
			flag = true;
		}
		
		return flag;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		
		boolean flag = false;
		
		if(this.size == stack.size()) {
			flag = true;
		}
		
		return flag;
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T pop() throws StackUnderflowException {
		

		if(!isEmpty()) {
			return stack.remove(stack.size() - 1);
		}
		else{ 
			throw new StackUnderflowException();
		}
		
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T top() throws StackUnderflowException {
		
		T topElement;
		if(this.size == stack.size()) {
			throw new StackUnderflowException();
		}
		else { 
			topElement = stack.peek();
		}
		
		return topElement;
	}
	
	
	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {

		return stack.size();
	}


	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean push(Object e) throws StackOverflowException {
		
		if (!isFull()) {
            return stack.add((T) e);
        } else {
            throw new StackOverflowException();
        }
	}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		
		String str = "";
		
		for(T x: stack) {
			str = str + x.toString();
		}
		return str;
	}

	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		
		String str = "";
			
		for(T x: stack) {
			str = str + x.toString();
			str = str + delimiter;
		}
		
		str = str.substring(0,str.length()-1);
		return str;
	}

	
	/**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  */
	@SuppressWarnings("unchecked")
	@Override
	public void fill(ArrayList list) {
		
		for(Object x: list) {
			stack.add((T) x);
		}
		 
		
	}

}
