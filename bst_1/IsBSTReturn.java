package bst_1;

import binaryTree_1.BinaryTreeNode;

public class IsBSTReturn {
	int min;
	int max;
	boolean isBST;

	public IsBSTReturn(int min, int max, boolean isBST) {
		this.min = min;
		this.max = max;
		this.isBST = isBST;
	}
	
	public static IsBSTReturn isBST2(BinaryTreeNode<Integer> root) {
		if(root==null) {
			IsBSTReturn ans=new IsBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
			return ans;
		}
		
		IsBSTReturn leftAns=isBST2(root.left);
		IsBSTReturn rightAns=isBST2(root.right);
		
		int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
		int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
		
		boolean isBST=true;
		if(leftAns.max>=root.data) {
			isBST=false;
		}
		if(rightAns.min<=root.data) {
			isBST=false;
		}
		if(!leftAns.isBST) {
			isBST= false;
		}
		if(!rightAns.isBST) {
			isBST=false;
		}
		
		IsBSTReturn ans=new IsBSTReturn(min, max, isBST);
		return ans;
	}
	
	public static boolean isBST3(BinaryTreeNode<Integer> root,int minRange,int maxRange) {
		if(root==null) {
			return true;
		}
		if(root.data<minRange ||root.data>maxRange) {
			return false;
		}
		
		boolean isLeftWithinRange= isBST3(root.left, minRange, root.data-1);
		boolean isRightWithinRange= isBST3(root.right, root.data, maxRange);
		
		return isLeftWithinRange && isRightWithinRange;
	}
}
