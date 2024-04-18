package binaryTree_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {
	public static void printTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		printTree(root.left);
		printTree(root.right);

//		if (root.left != null) {
//			printTree(root.left);
//		}
//		if (root.right != null) {
//			printTree(root.right);
//		}
	}

	public static void printTreeDetaild(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + ":");
		if (root.left != null) {
			System.out.print("L" + root.left.data + ", ");
		}
		if (root.right != null) {
			System.out.print("R" + root.right.data);
		}
		System.out.println();

		printTreeDetaild(root.left);
		printTreeDetaild(root.right);
	}

	public static BinaryTreeNode<Integer> takeInputBinaryTree() {
		System.out.println("enter root data ");
		Scanner sc = new Scanner(System.in);
		int rootData = sc.nextInt();

		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		BinaryTreeNode<Integer> rootLeft = takeInputBinaryTree();
		BinaryTreeNode<Integer> rootRight = takeInputBinaryTree();
		root.left = rootLeft;
		root.right = rootRight;

		return root;

	}

	public static BinaryTreeNode<Integer> takeInputBinaryTreeBetter(boolean isRoot, int parentData, boolean isLeft) {
		if (isRoot) {
			System.out.println("Enter root data ");
		} else {
			if (isLeft) {
				System.out.println("Enter the left child of " + parentData);
			} else {
				System.out.println("Enter the right child of " + parentData);
			}
		}
		Scanner sc = new Scanner(System.in);
		int rootData = sc.nextInt();

		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		BinaryTreeNode<Integer> rootLeft = takeInputBinaryTreeBetter(false, rootData, true);
		BinaryTreeNode<Integer> rootRight = takeInputBinaryTreeBetter(false, rootData, false);
		root.left = rootLeft;
		root.right = rootRight;

		return root;

	}

	public static int numberOfNodes(BinaryTreeNode<Integer> root) {
		int count = 0;
		if (root == null) {
			return 0;
		}

		int leftCount = numberOfNodes(root.left);
		int rightCount = numberOfNodes(root.right);
		return 1 + leftCount + rightCount;
	}

	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		Scanner sc = new Scanner(System.in);
		int rootData = sc.nextInt();

		if (rootData == -1) {
			return null;
		}

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> pendingChild = new LinkedList<>();
		pendingChild.add(root);

		while (!pendingChild.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingChild.poll();
			System.out.println("Enter the left child of " + front.data);
			int left = sc.nextInt();
			if (left != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(left);
				front.left = leftChild;
				pendingChild.add(leftChild);
			}

			System.out.println("Enter the right child of " + front.data);
			int right = sc.nextInt();
			if (right != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(right);
				front.right = rightChild;
				pendingChild.add(rightChild);
			}
		}

		return root;
	}

	public static int sumOfNodes(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int sumLeft=sumOfNodes(root.left);
		int sumRight=sumOfNodes(root.right);
		int smallSum = sumLeft+sumRight;
		return root.data + smallSum;
	}

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		Queue<BinaryTreeNode<Integer>> pendingChild = new LinkedList<>();
		pendingChild.add(root);
		while (!pendingChild.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingChild.poll();
			System.out.print(front.data + ":");

			if (front.left != null) {
				System.out.print("L" + front.left.data + ", ");
			}

			if (front.right != null) {
				System.out.print("R" + front.right.data);
			}

			System.out.println();

			printTreeDetaild(root.left);
			printTreeDetaild(root.right);
		}

	}

	public static void main(String[] args) {
//		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
//		BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(2);
//		BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(3);
//
//		root.left = rootLeft;
//		root.right = rootRight;
//
//		BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<Integer>(4);
//		BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<Integer>(5);
//		rootLeft.right = twoRight;
//		rootRight.left = threeLeft;

//		BinaryTreeNode<Integer> root = takeInputBinaryTreeBetter(true, 0, true);
		BinaryTreeNode<Integer> root = takeInputLevelWise();

		printLevelWise(root);
//		System.out.println(numberOfNodes(root));
		System.out.println(sumOfNodes(root));

	}

}
