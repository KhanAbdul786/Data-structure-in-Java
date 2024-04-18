//Problem statement
//Given a binary tree with N number of nodes, check if that input tree is BST (Binary Search Tree). If yes, return true, return false otherwise.
//
//Note:
//Duplicate elements should be kept in the right subtree.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= Number of edges <= 10^5
//Time Limit: 1 second
//Sample Input 1 :
//3 1 5 -1 2 -1 -1 -1 -1
//
//
//Sample Output 1 :
//true
//Sample Input 2 :
//5 2 10 0 1 -1 15 -1 -1 -1 -1 -1 -1
//
//
//Sample Output 2 :
//false

package bst_1;

import binaryTree_1.BinaryTreeNode;

public class IsBST {
	// Unique elements in BST
	public static boolean isBST(BinaryTreeNode<Integer> root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.data > min && root.data <= max) {
			boolean ans1 = isBST(root.left, min, root.data - 1);
			boolean ans2 = isBST(root.right, root.data, max);
			return ans1 && ans2;
		} else {
			return false;
		}
	}

	public static boolean isBST(BinaryTreeNode<Integer> root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}

//Non Ninjas solution

/*
 * 
 * Following is the structure used to represent the Binary Tree Node
 * 
 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
 * right;
 * 
 * public BinaryTreeNode(T data) { this.data = data; this.left = null;
 * this.right = null; } }
 * 
 */

//import java.util.*;
//
//public class Solution {
//
//	public static int maximum(BinaryTreeNode<Integer> root) {
//		if (root == null) {
//			return Integer.MIN_VALUE;
//		}
//		return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
//	}
//
//	public static int minimum(BinaryTreeNode<Integer> root) {
//		if (root == null) {
//			return Integer.MAX_VALUE;
//		}
//		return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
//	}
//
//	public static boolean isBST(BinaryTreeNode<Integer> root) {
//
//		/*
//		 * Your class should be named Solution Don't write main(). Don't read input, it
//		 * is passed as function argument. Return output and don't print it. Taking
//		 * input and printing output is handled automatically.
//		 */
//		if (root == null) {
//			return true;
//		}
//		int min = maximum(root.left);
//		int max = minimum(root.right);
//		if (root.data <= min) {
//			return false;
//		}
//		if (root.data > max) {
//			return false;
//		}
//		boolean lans = isBST(root.left);
//		boolean rans = isBST(root.right);
//		if (lans && rans) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//}