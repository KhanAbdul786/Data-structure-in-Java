//Problem statement
//For a given Binary Tree of type integer and a number K, print out all root-to-leaf paths where the sum of all the node data along the path is equal to K.
//
//Example:
//alt txt
//
//If you see in the above-depicted picture of Binary Tree, we see that there are a total of two paths, starting from the root and ending at the leaves which sum up to a value of K = 13.
//
//The paths are:
//a. 2 3 4 4
//b. 2 3 8
//
//One thing to note here is, there is another path in the right sub-tree in reference to the root, which sums up to 13 but since it doesn't end at the leaf, we discard it.
//The path is: 2 9 2(not a leaf)
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//2 3 9 4 8 -1 2 4 -1 -1 -1 6 -1 -1 -1 -1 -1
//13
// Sample Output 1:
//2 3 4 4 
//2 3 8
//Sample Input 2:
//5 6 7 2 3 -1 1 -1 -1 -1 9 -1 -1 -1 -1
//13
// Sample Output 2:
//5 6 2
//5 7 1


package binaryTree_2;

/*

Following is the structure used to represent the Binary Tree Node

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

*/

import java.util.*;

import binaryTree_1.BinaryTreeNode;

public class RootToLeafPathsSumToK {

	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		// Your code goes here

		String arr = "";
		rootToLeafPathsSumToK(root, k, arr);
	}

	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k, String arr) {
		if (root == null) {
			return;
		}

		int rootData = root.data;
		// System.out.println("Root data: "+rootData);
		// System.out.println("k: "+k);
		// System.out.println("Old Arraylist: "+arr);
		arr = arr + rootData + " ";
		if (k == rootData && root.left == null && root.right == null) {
			// System.out.print("Path found: ");
			// for (int i=0;i<arr.length();i++)
			// System.out.print(arr.charAt(i)+" ");
			// System.out.println();
			System.out.println(arr);
			return;
		}
		// System.out.println();

		rootToLeafPathsSumToK(root.left, k - rootData, arr);
		rootToLeafPathsSumToK(root.right, k - rootData, arr);
	}

}

///    Ninjas solution

//	private static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k, String path, int currSum) {
//		if (root == null) {
//			return;
//		}
//		if (root.left == null && root.right == null) {
//			currSum += root.data;
//			if (currSum == k) {
//				System.out.println((path + root.data + " "));
//			}
//			return;
//		}
//		rootToLeafPathsSumToK(root.left, k, (path + root.data + " "), (currSum + root.data));
//		rootToLeafPathsSumToK(root.right, k, (path + root.data + " "), (currSum + root.data));
//	}
//
//public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
//rootToLeafPathsSumToK(root, k, "", 0);
//}