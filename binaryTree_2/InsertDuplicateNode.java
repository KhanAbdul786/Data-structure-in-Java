//Problem statement
//For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.
//
//The root will remain the same. So you just need to insert nodes in the given Binary Tree.
//
//Example:
//alt txt
//
//After making the changes to the above-depicted tree, the updated tree will look like this.
//alt txt
//
//You can see that every node in the input tree has been duplicated and inserted to the left of itself.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec
//Sample Input 1:
//10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1
//Sample Output 1:
//10 
//10 30 
//20 30 60 
//20 50 60 
//40 50 
//40 
//Sample Input 2:
//8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//Sample Output 2:
//8 
//8 10 
//5 10 
//5 6 
//2 6 7 
//2 7

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

public class InsertDuplicateNode {

	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		// Your code goes here
		if (root == null)
			return;

		insertDuplicateNode(root.left);
		insertDuplicateNode(root.right);
		BinaryTreeNode<Integer> node = new BinaryTreeNode<>(root.data);
		BinaryTreeNode<Integer> temp = root.left;
		root.left = node;
		node.left = temp;
	}
	
	//Ninjas solution
	
//	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
//		if (root == null) {
//		return;
//		}
//		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(root.data);
//		BinaryTreeNode<Integer> rootLeft = root.left;
//		root.left = newNode;
//		newNode.left = rootLeft;
//		insertDuplicateNode(rootLeft);
//		insertDuplicateNode(root.right);
//	}

}