package homework1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * this class tests the methods in the doublyLinkedList class 
 * @author poojakundaje
 *
 */
public class DoublyLinkedListTester {
	
	
	/**
	 * tests the constructor of the DoublyLinkedList. 
	 * head and tail should be set to null
	 */
	@Test
	public void testConstructor() {
		// Make an empty string List
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		
		assertNull(list.getFirstNode());
		assertNull(list.getLastNode());
	}
	
	/**
	 * testing getFirstNode method- it should get the first node of the list 
	 */
	@Test
	public void getFirstNodeTest() {
		// Make an empty string List
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		
		//testing method in an empty list 
		assertNull("getFirstNodeTest", list.getFirstNode());
		
		//testing method with one node 
		list.insertFirst("a");
		assertEquals("getFirstNodeTest", "a", list.getFirstNode().getData().toString());

		//testing method with several nodes
		list.insertAfter(list.getFirstNode(), "b");
		list.insertAfter(list.getLastNode(), "c");
		list.insertAfter(list.getLastNode(), "d");
		assertEquals("getFirstNodeTest", "a", list.getFirstNode().getData().toString());
		
		list.deleteFirst();
		assertEquals("getFirstNodeTest", "b", list.getFirstNode().toString());
		
		list.insertFirst("l");
		list.insertFirst("m");
		assertEquals("getFirstNodeTest", "m", list.getFirstNode().toString());
	}

	/**
	 *  testing getFirst method- it should get the data in the first node of the list 
	 */
	@Test
	public void getFirst() {
		// Make an empty string List
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();

		//testing method in an empty list 
		assertNull("getFirstTest", list.getFirst());

		//testing method with one node 
		list.insertFirst("a");
		assertEquals("getFirstTest", "a", list.getFirst().toString());

		//testing method with several nodes
		list.insertAfter(list.getFirstNode(), "b");
		list.insertAfter(list.getLastNode(), "c");
		list.insertAfter(list.getLastNode(), "d");
		assertEquals("getFirstTest", "a", list.getFirst().toString());			

		list.insertFirst("1");
		list.insertFirst("0");
		assertEquals("getFirstTest", "0", list.getFirst().toString());

		list.deleteFirst();
		assertEquals("getFirstTest", "1", list.getFirst().toString());
	}
	
	/**
	 *  testing getLast method- it should get the data from the last node of the list 
	 */
	@Test
	public void getLastTest() {
		// Make an empty string List
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();

		//testing method in an empty list 
				assertNull("getLastTest", list.getLast());

		//testing method with one node 
		list.insertFirst("a");
		assertEquals("getLastTest", "a", list.getLast().toString());
		
				
		//testing method with several nodes
		list.insertAfter(list.getFirstNode(), "b");
		list.insertAfter(list.getLastNode(), "c");
		list.insertAfter(list.getLastNode(), "d");
		assertEquals("getLastTest", "d", list.getLast().toString());			

		list.insertLast("e");
		list.insertLast("f");
		assertEquals("getLastTest", "f", list.getLast().toString());

		list.deleteLast();
		assertEquals("getLastTest", "e", list.getLast().toString());
	}

	/**
	 *  testing getLastNode method- it should get the last node of the list 
	 */
	@Test
	public void getLastNodeTest() {
		// Make an empty string List
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();

		//testing method in an empty list 
		assertNull("getLastNodeTest", list.getLastNode());

		//testing method with one node 
		list.insertFirst("a");
		assertEquals("getLastNodeTest", "a", list.getLastNode().getData().toString());

		//testing method with several nodes
		list.insertAfter(list.getFirstNode(), "b");
		list.insertAfter(list.getLastNode(), "c");
		assertEquals("getLastNodeTest", "c", list.getLastNode().getData().toString());

		list.deleteLast();
		assertEquals("getLastTest", "b", list.getLastNode().getData().toString());
	}

	/**
	 *  testing insertFirst method- it should insert nodes at the front of the list 
	 */
	@Test
	public void insertFirstTest() {
		// Make an empty string List
		LinkedList<String> list = new DoublyLinkedList<String>();

		// test if single entry is successfully added to empty list
		list.insertFirst("a");
		assertEquals("insertFirstTest", "a", list.toString());
		
		//testing if the list becomes empty if the first node is deleted 
		list.deleteFirst();
		assertEquals("insertFirstTest", 0, list.size());
		
		// test if insertFirst works on list with multiple objects
		list.insertFirst("a");
		list.insertFirst("b");
		list.insertLast("c");
		list.insertFirst("d");
		assertEquals("insertFirstTest", "d-> b-> a-> c", list.toString());
	
	}
	
	/**
	 *  testing insertAfter method- it should insert nodes at the middle of the list 
	 */
	@Test
	public void insertAfterTest() {
		// Make an empty string List
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();

		// test if single entry is successfully to a list with only 1 node
		list.insertFirst("a");
		list.insertAfter(list.getFirstNode(), "b");
	
		System.out.println("after" + list.toString());
		assertEquals("insertAfterTest", "a-> b", list.toString());
		

		// test if insertAfter works on list with multiple objects
		list.insertAfter(list.getFirstNode().getNext(),"c");
		list.insertAfter(list.getLastNode(),"d");
		assertEquals("insertAfterTest", "a-> b-> c-> d", list.toString());
		
		list.insertAfter(list.getLastNode(),"e");	
		assertEquals("insertAfterTest", "a-> b-> c-> d-> e", list.toString());
	}





/**
 *  testing insertLast method- it should insert nodes at the end of the list 
 */
	@Test
	public void insertLastTest() {
		// Make an empty string List
		LinkedList<String> list = new DoublyLinkedList<String>();

		// test if single entry is successfully added to empty list
		list.insertLast("a");
		assertEquals("insertLastTest", "a", list.toString());

		//testing if the list becomes empty if the first node is deleted 
		list.deleteFirst();
		assertEquals("insertLastTest", 0, list.size());

		// test if insertFirst works on list with multiple objects
		list.insertLast("b");
		list.insertLast("c");
	list.insertLast("d");
	assertEquals("insertLastTest", "b-> c-> d", list.toString());

}

/**
 *  testing deleteFirst method- it should delete node at the front of the list 
 */
@Test
public void deleteFirstTest() {
	// Make an empty string List
		LinkedList<String> list = new DoublyLinkedList<String>();

		// test if deleting when there is only one element in the list works
		list.insertFirst("a");
		list.deleteFirst();
		assertNull(list.getFirstNode());
		assertEquals("deleteFirstTest", 0, list.size());
			
		//testing if deleting when there are several nodes works 
		list.insertLast("b");
		list.insertLast("c");
		list.insertLast("d");
		list.deleteFirst();
		assertEquals("deleteFirstTest", "c-> d", list.toString());

		//checking if it deletes 2 times in a row 
		list.deleteFirst();
		assertEquals("deleteFirstTest", "d", list.toString());
}

/**
 * testing deleteLast method- it should delete node at the end of the list 
 */
@Test
public void deleteLastTest() {
	// Make an empty string List
		LinkedList<String> list = new DoublyLinkedList<String>();

		// test if deleting when there is only one element in the list works
		list.insertFirst("a");
		list.deleteLast();
		assertEquals("deleteLastTest", 0, list.size());
		
		//testing if deleting when there are several nodes works 
		list.insertLast("b");
		list.insertLast("c");
		list.insertLast("d");
		list.deleteLast();
		assertEquals("deleteLastTest", "b-> c", list.toString());
		
		//checking if it deletes 2 times in a row 
		list.deleteLast();
		assertEquals("deleteLastTest", "b", list.toString());
}



/**
 * testing deleteNext method- it should  delete current node at the middle of the list 
 */
@Test
public void deleteNextTest() {
	// Make an empty string List
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();

		// test if deleting when there is only one element in the list works
				list.insertFirst("a");
				list.deleteAfter(list.getFirstNode());
				assertEquals("deleteAfterTest", 0, list.size());
				
				//testing if deleting when there are several nodes works 
				list.insertFirst("a");
				list.insertLast("b");
				list.insertLast("c");
				list.insertLast("d");
				list.deleteAfter(list.getFirstNode().getNext());
				assertEquals("deleteAfterTest", "a-> c-> d", list.toString());
				
				//checking if it deletes 2 times in a row 
				list.deleteAfter(list.getLastNode());
				assertEquals("deleteLastTest", "a-> c", list.toString());
		
		//checking if it deletes 2 times in a row 
		list.deleteAfter(list.getFirstNode().getNext());
		assertEquals("deleteNextTest", "a", list.toString());
}

/**
 * tests the size method- it should return the size of the list 
 */
@Test
public void testSize() {
	//make an empty string list 
	LinkedList<String> list = new DoublyLinkedList<String>();

	//testing method in an empty list 
	assertEquals("testSize", 0, list.size());
	
	list.insertFirst("a");
	assertEquals("testSize", 1, list.size());
	
	list.insertLast("b");
	list.insertLast("c");
	list.insertLast("d");
	list.insertLast("e");
	assertEquals("testSize", 5, list.size());
	
	list.deleteFirst();
	list.deleteFirst();
	list.deleteFirst();
	assertEquals("testSize", 2, list.size());
	
}

/**
 * tests the toString mrthod- it should print out the string 
 */
@Test
public void testToString() {
	//make an empty string list 
	LinkedList<String> list = new DoublyLinkedList<String>();

	//testing method in an empty list- it should print an empty list 
	assertEquals("testToString", "", list.toString());

	//testing whether the method prints only one node
	list.insertFirst("a");
	assertEquals("testToString", "a", list.toString());

	list.deleteFirst();
	//testing method in an empty list- it should print an empty list 
	assertEquals("testToString", "", list.toString());


	list.insertLast("b");
	list.insertLast("c");
	list.insertLast("d");
	list.insertLast("e");
	assertEquals("testToSting", "b-> c-> d-> e", list.toString());

}
}
