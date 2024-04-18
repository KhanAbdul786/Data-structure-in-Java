//Problem statement
//For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.
//
//Note:
//Assume that the Binary Tree contains only unique elements. 
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^3
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec
//Sample Input 1:
//7
//1 2 4 5 3 6 7 
//4 2 5 1 6 3 7 
//Sample Output 1:
//1 
//2 3 
//4 5 6 7 
//Sample Input 2:
//6
//5 6 2 3 9 10 
//2 6 3 9 5 10 
//Sample Output 2:
//5 
//6 10 
//2 3 
//9 

package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

//Ninjas version

public class PreOrderInOrder {
	private static BinaryTreeNode<Integer> buildTreeHelper(int[] preOrder, int preStart, int preEnd, int[] inOrder,
			int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		int rootVal = preOrder[preStart];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootVal);
// Find root element index from inOrder array
		int k = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (rootVal == inOrder[i]) {
				k = i;
				break;
			}
		}
		root.left = buildTreeHelper(preOrder, preStart + 1, preStart + (k - inStart), inOrder, inStart, k - 1);
		root.right = buildTreeHelper(preOrder, preStart + (k - inStart) + 1, preEnd, inOrder, k + 1, inEnd);
		return root;
	}

	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		int n = preOrder.length;
		int preStart = 0;
		int preEnd = n - 1;
		int inStart = 0;
		int inEnd = n - 1;
		return buildTreeHelper(preOrder, preStart, preEnd, inOrder, inStart, inEnd);
	}

//	non ninjas version

//	public static BinaryTreeNode<Integer> buildTreeFromPreInt(int[] pre,int[] in){
//		BinaryTreeNode<Integer> root=buildTreeFromPreHelper(pre,in,0,pre.length-1,0,in.length-1){
//			return root;
//		}
//	}
//
//	private static BinaryTreeNode<Integer> buildTreeFromPreHelper(int[] pre, int[] in, int siPre, int eiPre, int siIn,
//			int eiIn) {
//		if (siPre > eiPre) {
//			return null;
//		}
//		int rootData = pre[siPre];
//		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
//
//		int rootIndex = -1;
//		for (int i = siIn; i < eiIn; i++) {
//			if (in[i] == rootData) {
//				rootIndex = i;
//				break;
//			}
//		}
//
////		Assuming root actually present inorder
//
//		int siPreLeft = siPre + 1;
//		int siInLeft = siIn;
//		int eiInLeft = rootIndex - 1;
//		int siInRight = rootIndex + 1;
//		int eiPreRight = eiPre;
//		int eiInRight = eiIn;
//		
//		int subTreeLength=eiInLeft-siInLeft+1;
//		
//		int eiPreLeft=siPreLeft+subTreeLength-1;
//		int siPreRight = eiPreLeft+1;
//		
//		BinaryTreeNode<Integer> left=buildTreeFromPreHelper(pre, in, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
//		BinaryTreeNode<Integer> right=buildTreeFromPreHelper(pre, in, siPreRight, siPreRight, siInRight, eiInRight);
//		
//		root.left=left;
//		root.right=right;
//		
//		return root;
//	}
}