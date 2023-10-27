package proAssignment2a;

public class PriorityQueue<T> extends ArrayHeap <T>{
	// value used to set the default size  of PriorityQueue
	private static final int DEFAULT_CAPACITY = 10;
			
	public int capacity;
	T elem;
	// Method that creates an empty Queue
	public PriorityQueue() {
		super();
	}
	
	// Method that creates a Queue with capacity size
	public PriorityQueue(int capacity) {
		super(capacity);
	}
		
	// Method that inserts an element to the Queue
	public void insert (T elem) {

		addElement(elem);
	}
	
	// Method that removes an element from the Queue
	public T remove() {
		
		 return removeMin();
	}
	
	// Method that prints an array representation of the PriorityQueue
	public String toString () {
		if (super.isEmpty()) {
			return " PriorityQueue is empty";
		}
		return super.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> PQ = new PriorityQueue<Integer>();
		System.out.println("Is aH empty " + PQ.isEmpty());
		System.out.println("Is aH Full " + PQ.isFull());
		
		System.out.println("PQ = " + PQ);
		PQ.insert(10);
		PQ.insert(20);
		System.out.println("PQ = " + PQ);
		
		
	}	
}
