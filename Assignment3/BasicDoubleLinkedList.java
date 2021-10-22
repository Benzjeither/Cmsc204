import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {

	protected int listSize = 0;
	protected Node firstNode, lastNode;
	protected T data;
	protected Node nextNode, previousNode;
	
	public class Node {
		T data;
		Node next;
		Node previous;

		public Node(T data, Node next, Node previous) {
			this.data = data;
			this.next = next;
			this.previous = previous;
		}
		
		Node (T element) {
			this.data = element;
			this.next = null;
			this.previous = null;
		}
	}
	public BasicDoubleLinkedList(T data, Node next, Node previous) {
		this.data = data;
		this.nextNode = next;
		this.previousNode = previous;
	}
	


	public int getListSize() {
		return listSize;
	}



	public void setListSize(int listSize) {
		this.listSize = listSize;
	}



	public T getData() {
		return data;
	}



	public void setData(T data) {
		this.data = data;
	}



	public Node getNext() {
		return nextNode;
	}



	public void setNext(Node next) {
		this.nextNode = next;
	}



	public Node getPrevious() {
		return previousNode;
	}



	public void setPrevious(Node previous) {
		this.previousNode = previous;
	}



	public void setFirst(Node first) {
		this.firstNode = first;
	}



	public void setLast(Node last) {
		this.lastNode = last;
	}



	public BasicDoubleLinkedList() {

	}
	
	/**
	 * @method getSize()
	 * Notice you must not traverse the list to compute the size.
	 *  This method just returns the value of the instance variable you use to keep track of size.
	 * @return the size of the linked list
	 */
	public int getSize() {
		return listSize;
	}
	
	/**
	 * Adds an element to the end of the list. Do not use iterators to implement this method.
	 * @param data - the data for the Node within the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		
		Node node = new Node(data, null, lastNode);
		if (lastNode != null) {
			lastNode.next = node;
		}
		lastNode = node;

		if (firstNode == null) {
			firstNode = node;
		}

		listSize++;
		return this;
	}
	/**
	 * @method Adds element to the front of the list. Do not use iterators to implement this method.
	 * 
	 * @param data - the data for the Node within the linked list
	 * @return reference to the current object
	 */
	
	public BasicDoubleLinkedList<T> addToFront(T data) {
		
		Node newNode = new Node(data,null,null);
		
		if(firstNode ==null) {
			firstNode = newNode;
			lastNode = firstNode;
		}
		else if(lastNode ==null) {
			firstNode = newNode;
			lastNode = firstNode;
		}
		else {
			newNode.next = firstNode;
			firstNode.previous = newNode;
			firstNode = newNode;
		}
		listSize+=1;
		return this;
	}
	
	/**
	 * @method Returns but does not remove the first element from the list.
	 *  If there are no elements the method returns null. Do not implement this method using iterators.
	 * @return the data element or null
	 */
	public T getFirst() {
		
		
		T firstElement;
		
		if(getSize() == 0) {
			return null;
		}
		else {
			firstElement = firstNode.data;
		}

		
		return firstElement;
	}
	
	/**
	 * 
	 * @method Returns but does not remove the last element from the list.
	 * If there are no elements the method returns null. Do not implement this method using iterators.
	 * @return the data element or null
	 */

	public T getLast() {
		
		T lastElement;
		

		
		if(getSize() == 0) {
			return null;
		}
		else {
			lastElement = lastNode.data;
		}

		
		return lastElement;
	}
	
	/**
	 * @method This method is implemented using an inner class that implements ListIterator.
	 * and defines the methods of hasNext(), next(), hasPrevious() and previous(). 
	 * Remember that we should be able to call the hasNext() method as many times as we want without 
	 * changing what is considered the next element.
	 * 
	 * @throws java.util.NoSuchElementException next() method throws NoSuchElementException if there are no more elements 
	 * (at the end of the list and calling next() or at the beginning of the list and calling previous())
	 * @throws java.lang.UnsupportedOperationException does not need to implement the ListIterator's remove(),
	 *  add(), nextIndex() and previousIndex() and set() methods, throw UnsupportedOperationException if called
	 */
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
		
		ListIterator<T> iterator = new Iterator();
		
		return iterator;
	}
	
	
	/**
	 * Removes the first instance of the targetData from the list.
	 * @param targetData the data element to be removed
	 * @param comparator the comparator to determine equality of data elements
	 * @return data element or null
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, java.util.Comparator<T> comparator) {
		
		Node n = null;
		Node currentNode = firstNode;
		
		do {
				
			if (comparator.compare(currentNode.data, targetData) != 0) {
				n = currentNode;
				currentNode = currentNode.next;
				} 
			
				else {
					if (currentNode == firstNode) {
						firstNode = firstNode.next;
						currentNode = firstNode;
					} 
					
					else if(currentNode == firstNode) {
						n.next = currentNode.next;
						currentNode = currentNode.next;
					}
					else if (currentNode == lastNode) {
						currentNode = null;
						lastNode = n;
						n.next = null;
					} 
					else {
						n.next = currentNode.next;
						currentNode = currentNode.next;
					}
					listSize--;
					
				}
			
		} while (currentNode != null);
		
		return this;
	}
	
	/**
	 * @method Removes and returns the first element from the list.
	 * If there are no elements the method returns null. Do not implement this method using iterators.
	 * @return data element or null
	 */
	
	public T retrieveFirstElement() {
		Node n;
		if (listSize != 0) {

			n = firstNode;
			firstNode.next.previous=null;
			firstNode=firstNode.next;
			listSize--;
			return n.data;
		
		}
		else if(getSize() == 0) {
			return null;
		}
		else {
			throw new NoSuchElementException();
		}
	}
	/**
	 * Removes and returns the last element from the list.
	 * @return data element or null
	 */
	public T retrieveLastElement() {
		
		Node current;
		Node previousNode = null;
		T lastElement;
		if (getSize() != 0) {
			current = firstNode;
			do {
				if (current.equals(lastNode)) {
					lastNode = previousNode;
					break;
				}
				previousNode = current;
				current = current.next;
					
			} while(current != null);
			
			listSize--;
			lastElement = current.data;
			return lastElement;
		}

		else {
			throw new NoSuchElementException();
		}

	}
	/**
	 * @method Returns an ArrayList of the items in the list from head of list to tail of list.
	 * @return an ArrayList of the items in the list
	 */
	public ArrayList<T> toArrayList() {
		
		ArrayList<T> itemList = new ArrayList<T>();
		ListIterator<T> iterator =iterator();
		while(iterator.hasNext()) {
			itemList.add(iterator.next());
		}
		
		return itemList;
	}

	private class Iterator implements ListIterator<T> {

		private Node currentNode;
		private Node lastNode;

		public Iterator() {
			currentNode = firstNode;
			lastNode = null;
		}

		public T next()  throws NoSuchElementException {
			if(currentNode != null) {
				T data = currentNode.data;
				lastNode = currentNode;
				currentNode = currentNode.next;
				if(currentNode != null) {
					currentNode.previous = lastNode;
				}
				return data;
				
				
			}
			else {
	
				throw new NoSuchElementException();
			}		
		}

		public boolean hasNext() {
			boolean flag;
			
			if(currentNode != null) {
				flag = true;
			}
			else {
				flag = false;
			}
			return flag;
	
		}

		

		@Override
		public void add(T e)  throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove()  throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		public T previous() throws NoSuchElementException {
			
			if (lastNode == null) {
				throw new NoSuchElementException();
			}
			else {
				currentNode = lastNode;
				lastNode= currentNode.previous;
				T data = currentNode.data;

				return data;	
			}
		}

		public boolean hasPrevious() {
			boolean flag;
			
			if(lastNode != null) {
				flag = true;
			}
			else {
				flag = false;
			}
			return flag;
		}
		
		@Override
		public void set(T data)  throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		@Override
		public int nextIndex()  throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex()  throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

	
	}

}