//Problem statement
//For a given a Binary Tree of integers, replace each of its data with the depth of the tree.
//
//Root is at depth 0, hence the root data is updated with 0. Replicate the same further going down the in the depth of the given tree.
//
//The modified tree will be printed in the in-order fashion.
//
//Example:
//Alt text
//
//The above tree after updating will look like this:
//Alt text
//
//Output: 2 1 2 0 2 1 2 (printed in the in-order fashion)
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1sec
// Sample Input 1:
//2 35 10 2 3 5 2 -1 -1 -1 -1 -1 -1 -1 -1 
//Sample Output 1:
//2 1 2 0 2 1 2 
// Sample Input 2:
//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//Sample Output 2:
//2 1 2 0 2 1 2 


package binaryTree_1;

public class ChangeToDepthTree {
	private static void changeToDepthTreeHelper(BinaryTreeNode<Integer> root, int level) {
		if (root == null) {
			return;
		}
		root.data = level;
		changeToDepthTreeHelper(root.left, level + 1);
		changeToDepthTreeHelper(root.right, level + 1);
	}

	public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
		changeToDepthTreeHelper(root, 0);
	}
}
