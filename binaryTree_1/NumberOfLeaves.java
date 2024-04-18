package binaryTree_1;

public class NumberOfLeaves {
	public static int numberOfLeaves(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return 1;
		}
		return numberOfLeaves(root.left)+numberOfLeaves(root.right);
	}
}
