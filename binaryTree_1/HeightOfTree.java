//Problem statement
//For a given Binary Tree of integers, find and return the height of the tree. Height is defined as the total number of nodes along the longest path from the root to any of the leaf node.
//
//Example:
//ALTIMAGE
//
//Height of the given tree is 3. 
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//0 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec
//Sample Input 1:
//10 20 30 40 50 -1 -1 -1 -1 -1 -1
//Sample Output 1:
//3
//Sample Input 2:
//3 -1 -1
//Sample Output 2:
//1


package binaryTree_1;
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
public class HeightOfTree {
	public static int heightofTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int left = heightofTree(root.left);
		int right = heightofTree(root.right);
		if(left>right) {
			return 1+left;
		}
		else {
			return 1+right;
		}
	}
//	Ninijas
//	public static int height(BinaryTreeNode<Integer> root) {
//		if (root == null) {
//		return 0;
//		}
//		return Math.max(height(root.left), height(root.right)) + 1;
//		}
}
