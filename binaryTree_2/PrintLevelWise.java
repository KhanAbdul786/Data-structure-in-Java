//Problem statement
//For a given a Binary Tree of type integer, print it in a level order fashion where each level will be printed on a new line. Elements on every level will be printed in a linear fashion and a single space will separate them.
//
//Example:
//alt txt
//
//For the above-depicted tree, when printed in a level order fashion, the output would look like:
//
//10
//20 30 
//40 50 60
//Where each new line denotes the level in the tree.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec
//Sample Input 1:
//10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1 
//Sample Output 1:
//10 
//20 30 
//40 50 60 
//Sample Input 2:
//8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
//Sample Output 2:
//8 
//3 10 
//1 6 14 
//4 7 13 


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

public class PrintLevelWise {

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		// Your code goes here
		if (root == null)
			return;

		Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<BinaryTreeNode<Integer>>();
		nodesToPrint.add(root);
		nodesToPrint.add(null);
		while (!nodesToPrint.isEmpty()) {
			BinaryTreeNode<Integer> front = nodesToPrint.poll();
			if (front == null) {
				if (nodesToPrint.isEmpty())
					break;
				else {
					System.out.println();
					nodesToPrint.add(null);
				}

			} else {
				System.out.print(front.data + " ");
				if (front.left != null)
					nodesToPrint.add(front.left);
				if (front.right != null)
					nodesToPrint.add(front.right);
			}
		}
	}

}

//Ninjas solution

//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Solution {
//	public static void printLevelWise(BinaryTreeNode<Integer> root) {
//		if (root == null)
//			return;
//// create a queue
//		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
//		pendingNodes.add(root);
//		pendingNodes.add(null);
//		while (!pendingNodes.isEmpty()) {
//			BinaryTreeNode<Integer> frontNode = pendingNodes.poll();
//			if (frontNode == null) {
//				System.out.println();
//				if (!pendingNodes.isEmpty()) {
//					pendingNodes.add(null);
//				}
//			} else {
//				System.out.print(frontNode.data + " ");
//				if (frontNode.left != null) {
//					pendingNodes.add(frontNode.left);
//				}
//				if (frontNode.right != null) {
//					pendingNodes.add(frontNode.right);
//				}
//			}
//		}
//	}
//}
