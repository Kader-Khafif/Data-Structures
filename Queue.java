/*********************************************************
					Kader Khafif
				TCES 342 Data structures
					Assignemnt 1b
			implementation of a LinkedList Queue
					02/05/23
*********************************************************/


package proAssignment2b;

public class Queue<T> extends SLL<T>{
	// Reference variable to the first Node
		private Node<T> front, rear = null;
		
		// Use the 'current' variable to keep track during list iteration
		private Node<T> current = null;

		public T element;
		Node<T> next;
		
	// Create a method to check if the Queue is empty
	public boolean isQEmpty() {
		return super.isEmpty();
	}
	// Create a method that adds an element to the end of the Queue
	public void enqueue(T element) {

		if (super.isEmpty()) {
			super.addFront(element);;
		}else {
			super.addRear(element);
		}
	}
	
	// Create a method that deletes and returns the element at the front of the queue
	public T dequeue() {

		if (super.isEmpty()) {
			throw new IllegalArgumentException("Queue is empty");
		}else {
			return super.deleteFront();
		}
		
	}
	
	// Create a method that returns the element at the front of the Queue
	public T peek(){
		T result = null;
		// check for underflow
		if (super.isEmpty()) {
			throw new IllegalArgumentException("Queue is empty");
		}else {
			result = super.front.element;
		}return result;
	}
	
	// Create a method that returns a Queue represented by a string in the 
	// format: [element0, element1, element2, ...]
	public String toString() {
		
		// check for underflow
		if (isEmpty()){
			System.out.println("Queue is empty");
		}

		return super.toString();
	}
	
	

}
