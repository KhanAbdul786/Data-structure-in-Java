//Problem statement
//Given a binary search tree, you have to replace each node's data with the sum of all nodes which are greater or equal than it. You need to include the current node's data also.
//
//That is, if in given BST there is a node with data 5, you need to replace it with sum of its data (i.e. 5) and all nodes whose data is greater than or equal to 5.
//
//Note: You don't need to return or print, just change the data of each node.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//Time Limit: 1 second
//Sample Input 1 :
//8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//Sample Output 1 :
//18 
//36 10 
//38 31 
//25 

package bst_1;

public class ReplaceWithLargerNodesSum {
	/*
	 * Binary Tree Node class
	 *
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
	 * right;
	 *
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */
	/*
	 * Time complexity: O(N) Space complexity: O(H)
	 *
	 * where N is the number of nodes in the input BST and H is the height of the
	 * input BST
	 */
	public static int replaceWithLargerNodesSum(BinaryTreeNode<Integer> root, int sum) {
		if (root == null)
			return sum;
		sum = replaceWithLargerNodesSum(root.right, sum);
		sum += root.data;
		root.data = sum;
		sum = replaceWithLargerNodesSum(root.left, sum);
		return sum;
	}

	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		int sum = 0;
		replaceWithLargerNodesSum(root, sum);
	}

}
