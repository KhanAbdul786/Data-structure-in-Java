package bst_1;

import binaryTree_1.BinaryTreeNode;

public class IsBST2 {
	public static boolean isBst(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return true;
		}
		int leftMax = maximum(root.left);
		if (leftMax >= root.data) {
			return false;
		}
		int rightMin = minimum(root.right);
		if (rightMin <= root.data) {
			return false;
		}

		boolean isLeftBst = isBst(root.left);
		boolean isRightBst = isBst(root.right);

		return isLeftBst && isRightBst;
	}

	private static int minimum(BinaryTreeNode<Integer> root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return Integer.MAX_VALUE;
		}
		int leftMin=minimum(root.left);
		int rightMin=minimum(root.right);
		
		return Math.max(root.data, Math.max(leftMin, rightMin));
	}

	private static int maximum(BinaryTreeNode<Integer> root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		int leftMax=maximum(root.left);
		int rightMax=maximum(root.right);
		
		return Math.max(root.data, Math.max(leftMax, rightMax));
	}

}
