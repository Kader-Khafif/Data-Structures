/*********************************************************
					Kader Khafif
				TCES 342 Data structures
					Assignemnt 1
				Single LinkedList
					01/22/23
*********************************************************/

package proAssignment2b;

public class SLL<T> {
	
	// Reference variable to the first Node
	protected Node<T> front = null;
	
	// Use a current variable to keep track during list iteration
	protected Node<T> previous, current, rear = null;
	
	// Count to keep track of the number of Nodes (elements)
	protected static int count = 0;
	
	// Node class initialization
	static class Node<T>{
		T element;
		Node<T> next;
		
		// default constructor 
		public Node(T element) {
			this.element = element;
			this.next = null;
		}
		
		// Constructor that takes arguments
		public Node(T element, Node<T> next) {
			this.element = element;
			this.next= next;
		}
	}
	
	// SLL default constructor
	public SLL() {
		front = null;
	}
	
	// Method to check if the list is empty
	public boolean isEmpty() {
		if (front == null) { 
			return true;
		}else return false;		
	}
	
	// Search to return the index of a node that contains a specific Key element;
	// return -1 if not found
	public int search(T key) {
		current = front;
		for(int i = 0; i < count; i++) {
			if(current.element == key) {				
				return i;
			}
			current = current.next;
		}
		return -1;
	}
	// Adding an element at the front of the linkedList
	public void addFront(T element) {
		Node <T> temp = new Node<T>(element, front);
		if (isEmpty()) {
			front = rear = new Node<T>(element);
		}else {			
			temp.next = front;
			front = temp;
		}
		count++;
	}
	
	// Adding an element at the end of the linkedList
	public void addRear(T element){
		 
		if (isEmpty()) {
			addFront(element);
		}else {	
			Node <T> temp = new Node<T>(element);		
			rear.next = temp;
			rear = temp;
			count++;
		}
	}
	
	// Adding an element within the LinkedList
	public void add(int index, T element) {
		current = front;
		if(index > count || index < 0) {
			throw new IllegalArgumentException("Index out of range");
		}else if(index == 0) {
			addFront(element);
		}else if(index == count) {
			addRear(element);
		}else {
			Node <T> temp = new Node <T>(element);			
			for(int i = 0; i < index-1; i++) {
				current = current.next;
			}
			temp.next = current.next;
			current.next = temp;
			count ++;
		}
	}
		
	// deleting the first node
	public T deleteFront() {
		Node <T> node;
		if(isEmpty()) {
			throw new IllegalArgumentException("No deletion: Empty LinkedList");
		}else {
			node = front;
			front = front.next;
		}count--;
		return node.element;
	}
	
	// Removing data at a specific index
	public T delete (int index) {
			current = front;
			Node <T> item = null;
		if(index >= count || index < 0) {
			throw new IllegalArgumentException("Index out of range");
		}else if(index == 0) {
			return deleteFront();
		}else if (index == (count-1)) {
			return deleteRear();
		}
		else {
			for(int i = 1; i <= index; i++) {
				if(i == index) {
					item = current.next;
					previous = current;
					current = current.next;
					previous.next = current.next;
				}
				current = current.next;
			}
		count --;			
		}
		return item.element;
	}
	
	// Remove last node
	public T  deleteRear() {
		previous = null;
		current = front;
		Node <T> last = null;
		if(count == 1) {
			return deleteFront();
			}
			else {
				while (current.next != null) {
					previous = current;
					current= current.next;
				}
				if(current.next == null) {
					last = current;
					previous.next = current.next;
					current = previous;
					rear = previous;
				}
				count --;
			}
		return last.element;
	}

	// Retrieving data at a specific index
	public T get (int index) {
		current = front;
		if(index >= count || index < 0) {
			throw new IllegalArgumentException("Index out of range");
		}
		for(int i = 0; i < index; i++) {
			current = current.next;
		}return current.element;
	}
	
	// Swap method
	public void swap(int index1, int index2) {

		if((index1 >= count || index1 < 0)||(index2 >= count || index2 < 0)) {
			throw new IllegalArgumentException("Indexes must be different and in the range");
		}else if (index1==index2) {
			System.out.println("Same indexes, no swaping needed.");
		}else if (isEmpty()) System.out.println("The list is Empty");
		else if(count == 1) System.out.println("Not enought elements to swap");
		else if(count > 1 ){
			Node <T>temp = new Node<T> (get(index1));
			Node <T>temp2 = new Node<T> (get(index2));
				if(index1 > index2) {
					delete(index2);
					add(index2, temp.element);

					delete(index1);
					add(index1, temp2.element);

				}else {
					delete(index1);				
					add(index1, temp2.element);

					delete(index2);
					add(index2, temp.element);
				}
		}
	}
	
	// Return count value
	public int getcount() {
		return count;
	}
	
	// Return a string containing the contents of the nodes
		public String toString() { // O(n) time
			current = front.next;
			System.out.println("La ");
			String str = "";
			if (front == null) {
				System.out.println("Et la ");
				str = "[]";
			}else {
				str = "[" + front.element;
				while (current != null) {
					str += ", " + current.element;
					current = current.next;
				}
				str += "]";
			}
			current = front;
			return str;
		}
	
	// Print the list method
	public void printList() {
		current = front;
		if (isEmpty() == true) System.out.println("The list is empty");
		System.out.print("[ ");
		while(current != null) {
			
			if(current.next == null) {
				System.out.println(current.element + " ]");
			}else {
				System.out.print(current.element + ", ");
			}
			current = current.next;
		}
	}
}