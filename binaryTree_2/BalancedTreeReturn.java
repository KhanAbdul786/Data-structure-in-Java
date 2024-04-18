package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

public class BalancedTreeReturn {
	int height;
	boolean isBlalanced;

	public static BalancedTreeReturn isBlancedBetter(BinaryTreeNode<Integer> root) {
		if (root == null) {
			int height = 0;
			boolean isBal = true;

			BalancedTreeReturn ans = new BalancedTreeReturn();
			ans.height = height;
			ans.isBlalanced = isBal;

			return ans;
		}

		BalancedTreeReturn leftOutput = isBlancedBetter(root.left);
		BalancedTreeReturn rightOutput = isBlancedBetter(root.right);

		boolean isBal = true;
		int height=1+Math.max(leftOutput.height, rightOutput.height);
		
		if(Math.abs(leftOutput.height-rightOutput.height)>1) {
			isBal=false;
		}
		
		if(!leftOutput.isBlalanced ||!rightOutput.isBlalanced) {
			isBal=false;
		}
		
		BalancedTreeReturn ans = new BalancedTreeReturn();
		ans.height = height;
		ans.isBlalanced = isBal;

		return ans;
	}
}
