//Problem statement
//You are given a Binary Tree of type integer, a integer value of target node's data, and an integer value K.
//
//Print the data of all nodes that have a distance K from the target node. The order in which they would be printed will not matter.
//
//Example:
//For a given input tree(refer to the image below):
//1. Target Node: 5
//2. K = 2
//alt txt
//
//Starting from the target node 5, the nodes at distance K are 7 4 and 1.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//1 ≤ data of node ≤ 10^9
//1 ≤ target ≤ 10^9
//
//Time Limit: 1 sec
//Sample Input 1:
//5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
//3 1
//Sample Output 1:
//9
//6
//Sample Input 2:
//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//3 3
//Sample Output 2:
//4
//5

package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

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

public class NodesAtDistanceK {

	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
		// Your code goes here
		printKDistanceNode(root, node, k);

	}

	private static void printKDistanceFromRoot(BinaryTreeNode<Integer> node, int k) {
		if (node == null || k < 0)
			return;

		if (k == 0) {
			System.out.println(node.data);
			return;
		}
		printKDistanceFromRoot(node.left, k - 1);
		printKDistanceFromRoot(node.right, k - 1);
	}

	private static int printKDistanceNode(BinaryTreeNode<Integer> root, int node, int k) {
		if (root == null)
			return -1;

		if (root.data == node) {
			printKDistanceFromRoot(root, k);
			return 0;
		}
		int dl = printKDistanceNode(root.left, node, k);
		if (dl != -1) {
			if (dl + 1 == k)
				System.out.println(root.data);
			else
				printKDistanceFromRoot(root.right, k - dl - 2);
			return 1 + dl;
		}

		int rd = printKDistanceNode(root.right, node, k);
		if (rd != -1) {
			if (rd + 1 == k)
				System.out.println(root.data);
			else
				printKDistanceFromRoot(root.left, k - rd - 2);
			return 1 + rd;
		}
		return -1;
	}

}

//  Nijas solution

//	private static int nodesAtDistanceKHelper(BinaryTreeNode<Integer> root, int target, int k) {
//		if (root == null) {
//			return -1;
//		}
//		if (root.data == target) {
//			nodesAtDistanceKDown(root, k);
//			return 0;
//		}
//		int leftD = nodesAtDistanceKHelper(root.left, target, k);
//		if (leftD != -1) {
//			if (leftD + 1 == k) {
//				System.out.println(root.data);
//			} else {
//				nodesAtDistanceKDown(root.right, k - leftD - 2);
//			}
//			return 1 + leftD;
//		}
//		int rightD = nodesAtDistanceKHelper(root.right, target, k);
//		if (rightD != -1) {
//			if (rightD + 1 == k) {
//				System.out.println(root.data);
//			} else {
//				nodesAtDistanceKDown(root.left, k - rightD - 2);
//			}
//			return 1 + rightD;
//		}
//		return -1;
//	}
//
//	private static void nodesAtDistanceKDown(BinaryTreeNode<Integer> root, int k) {
//		if (root == null) {
//			return;
//		}
//		if (k == 0) {
//			System.out.println(root.data);
//			return;
//		}
//		nodesAtDistanceKDown(root.left, k - 1);
//		nodesAtDistanceKDown(root.right, k - 1);
//	}
//
//public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
//nodesAtDistanceKHelper(root, node, k);
//}