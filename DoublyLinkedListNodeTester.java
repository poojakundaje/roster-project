package homework1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * This class tests DoublyLinkedListNode methods 
 * @author Pooja Kundaje
 *
 */


public class DoublyLinkedListNodeTester {
	
	/**
	 * tests the constructor of the DoublyLinkedListNode. 
	 * prev & next should be set to null 
	 */
	@Test
	public void testConstructor() {
		// Make an empty string List
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertFirst("a");
		assertNull(list.getFirstNode().getNext());
		assertNull(list.getFirstNode().getPrev());
	}
	
	/**
	 * tests whether set prev method works 
	 */
	@Test
	public void testSetPrev() {
		// Make an empty string List
				DoublyLinkedList<String> list = new DoublyLinkedList<String>();
				list.insertFirst("first");			
				list.insertLast("second");
				list.insertLast("third");
				
	list.getLastNode().setPrev(list.getFirstNode());
	list.getFirstNode().setNext(list.getLastNode());
	
	assertEquals("testSetPrev" , "first-> third", list.toString());
	}
	
	/**
	 * tests whether get prev method works 
	 */
	@Test
	public void testGetPrev() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertFirst("first");
		list.insertLast("second");
		list.insertLast("third");
		
		assertEquals("testGetPrev" , "first", list.getFirstNode().getNext().getPrev().toString());
		
		assertEquals("testGetPrev" , "second", list.getLastNode().getPrev().toString());
		
		assertNull(list.getFirstNode().getPrev());
		
	}
	
	/**
	 * tests whether get next method works 
	 */
	@Test
	public void testGetNext() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertFirst("first");
		list.insertLast("second");
		list.insertLast("third");
		
		assertEquals("testGetNext" , "second", list.getFirstNode().getNext().toString());
		
		assertEquals("testGetPrev" , "third", list.getFirstNode().getNext().getNext().toString());
		
		assertNull(list.getLastNode().getNext());
		
	}
	
	/**
	 * checks whether the setnext method works
	 */
	@Test
	public void testSetNext() {
		// Make an empty string List
				DoublyLinkedList<String> list = new DoublyLinkedList<String>();
				list.insertFirst("first");			
				list.insertLast("second");
				list.insertLast("third");
				
	
	list.getFirstNode().setNext(list.getLastNode());
	
	assertEquals("testSetPrev" , "first-> third", list.toString());
	}


}
