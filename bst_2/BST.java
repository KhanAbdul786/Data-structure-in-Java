package bst_2;

import binaryTree_1.BinaryTreeNode;

public class BST {
	private BinaryTreeNode<Integer> root;
	private int size;

	public boolean isPresent(int x) {
		return isPresentHelper(root, x);
	}

	public void insert(int x) {
		root = insert(root, x);
		size++;
	}

	public boolean deleteData(int x) {
		BSTDeleteReturn output = deleteDtatHelper(root, x);
		root = output.root;
		if (output.deleted) {
			size--;
		}
		return output.deleted;
	}

	public int size() {
		return size;
	}

	public void printTree() {
		printTreeHelper(root);
	}

	private static boolean isPresentHelper(BinaryTreeNode<Integer> node, int x) {
		if (node == null) {
			return false;
		}
		if (node.data == x) {
			return true;
		}
		if (x < node.data) {
			return isPresentHelper(node.left, x);
		} else {
			return isPresentHelper(node.right, x);
		}

	}

	private static void printTreeHelper(BinaryTreeNode<Integer> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + ":");
		if (node.left != null) {
			System.out.print("L" + node.left.data + ", ");
		}
		if (node.right != null) {
			System.out.print("R" + node.right.data);
		}
		System.out.println();

		printTreeHelper(node.left);
		printTreeHelper(node.right);

	}

	private static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node, int x) {
		if (node == null) {
			BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<Integer>(x);
			return newRoot;
		}
		if (x >= node.data) {
			node.right = insert(node.right, x);
		} else {
			node.left = insert(node.left, x);
		}
		return node;
	}

	private static BSTDeleteReturn deleteDtatHelper(BinaryTreeNode<Integer> root, int x) {
		if (root == null) {
			return new BSTDeleteReturn(null, false);
		}
		if (root.data < x) {
			BSTDeleteReturn outputRight = deleteDtatHelper(root.right, x);
			root.right = outputRight.root;
			outputRight.root = root;
			return outputRight;
		}
		if (root.data > x) {
			BSTDeleteReturn outputLeft = deleteDtatHelper(root.left, x);
			root.left = outputLeft.root;
			outputLeft.root = root;
			return outputLeft;
		}
		// 0 children
		if (root.left == null && root.right == null) {
			return new BSTDeleteReturn(null, true);
		}
		// only left child
		if (root.left != null && root.right == null) {
			return new BSTDeleteReturn(root.left, true);
		}
		// only right child
		if (root.right == null && root.right != null) {
			return new BSTDeleteReturn(root.right, true);
		}
		// both children are present
		int rightMax=minimum(root.right);
		root.data=rightMax;
		
		BSTDeleteReturn outputRight=deleteDtatHelper(root.right, rightMax);
		root.right=outputRight.root;
		return new BSTDeleteReturn(root, true);
	}
	
	public static int minimum(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return Integer.MAX_VALUE;
		}
		int minLeft=minimum(root.left);
		int minRight=minimum(root.right);
		
		return Math.min(root.data, Math.min(minLeft, minRight));
	}
}
