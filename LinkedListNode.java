package homework1;

/**
 * Class represents one node in a generic linked list
 * Node holds objects of type T
 */
public class LinkedListNode<T> {
	
	//the data stored in the Node of type T
	protected T data; 
	
	//reference to next link
	protected LinkedListNode<T> next;
	
	//reference to next link
	protected DoublyLinkedListNode<T> prev;

	/**
	 * Constructor
	 */
	public LinkedListNode(){
		next=null;
	}
	
	/**
	 * Set the data stored at this node.
	 */
	public void setData( T data ){
		this.data = data;
		
	}
	/**
	 * Get the data stored at this node.
	 */
	public T getData(){
		return this.data;
	}
	 
	/**
	 * Set the next pointer to the passed node.
	 */
	public void setNext( LinkedListNode<T> node ){
		this.next = node;
	}
	 
	/**
	 * Get (pointer to) next node.
	 */
	public LinkedListNode<T> getNext(){
		return this.next;
	}
	 
	/**
	 * Return a String representation of this node.
	 */
	public String toString(){
		return getData().toString();
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
	

		
	

}