package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

public class IsBalanced {
	public static boolean isBlalanced(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return false;
		}
		int heightLeft=height(root.left);
		int rightHeight=height(root.right);
		
		if(Math.abs(heightLeft-rightHeight)>1) {
			return false;
		}
		
		boolean isleftBalanced=isBlalanced(root.left);
		boolean isRightBalanced=isBlalanced(root.right);
		
		return isleftBalanced && isRightBalanced;
	}

	private static int height(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int heghtLeft=height(root.left);
		int right=height(root.right);
		
		return 1+Math.max(heghtLeft, right);
	}
}
