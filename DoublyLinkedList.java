package homework1;

import java.util.*;

public class DoublyLinkedList<T> extends LinkedList<T>{

	//reference to the last node in the list 
	protected DoublyLinkedListNode<T> head;

	//reference to the last node in the list 
	protected DoublyLinkedListNode<T> trailer;


	/**
	 * Constructor
	 * Create an empty list
	 */
	public DoublyLinkedList(){

		head = null;
		trailer=null;
	}


	/**
	 * Get the head node of the list. 
	 * @return node
	 */
	@Override
	public DoublyLinkedListNode<T> getFirstNode(){

		//if list is not empty
		if(head!=null) {
			return head; 
		}
		else {
			return null;
		}
	}
	
	/**
	 * 
	 */
	@Override
	public T getFirst() {
		if(head!=null) {
		return getFirstNode().getData();
		} 
		else {
			return null;
		}
	}

	/**
	 * Get data stored in last node of list.
	 * @return data of type T 
	 */
	@Override
	public T getLast(){

		DoublyLinkedListNode<T> currentNode = head;
		//if list is not empty 
		if(trailer!=null)
			return trailer.getData(); 
		else
			return null;
	}

	/**
	 * Get the tail node of the list.
	 */
	@Override
	public DoublyLinkedListNode<T> getLastNode(){

		if(trailer!=null) {
			return trailer; 
		}
		else {
			return null;	
		}
	}

	/**
	 * creates a new node and inserts it at the front of the list 
	 * @param data holds the data in the new node
	 */
	@Override
	public void insertFirst (T data){
		//create a node
		DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>();
		newNode.setData(data);

		if (head==null) {
			//if the list is empty make new node the head
			newNode.setNext(null);
			head= newNode;
			trailer=newNode;
		}
		else {
			//set new node at the front of the list and then make the 
			//new node the head.
			head.setPrev(newNode);
			newNode.setNext(head);
			head=newNode;
			
		}
	}


	/**
	 * Insert a new node with data after currentNode
	 * @param current node is the node after which the new node is inserted
	 */
	public void insertAfter(DoublyLinkedListNode<T> currentNode, T data){
		//node that is inserted into the doublyLinkedList
		DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>();
		newNode.setData(data);

		if (currentNode!=null) {
			//System.out.println("not null");
			 if(currentNode.getNext()==null) {
				 //System.out.println("next is null");
				currentNode.setNext(newNode);
				newNode.setPrev(currentNode);
				newNode.setNext(null);
				//System.out.println("next node" + currentNode.getNext().data);
				trailer=newNode;
			}
			else {
				newNode.setNext(currentNode.getNext());
				currentNode.getNext().setPrev(newNode);		 
				currentNode.setNext(newNode);
				newNode.setPrev(currentNode);
				trailer=newNode;
			}
		}

		
	
	}


	
	/**
	 * creates a new node and inserts it at the end of the linked list 
	 * @param data holds the data of the new node
	 */
	@Override
	public void insertLast(T data) {

		//create a new node
		DoublyLinkedListNode<T> newNode= new DoublyLinkedListNode<T>();
		newNode.setData(data);

		if(head==null || trailer==null) {
			//if there is only one node in the list, set the newNode next to 
			//head node and set it as trailer
			head=newNode;
			newNode.setNext(null);
			trailer=newNode;
		}

		else {
			newNode.setPrev(trailer);
			trailer.setNext(newNode);
			newNode.setNext(null);
			trailer=newNode;
		}
		
	}


	/**
	 * deletes a node from the front of the list 
	 * @param nextNode is the node following the node to be deleted
	 */
	@Override
	public void deleteFirst(){
		if (head==null) {
			;
		}
		else if (head.getNext()==null) {
			head=null;
		
		}
		else{

			//move head pointer to the node after the first node	
			head = (DoublyLinkedListNode<T>) head.getNext();
			head.setPrev(null);

		}
		 
		 
	}


	/**
	 * deletes an element from the middle of the list 
	 * @param currentNode- the node to be deleted  
	 */
	public void deleteAfter(DoublyLinkedListNode<T> currentNode){
		
		//If list is empty or currentNode is the tail
		if(currentNode.getPrev()==null && currentNode.getNext()==null) {
			head=null;
			trailer=null;
		}
		else if (currentNode.getNext()==null) {
			currentNode.getPrev().setNext(null);
			trailer=currentNode.getPrev();
		}
		else if (currentNode.getPrev()==null) {
			currentNode.getNext().setPrev(null);
			head=(DoublyLinkedListNode<T>) currentNode.getNext();
		}
		else {
		
			DoublyLinkedListNode<T> temp= (DoublyLinkedListNode<T>) currentNode.getNext();
			
			currentNode.getPrev().setNext(temp);
			temp.setPrev(currentNode.getPrev());
			currentNode=null;
		}
		
	}


	/**
	 * deletes the last element of the list 
	 * @param currentNode- node previous to the node to be deleted
	 */
	@Override
	public void deleteLast() {
		DoublyLinkedListNode<T> prevNode= new DoublyLinkedListNode<T>();
		if (head.getNext()==null) {
			
			//if there is only one element in the list (head)
			//and no trailer, delete the head 
			head = null;
			
		}	
		else if (head==null) {
			;
		}
		else {
			if (trailer!=null) {
				prevNode = trailer.getPrev();
				//when more than 2 elements in the node exist, set the
				//trailer to null
				trailer = null;
				
				prevNode.setNext(null);
				trailer = prevNode;
				if (trailer.getPrev()==null) {
					trailer=null;
				}
			}
			
		}
	}


	/**
	 * Return a String representation of the list.
	 * 
	 */
	@Override
	public String toString(){

		DoublyLinkedListNode<T> currentNode = head;
		String printableList = "";
		if(head==null) {
			return printableList;
		}
		else if (head!=null){

			//store growing String of the list in a variable while looping though the list
			while(currentNode.getNext()!= null){
				printableList += currentNode.toString() + "-> ";
				currentNode = (DoublyLinkedListNode<T>) currentNode.getNext();
			}
			//add last node to the String
			printableList+=currentNode.toString();
			
		}
		return printableList;
		
	}	
	

	/**
	 * Return the number of nodes in this list.
	 */
	public int size(){
		int count = 0;
		//loop through the list and increment number of nodes
		DoublyLinkedListNode<T> currentNode = head;
		if(currentNode!=null) {
			while(currentNode!= null){
				count ++;
				currentNode = (DoublyLinkedListNode<T>) currentNode.getNext();
			}
			return count;
		}
		else {
			return 0;
		}
		
	}


}
