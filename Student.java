package homework1;
import java.util.*;
import java.io.File;

public class Student<T> {

	//doubly linked list which holds the roster list 
	private static  DoublyLinkedList<String> rosterList= new DoublyLinkedList<String>();
	//doubly linked list which holds the waitlist. 
	private  static DoublyLinkedList<String> waitlist= new DoublyLinkedList<String>();

	//n= number of students input in roster by user
	static int n;

	//student name in the file reader 
	private static String fileLine;
	private static String fileName;

	//size of roster
	static int size=0;
	
	
	String userInput;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		//takes in the input for maximum number of students 
		Scanner intScan = new Scanner(System.in);
		System.out.println("Please input the maximum number of students you would like to have on your roster: ");
		n= intScan.nextInt();


		//reads the user input a so it can add the student to the doubly linked list
		Scanner lineScan= new Scanner(System.in);
		System.out.println("To add onto the roster, press 'a' or to delete from the roster, press 'd':");


		//takes in string from file reader
		File file = new File("Assignment1Data.txt");
		
		try {

			Scanner fileIn = new Scanner(file);
				
				//while the input is a add student to the rosterList 
				while (fileIn.hasNextLine()) {
					
				String line= lineScan.nextLine();
			
				if(line.equals("a")) {
					
						fileLine = fileIn.nextLine();
						addStudent(fileLine);
						System.out.println("This is the roster list: "+ rosterList);
						System.out.println("This is the waitlist: "+ waitlist);
					}
				
				//if the user input is d, then delete the student name 
				if (line.equals("d")) {
					fileLine = fileIn.nextLine();
					deleteStudent(fileLine);
					System.out.println("This is the roster list: "+ rosterList);
					System.out.println("This is the waitlist: "+ waitlist);
				}

			}
				fileIn.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * adds student to the doubly linked list 
	 * @param name variable which holds the names of the students 
	 */
	public static void addStudent (String name) {
		DoublyLinkedListNode<String> currNode= rosterList.getFirstNode();
		//DoublyLinkedListNode<String> newNode= new DoublyLinkedListNode();
		
		Boolean listSorted= false;

		//insert student at the front of the list if the list is empty
		if (rosterList.head==null) {
			rosterList.insertFirst(name);
			size++;

		}
		else {

			//insert student in the middle of list 
			if (rosterList.size()>=1 &&rosterList.size()<n) {
				if(name.compareTo(rosterList.getFirst())<0) {
					rosterList.insertFirst(name);
					size++;
				}
				else if(name.compareTo(rosterList.getLast()) >0) {
					rosterList.insertLast(name);
					size++;
				}
				else {
					while (listSorted==false) {
						if(name.compareTo(currNode.getData()) >0) {
							if(name.compareTo(currNode.getNext().getData())<0){
								
								rosterList.insertAfter(currNode, name);
								size++;
								listSorted=true;
								
							}
							else if (name.compareTo(currNode.getNext().getData())==0) {
								
							}
							currNode= (DoublyLinkedListNode<String>) currNode.getNext();
							
						}
						
					}
				}

			}
			//if the rosterlist > max size, enter name into waitlist 
		 else  {

				if(waitlist.head==null) {
					waitlist.insertFirst(name);
				}
				else {
					waitlist.insertAfter(waitlist.getLastNode(), name);

				}
			}
		}
	}


	/**
	 * delete last student from the list 
	 */
	public static void deleteStudent( String name) {
		DoublyLinkedListNode<String> currNode= rosterList.getFirstNode();
		boolean inRosterList=false;
		boolean inWaitlist=false;

		if (rosterList.getFirstNode()!=null && rosterList.getFirst().equals(name)) {
			rosterList.deleteFirst();
			//System.out.println(name);
		}

		else if (waitlist.getFirstNode()!=null && waitlist.getFirst().equals(name)) {
			waitlist.deleteFirst();
			//System.out.println(name);
		}
//
//		while (!inRosterList) {
//			 if (currNode.getData().equals(name) && currNode==rosterList.getLastNode()) {
//				 rosterList.deleteLast();
//				 System.out.println(name);
//			}
//			 else {
//				 rosterList.deleteAfter(currNode);
//				 
//			 }
//		}
		//		while(rosterList.size() <n) {
		//				while(waitlist.getFirstNode() !=null) {
//			waitlist.deleteFirst();
//			waitlist.getFirstNode();
//			addStudent(waitlist.getFirst());

		//}
//		}
		
	}
	
}







