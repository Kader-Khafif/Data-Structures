/*********************************************************
					Kader Khafif
				TCES 342 Data structures
					Assignemnt 2b
				HuffmanTree
					03/07/23
*********************************************************/


package proAssignment2b;


// Represent an Huffman tree
public class HuffmanTree extends TreeNode {
	
	// Entry point of the Huffman tree, which is the root
	public TreeNode root;
	
	// HuffmanTree constructor
	public HuffmanTree(TreeNode left, TreeNode right) {
		
		priority = (left.priority + right.priority);
		root = new TreeNode(priority);
		this.root.left = left;
		this.root.right = right;
				
	}
	
	// Method that return the Hufman Tree root
	public TreeNode getRoot() {
		return root;
	}
}
