import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList <T> extends BasicDoubleLinkedList <T>{

	Comparator <T> comparable2;
	
	SortedDoubleLinkedList(java.util.Comparator<T> comparable2){
		
		super();
		this.comparable2 = comparable2;
	}
	
	/**
	 * @method Inserts the specified element at the correct position in the sorted list. 
	 * Notice we can insert the same element several times. Your implementation must traverse 
	 * the list only once in order to perform the insertion. Do not implement this method using iterators. 
	 * Notice that you don't need to call any of the super class methods in order to implement this method.
	 * 
	 * @param data - the data to be added to the list
	 * @return  a reference to the current object
	 */
	public SortedDoubleLinkedList<T> add(T data){
		
		Node n = new Node(data);
		Node prev;
		Node NexT;
        
        if (getSize() == 0) {
            firstNode = lastNode = n;
        }
        else if (comparable2.compare(lastNode.data, data) < 0) 
        {
            lastNode.next = n;
            n.previous = lastNode;
            lastNode = n;
         }
        
        else if (comparable2.compare(firstNode.data, data) > 0) 
        {
            firstNode.previous = n;
            n.next = firstNode;
            firstNode = n;
       
        } 
        else
        	
        {
            Node currentNode = firstNode;
            while (currentNode != null) {
                if (comparable2.compare(currentNode.data, data) <= 0) {
                	
                    prev = currentNode;
                    NexT = currentNode.next;
                    NexT.previous = prev.next = n;
                    n.next = NexT;
                    n.previous = prev;   
                }
                currentNode = currentNode.next;
            }
        }
        
        listSize+=1;
        return this;
		}
	
	
	/**
	 * 
	 * @method  This operation is invalid for a sorted list. 
	 * An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException{
	
		throw new UnsupportedOperationException("Invalid operation for sorted list");		
	}
	
	/**
	 * @method This operation is invalid for a sorted list. An UnsupportedOperationException will 
	 * be generated using the message "Invalid operation for sorted list."
	 * 
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException{
		
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * @method Implements the iterator by calling the super class iterator method.
	 */
	public ListIterator<T> iterator(){
		
		return super.iterator();
	}
	
	/**
	 * @method Implements the remove operation by calling the super class remove method.
	 */
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
		 super.remove(data, comparator);
	        return this;
	}
	
	
}