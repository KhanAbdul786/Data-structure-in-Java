package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

public class RemoveLeaves {
	public static BinaryTreeNode<Integer> removeLeafs(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return null;
		}
		root.left = removeLeafs(root.left);
		root.right = removeLeafs(root.right);
		return root;
	}
}
