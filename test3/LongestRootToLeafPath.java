//Problem statement
//Given a binary tree, return the longest path from leaf to root. Longest means, a path which contain maximum number of nodes from leaf to root.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
// 5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
//Input Graph
//
//Sample Output 1 :
//9
//3
//6
//5

package test3;

import java.util.ArrayList;

import binaryTree_1.BinaryTreeNode;

public class LongestRootToLeafPath {
	public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root) {
		// Write your code here
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			ArrayList<Integer> ans = new ArrayList<Integer>();
			ans.add(root.data);
			return ans;
		}
		ArrayList<Integer> leftAns = longestRootToLeafPath(root.left);
		ArrayList<Integer> rightAns = longestRootToLeafPath(root.right);
		if (leftAns == null) {
			rightAns.add(root.data);
			return rightAns;
		}
		if (rightAns == null) {
			leftAns.add(root.data);
			return leftAns;
		}
		if (leftAns.size() > rightAns.size()) {
			leftAns.add(root.data);
			return leftAns;
		} else {
			rightAns.add(root.data);
			return rightAns;
		}
	}
}
