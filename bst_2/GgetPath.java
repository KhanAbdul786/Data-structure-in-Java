//Problem statement
//Given a BST and an integer k. Find and return the path from the node with data k and root (if a node with data k is present in given BST) in a list. Return empty list otherwise.
//
//Note: Assume that BST contains all unique elements.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//Time Limit: 1 second   
//Sample Input 1:
//8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//2
//Sample Output 1:
//2 5 8

package bst_2;

import java.util.ArrayList;

import binaryTree_1.BinaryTreeNode;

public class GgetPath {
	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int k) {
		if (root == null) {
			return null;
		}
		if (root.data == k) {
			ArrayList<Integer> output = new ArrayList<Integer>();
			output.add(root.data);
			return output;
		} else if (k < root.data) {
			ArrayList<Integer> leftOutput = getPath(root.left, k);
			if (leftOutput != null) {
				leftOutput.add(root.data);
			}
			return leftOutput;
		} else {
			ArrayList<Integer> rightOutput = getPath(root.right, k);
			if (rightOutput != null) {
				rightOutput.add(root.data);
			}
			return rightOutput;
		}
	}
}
