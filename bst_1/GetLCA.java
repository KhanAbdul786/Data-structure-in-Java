//Problem statement
//Given a binary search tree and data of two nodes, find 'LCA' (Lowest Common Ancestor) of the given two nodes in the BST.
//
//LCA
//LCA of two nodes A and B is the lowest or deepest node which has both A and B as its descendants. 
//Example:
//In this example, the green coloured node is the LCA to A and B.
//Alt Text
//
//Note:
//It is defined that each node is a descendant to itself, so, if there are two nodes X and Y and X has a direct connection from Y, then Y is the lowest common ancestor.
//Example:
//Alt Text
//
//Note:
//
//1. If out of 2 nodes only one node is present, return that node. 
//2. If both are not present, return -1.
//3. all the node data will be unique.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//Time Limit: 1 second
//Sample Input 1:
//8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//2 10
//Sample Output 1:
//8
//Sample Input 2:
//8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//2 6
//Sample Output 2:
//5
//Sample Input 3:
//8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//12 78
//Sample Output 3:
//-1

package bst_1;

public class GetLCA {
	/*
	 * Binary Tree Node class
	 *
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
	 * right;
	 *
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */
	/*
	 * Time complexity: O(H) Space complexity: O(H)
	 *
	 * where H is the height of the input BST
	 */
	public static BinaryTreeNode<Integer> getLCAUtil(BinaryTreeNode<Integer> root, int a, int b) {
		if (root == null || root.data == a || root.data == b) {
			return root;
		}
		if (root.data < a && root.data < b) {
			return getLCAUtil(root.right, a, b);
		} else if (root.data > a && root.data > b) {
			return getLCAUtil(root.left, a, b);
		}
		BinaryTreeNode<Integer> leftLCA = getLCAUtil(root.left, a, b);
		BinaryTreeNode<Integer> rightLCA = getLCAUtil(root.right, a, b);
		if (leftLCA != null && rightLCA != null) {
			return root;
		} else if (leftLCA != null) {
			return leftLCA;
		}
		return rightLCA;
	}

	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		BinaryTreeNode<Integer> node = getLCAUtil(root, a, b);
		return (node == null) ? -1 : node.data;
	}
}
