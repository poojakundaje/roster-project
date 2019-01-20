package homework1;

public class DoublyLinkedListNode<T> extends LinkedListNode<T>{

	//reference to previous link
	protected DoublyLinkedListNode<T> prev;
	protected DoublyLinkedListNode<T> next;
	
	/**
	 * Constructor
	 */
	public DoublyLinkedListNode(){
		prev=null;
		next=null;
	}
	
	/**
	 * Set the previous pointer to the passed node.
	 */
	public void setPrev( DoublyLinkedListNode<T> node ){
		this.prev = node;
	}

	/**
	 * Get (pointer to) previous node.
	 */
	public DoublyLinkedListNode<T> getPrev(){
		return this.prev;
	}
	
	/**
	 * Set the next pointer to the passed node.
	 */
	public void setNext( DoublyLinkedListNode<T> node ){
		this.next = node;
	}
	 
	/**
	 * Get (pointer to) next node.
	 */
	@Override
	public DoublyLinkedListNode<T> getNext(){
		return (DoublyLinkedListNode<T>) this.next;
	}





	 
}
