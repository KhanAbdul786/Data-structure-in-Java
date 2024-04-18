////Problem statement
////For a given a Binary Tree of type integer, find and return the minimum and the maximum data values.
////
////Return the output as an object of Pair class, which is already created.
////
////Note:
////All the node data will be unique and hence there will always exist a minimum and maximum node data.
////Detailed explanation ( Input/output format, Notes, Images )
////Constraints:
////2 <= N <= 10^5
////Where N is the total number of nodes in the binary tree.
////
////Time Limit: 1 sec
////Sample Input 1:
////8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
////Sample Output 1:
////1 14
////Sample Input 2:
////10 20 60 -1 -1 3 50 -1 -1 -1 -1 
////Sample Output 2:
////3 60
//
//package binaryTree_2;
//
//import binaryTree_1.BinaryTreeNode;
//
///*
//
//Following is the structure used to represent the Binary Tree Node
//
//class BinaryTreeNode<T> {
//	T data;
//	BinaryTreeNode<T> left;
//	BinaryTreeNode<T> right;
//
//	public BinaryTreeNode(T data) {
//		this.data = data;
//		this.left = null;
//		this.right = null;
//	}
//}
//
//*/
//
////Representation of the Pair Class
//
//class Pair<T, U> {
//	T minimum;
//	U maximum;
//
//	public Pair(T minimum, U maximum) {
//		this.minimum = minimum;
//		this.maximum = maximum;
//	}
//
//}
//
//public class GetMinAndMax {
//
//	private static Pair<Integer, Integer> maxMin = new Pair<Integer, Integer>(Integer.MAX_VALUE, Integer.MIN_VALUE);
//
//	public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
//		// Your code goes here
//
//		getMinAndMaxHelper(root);
//		return maxMin;
//
//	}
//
//	private static void getMinAndMaxHelper(BinaryTreeNode<Integer> root) {
//		if (root == null) {
//			return;
//		}
//
//		int rootData = root.data;
//		int maxVal = maxMin.maximum;
//		if (rootData > maxVal) {
//			maxMin.maximum = root.data;
//		}
//
//		int minVal = maxMin.minimum;
//		if (rootData < minVal) {
//			maxMin.minimum = root.data;
//		}
//		getMinAndMaxHelper(root.left);
//		getMinAndMaxHelper(root.right);
//	}
//
//	// Ninjas solution
//
////	public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
////		if (root == null) {
////			return new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE);
////		}
////		Pair<Integer, Integer> leftPair = getMinAndMax(root.left);
////		Pair<Integer, Integer> rightPair = getMinAndMax(root.right);
////		int minimum = Math.min(root.data, Math.min(leftPair.minimum, rightPair.minimum));
////		int maximum = Math.max(root.data, Math.max(leftPair.maximum, rightPair.maximum));
////		return new Pair<>(minimum, maximum);
////	}
//
//}
