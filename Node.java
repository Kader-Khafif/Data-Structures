package proAssignment2a;




public class Node <T> {
	private T element;
	private int priority;
	
	// Default constructor with priority
	public Node(T element, int priority) {
		this.element = element;
		this.priority = priority;
		
	}
	
	// Default constructor with no priority
		public Node(T element) {
			this.element = element;
			priority = 0;
		}
		// Method that returns the element in the Node
		public T getElement() {
			return element;
		}
					
		// Method that returns the priority of the Node
		public int getPriority() {
			return priority;
		}

}
