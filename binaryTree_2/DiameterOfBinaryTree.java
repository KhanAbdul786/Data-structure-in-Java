//Problem statement
//For a given Binary of type integer, find and return the ‘Diameter’.
//
//Diameter of a Tree
//The diameter of a tree can be defined as the maximum distance between two leaf nodes.
//Here, the distance is measured in terms of the total number of nodes present along the path of the two leaf nodes, including both the leaves.
//Example:
//alt txt
//
//The maximum distance can be seen between the leaf nodes 8 and 9. 
//The distance is 9 as there are a total of nine nodes along the longest path from 8 to 9(inclusive of both). Hence the diameter according to the definition will be 9.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec
//Sample Input 1:
//2 4 5 6 -1 -1 7 20 30 80 90 -1 -1 8 -1 -1 9 -1 -1 -1 -1 -1 -1 
//Sample Output 1:
//9
//Sample Input 2:
//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//Sample Output 2:
//5

package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

/*
Time complexity: O(N)
Space complexity: O(H)
where N is the number of nodes in the input tree
and H is the height of the input tree
*/
class Pair {
	int diameter;
	int height;

	public Pair(int diameter, int height) {
		this.diameter = diameter;
		this.height = height;
	}
}

public class DiameterOfBinaryTree {
	private static Pair diameterHelper(BinaryTreeNode<Integer> root) {
		if (root == null) {
			Pair pair = new Pair(0, 0);
			return pair;
		}
		Pair leftPair = diameterHelper(root.left);
		Pair rightPair = diameterHelper(root.right);
		int leftDiameter = leftPair.diameter;
		int rightDiameter = rightPair.diameter;
		/*
		 * 'dist' denotes the longest distance between deepest node of the left subtree
		 * and deepest node of the right subtree
		 */
		int dist = leftPair.height + rightPair.height + 1;
		int diameter = Math.max(leftDiameter, Math.max(rightDiameter, dist));
		int height = Math.max(leftPair.height, rightPair.height) + 1;
		return (new Pair(diameter, height));
	}

	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
		Pair pair = diameterHelper(root);
		return pair.diameter;
	}

}

//Non Ninja solution
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

//public class Solution {
//
//	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
//		// Your code goes here
//		if (root == null) {
//			return 0;
//		}
//		return findHeight(root.left) + findHeight(root.right) + 1;
//	}
//
//	public static int findHeight(BinaryTreeNode<Integer> root) {
//		if (root == null) {
//			return 0;
//		}
//		int leftHeight = findHeight(root.left);
//		int rightHeight = findHeight(root.right);
//
//		if (leftHeight > rightHeight) {
//			return leftHeight + 1;
//		} else {
//			return rightHeight + 1;
//		}
//	}
//
//}