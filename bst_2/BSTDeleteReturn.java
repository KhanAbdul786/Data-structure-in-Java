package bst_2;

import binaryTree_1.BinaryTreeNode;

public class BSTDeleteReturn {
	BinaryTreeNode<Integer> root;
	boolean deleted;
	
	public BSTDeleteReturn(BinaryTreeNode<Integer> root,boolean deleted) {
		this.root=root;
		this.deleted=deleted;
	}
}
