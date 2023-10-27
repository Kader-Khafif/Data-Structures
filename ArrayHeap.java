/*******************************
*       Kader Khafif           *
*       TCSS 342               *
*       Assignment 2a          *
*  ArrayHeap implementation  *
*******************************/

package proAssignment2a;
import java.util.*;

// For better comprehension and ease of follow, the Heap root will start 
//at index 0. Therefore, the equations to find the indices of the left 
//and right child nodes will be (2 * i) + 1 and (2 * i) + 2, respectively,
// where 'i' represents the index of the parent node. Furthermore, the 
//index of the parent node can be calculated as (n - 1) / 2, where 'n' 
//is the index of the child node (either left or right).
public class ArrayHeap<T> {
	// A value is used to create a default size for the arrayHeap
		private static final int DEFAULT_CAPACITY = 10;
		
		public int capacity;
		// Empty array of type T
		private T array[];
		
		// Value to keep track of the ArrayHeap size (number of elements in the stack)
		private int count = 0;
		private int current, parent;
		
		// Default constructor for a stack with a capacity of 10
		public ArrayHeap()   {
		      this(DEFAULT_CAPACITY);
		   }
		
		// Constructor for ArrayHeap with a capacity parameter size
		
		public ArrayHeap(int capacity) {
			this.capacity = capacity;
			// Checking for valid capacity
			if(capacity <= 0)
		         throw new IllegalArgumentException("Capacity can not be 0 or negative");
		      array = (T[])(new Object[capacity]);
		      count = 0;
		}
		
		// check for overflow
		public boolean isFull() {
			if(count != capacity) {
				return false;
			}
				return true;
		}
		
		// checking for underflow
		public boolean isEmpty() {
			if (count < 0) throw new IllegalArgumentException("size can not be negative");
			if (count == 0) {
				return true;
			} return false;
		}
		
		public void resize() {
			// temporary array      
	    	T temp[] = null;   
	    	if (count == capacity) {   
	    		//initialize a double size array 
	    		temp = (T[]) new Object [capacity * 2];   
	    		for (int i = 0; i < capacity; i++) {   
	    			//copies all the elements of the old array  
	    			temp[i] = array[i];   
	    		}   
	    	}   
	    	array = temp;   
	    	capacity = capacity * 2;   
	    }
		
		// Method to retrieve the parent node index (pIndx) of a child not at index n
		public int getParentIndex(int n) {
			int pIndx = (n -1)/2;
			return pIndx;
		}
		
		// Method to retrieve the index of the left child node of a parent node at index i
		public int getLeftChildIndex(int i) {
			int cIndx = 2*i + 1;
			return cIndx;
		}

		// Method to retrieve the index of the left child node of a parent node at index i
		public int getRightChildIndex(int i) {
			int rIndx = 2*i + 2;
			return rIndx;
		}
		
		// Method to swap the parent (max) and child (min) nodes
		public void swap(int min, int max) {
			T temp = array[min];
			array[min] = array[max];
			array[max] = temp;
		}
		
		// Helper method for heapifying over the tree where the child node (added element) 
		// at the current position is less than the parent node.
		boolean  compareTo(int current, int parent) {
			T min = array[current];
			T max = array[parent];
			while( (current > 1) && ((Comparable)min).compareTo(max) < 0) {
				return true;
			}
			return false;
		}
		
		// Method that returns the value at index position i
		T get(int i) {
			return array[i];
		}
		
		// Heapify method is used to maintain the min-heap property after adding an element
		void heapifyUp() {
			T temp;
			 int next = count - 1;
			 temp = array[next];
			 while ((next != 0) &&
			 (((Comparable)temp).compareTo(array[(next-1)/2]) < 0))
			 {
			 array[next] = array[(next-1)/2];
			 next = (next-1)/2;
			 }
			 array[next] = temp;
		}
		
		// Method to add an element at the root position according to the MinHeap
		// property in O(log n) time
		void addElement(T element) { 
			if (isFull()) resize();
			array[count] = element;
			count ++;
			if (count >1)heapifyUp();
		}
		
		// Check if the index is valid
		boolean isValid( int index) {
			if (index > 0 && index < count) return true;
			return false;
		}
		
		// Heapify method to maintain the Min Heap property after removing the minimum element
		void heapifyDown() {
			int indexMin =0;
			int parentIndex = 0; 
			int leftChild = getLeftChildIndex(parentIndex);
			int  rightChild = getRightChildIndex(parentIndex);

			while( isValid(leftChild) ) { // If the while loop is false, no right child is possible
				indexMin = leftChild;
				rightChild = getRightChildIndex(getParentIndex(leftChild));
				if ( isValid(rightChild) && compareTo(rightChild, leftChild)) {
					indexMin = rightChild;
				}
				if (((Comparable)array[indexMin]).compareTo(array[parentIndex]) < 0) {
					swap(indexMin, getParentIndex(indexMin));
					
				}parentIndex = indexMin;
					leftChild = getLeftChildIndex(parentIndex);
					rightChild = getRightChildIndex(parentIndex);
			}

		}
		
		// Method that removes and returns the lowest value (the root) in O(log n) time."
		public T removeMin() {
			T min = array[0];
			if (isEmpty()) throw new IllegalArgumentException("size can not be negative");
			array[0] = array[count-1];
			
			array[count] = null;
			count--;
			heapifyDown();			
			return min;
		}
		
		//Method that orders the heap in increasing order
		public  T[] orderedHeap(T[] array2) {
			int startIndex = getParentIndex(count - 1);
			if (isValid(startIndex)) {
				for (int i = startIndex; i == 0; i--) {
					heapifyUp();
				}
			}return array2;
		}
		
		// Create a toString method that will print the contents of the ArrayHeap.
		public String toString () {
			int n=1;
	    	if (count == 0) {
	    		return "Heap is empty";
	    		
	    	}else {
	        	String str = "[" + array[0];
	        	for (int i = 1; i < count; i++) {
	        		str += ",  " + array [n];
            		n = n +1;	
	        	}
	        	str += "]";
	        	return str;
	        } 
		}

}
