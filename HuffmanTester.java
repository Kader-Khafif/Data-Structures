/*
   TCSS 342
   Author: Raghavi Sakpal
   Tester File for HuffmanTree 
*/
package proAssignment2b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class HuffmanTester {
   public static void main(String[] args) {
      // String to be encoded
      String test1 = "eeyjjjj";
      String test2 = "Eerie eyes seen near lake";
      String test3 = "BACADAEAFABBAAAGAH";
      String test4 = "May the Force be with you !";
      String test5 = "Veni, vidi, vici.";
      
      try   {
    	     
          // Creating File
    	   File file = new File ("output.txt");
    		 
    	   // printing to file
    	   PrintStream stream = new PrintStream(file);
    	   System.setOut(stream);
    	   
         // Let's test for all test Strings 
         testingRoutine(test1);
         testingRoutine(test2);
         testingRoutine(test3);
         testingRoutine(test4);
         testingRoutine(test5);
       }
       catch ( Exception e ){
         System.out.println("Error detected: " + e.getMessage() );
       }  
   }  
   
   /*
      Method: To perform all operations from building frequency table to encoding string
      Parameter: String
      Return: void
   */
   public static void testingRoutine(String test) throws FileNotFoundException  {
      // HashTables to store frequence and encoded bits
      HashMap<Character, Integer> freqTbl = new HashMap<Character, Integer>();            // HashMap to store frequencies 
      HashMap<Character, String> encodedBitsQTbl = new HashMap<Character, String>();      // HashMap to store encoded bits using Queue
      HashMap<Character, String> encodedBitsPQTbl = new HashMap<Character, String>();     // HashMap to store encoded bits using PriorityQueue
      // These are your data structures from Assignment 1b & 2a
      Queue<TreeNode> q = new Queue<TreeNode>();                                 // Queue to build the HuffmanTree
      PriorityQueue<TreeNode> pq = new PriorityQueue<TreeNode>(freqTbl.size()+1);  // PriorityQueue to build the HuffmanTree
   
      // Step1: Build Frequency Table
      frequencyTable(test, freqTbl);
      // Step 2: Build HuffmanTree and encode bits using Queue & PriorityQueue
      encodeHuffmanTree(q,freqTbl,encodedBitsQTbl);
      encodeHuffmanTree(pq,freqTbl,encodedBitsPQTbl);
      // Step 3: Encode the test string using Queue & PriorityQueue based HuffmanTree
      String encodedStrQ = encode(test,encodedBitsQTbl);
      String encodedStrPQ = encode(test,encodedBitsPQTbl);
       //Step 4: Print the output to the output.txt file
      printOutput(test,encodedStrQ,encodedStrPQ);
   } 
     
   /*
      Method: Build Frequency Table 
      Parameter: String 
      Return: void 
   */
   public static void frequencyTable(String test, HashMap<Character, Integer> freqTbl)  {
      // Loop through the String and count the frquencies of each character
      for(int i = 0; i < test.length(); i++) {
         // Check if character key exists then update the frequency count
         if(freqTbl.containsKey(test.charAt(i))) {
            freqTbl.put(test.charAt(i), freqTbl.get(test.charAt(i)) + 1);
         }
         else { // Create a new entry and assign the count to be 1
            freqTbl.put(test.charAt(i), 1);
         }
      }
   }
   
   /*
      Method: To Build the Huffman Tree using Queue and perform traversal to encode bits
      Parameter: Queue<TreeNode>, HashMap<Character,Integer>, HashMap<Character,String>
      Return: void
   */
   public static void encodeHuffmanTree(Queue<TreeNode> q, HashMap<Character,Integer> freqTbl, HashMap<Character,String> encodTbl) {
      TreeNode rootQtree = BuildHuffmanTree.buildTreeQueue(freqTbl, q);
      BuildHuffmanTree.encodeTraversal(rootQtree,"",encodTbl);
      
   }
   
   /*
      Method: To Build the Huffman Tree using PriorityQueue and perform traversal to encode bits
      Parameter: PriorityQueue<TreeNode>, HashMap<Character,Integer>, HashMap<Character,String>
      Return: void 
   */
   public static void encodeHuffmanTree(PriorityQueue<TreeNode> pq, HashMap<Character,Integer> freqTbl, HashMap<Character,String> encodTbl) {
      TreeNode rootPQTree = BuildHuffmanTree.buildTreePQ(freqTbl, pq);
      BuildHuffmanTree.encodeTraversal(rootPQTree,"",encodTbl);
     
   }
   
   /*
      TO DO
      Method: Encode the test string using Queue & PriorityQueue based HuffmanTree
      Parameter: String, HashMap<Character,String>
      Return: String
   */
   public static String encode(String test, HashMap<Character, String> encodTbl) {
      // Your code goes here 
	   String tempTbl ="";
	   //System.out.println("etempTbl = "+tempTbl);
	   //System.out.println("etempTbl = "+encodTbl);
	   for(int i = 0; i < test.length(); i++) {
		   
		   tempTbl += encodTbl.get(test.charAt(i));
	   }
	   //System.out.println("tempTbl = "+tempTbl);
	   return tempTbl;
   }
   
   /*
      TO DO
      Method: Write your output to the output.txt file  
      Parameter: String, String, String
      Return: void
   */
   public static void printOutput(String test, String encodedStrQ, String encodedStrPQ) {
      // Your code goes here
	   	   	   
	   // Looping to print the text string 
	   int n = 0;
	   String str = "[";
	   for(int i = 0; i < test.length(); i++) {
		   str +=test.charAt(i);
		   n++;
	   }
	   str += "]";
	   int StrBit = 8*n;
	   // Print String to file
	   System.out.println("Test String = "+str + " [" + StrBit + "]");
	   
	   // Counting numbers of bits in Q encoded
	   double x = 0;
	   for(int i = 0; i < encodedStrQ.length(); i++) {
		   x++;
	   }
	   double QBit = (1-(x/StrBit))*100;
	   // Printing Encoded Q Bitstream 
	   System.out.println("[Encoded Bitstream using HuffmanTree_Q: " + encodedStrQ + "]" + "[" + (int)x +"]");
	    System.out.print("Space Saving (%) : ");
	    System.out.printf("%.2f", QBit);
	    System.out.println(" ]");

		   // Counting numbers of bits in PQ encoded
		   double y = 0;
		   for(int i = 0; i < encodedStrPQ.length(); i++) {
			   y++;
		   }
		   double PQBit = (1-(y/StrBit))*100;
		   // Printing Encoded PQ Bitstream 
		   System.out.println("[Encoded Bitstream using HuffmanTree_PQ: " + encodedStrPQ + "]" + "[" + (int)y +"]");
		    System.out.print("Space Saving (%) : ");
		    System.out.printf("%.2f", PQBit);
		    System.out.println(" ]");
		    System.out.println();
		    
  

   }
   
}