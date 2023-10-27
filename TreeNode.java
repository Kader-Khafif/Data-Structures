/*********************************************************
					Kader Khafif
				TCES 342 Data structures
					Assignemnt 2b
				HuffmanTree
					03/07/23
*********************************************************/


package proAssignment2b;

public class TreeNode implements Comparable<TreeNode>{
	
	//  Reference variable to the left Node
	public TreeNode left = null;
	// Reference variable to the Right Node
	public TreeNode right = null;
	// Variable of type T
	public Character element;
	// Variable to keep track of priority
	int priority;
	
	// Default constructor with priority
	public TreeNode(Character element, int priority) {
		this.element = element;
		this.priority = priority;
		this.left = null;
		this.right = null;
		
	}
	
	// Default constructor with no priority
		public TreeNode(int priority) {
			element = null;
			this.priority = priority;
			this.left = null;
			this.right = null;
		}
		
		// Default constructor with priority
		public TreeNode() {
			this.element = null;
			this.priority = 0;
			this.left = null;
			this.right = null;
			
		}
		
		// Method that checks if the node is a leaf node
		public boolean isLeaf() {
			if ((left == null) && (right == null)) { 
				return true;
			}else return false;
		}
		
		// Method that returns the element in the Node
		public Character getElement() {
			return element;
		}
					
		// Method that returns the priority of the Node
		public int getPriority() {
			return priority;
		}
		
		// Method that compares the current TreeNode
		// with the method's parameter TreeNode
		public int compareTo (TreeNode node) {
			
			if (priority > node.getPriority()) return 1;
			return -1;
		}

}
