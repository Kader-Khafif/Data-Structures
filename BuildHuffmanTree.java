/*********************************************************
					Kader Khafif
				TCES 342 Data structures
					Assignemnt 2b
				HuffmanTree
					03/07/23
*********************************************************/

package proAssignment2b;

import java.util.HashMap;

public class BuildHuffmanTree {
	
	// Method that builds and returns the root when the Huffman tree is entirely
	// built using a Queue. We loop until only one node remains in the PriorityQueue
	public static TreeNode buildTreeQueue (HashMap <Character, Integer> freqTbl,
			Queue <TreeNode> q) {

		// We enqueue all keys and values from freqTbl to the Queue
		for (Character key : freqTbl.keySet() ) {
			int val = freqTbl.get(key);
			TreeNode tempNode= new TreeNode(key, freqTbl.get(key));
			q.enqueue(tempNode);
			
		}
		TreeNode left, right;
		TreeNode root = null;

		while (q.count != 1) {

			left = q.dequeue(); 
			right = q.dequeue();
			root = new HuffmanTree(left, right).getRoot();
			q.enqueue(root);
			
		}
		return q.dequeue();
	}
	
	// Method that builds and returns the root when the Human tree is entirely built using PriorityQueue
	public static TreeNode buildTreePQ (HashMap <Character, Integer> freqTbl,
			PriorityQueue <TreeNode> pq) {
		// Inserting elements in Priority Queue
		for (Character m : freqTbl.keySet() ) {
			TreeNode temp= new TreeNode(m, freqTbl.get(m));
			pq.insert(temp);
		}

		TreeNode left, right;
		TreeNode parent = null;
		// using PriorityQueue class from assignment 2a
		while (pq.count() != 1) {
			left = pq.remove(); 
			right = pq.remove();
			parent= new HuffmanTree(left, right).getRoot();
			pq.insert(parent);
		}
		return pq.remove();
	}
	
	// Method that generates the Huffman code using level traversal starting with the root
	public static void encodeTraversal(TreeNode root, String code, 
			HashMap<Character,String> encodTbl) {
		
		if(root.isLeaf()) {
			encodTbl.put(root.element,code);			
		}else {
		encodeTraversal(root.left, code.concat("0"), encodTbl);
		encodeTraversal(root.right, code.concat("1"), encodTbl);
		}
	}

}
