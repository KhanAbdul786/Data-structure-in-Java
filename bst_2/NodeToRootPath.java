package bst_2;

import java.util.ArrayList;

import binaryTree_1.BinaryTreeNode;
import binaryTree_1.BinaryTreeUse;

public class NodeToRootPath {
	public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode<Integer> root, int x) {
		if (root == null) {
			return null;
		}
		if(root.data==x) {
			ArrayList<Integer> output=new ArrayList<>();
			output.add(root.data);
			return output;
		}
		ArrayList<Integer> leftOutput=nodeToRootPath(root.left, x);
		if(leftOutput!=null) {
			leftOutput.add(root.data);
			return leftOutput;
		}
		ArrayList<Integer> rightOutput=nodeToRootPath(root.right, x);
		if(rightOutput!=null) {
			rightOutput.add(root.data);
			return rightOutput;
		}
		return null;
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputBinaryTreeBetter(true, 0, true);
		ArrayList<Integer> path = nodeToRootPath(root, 1);
		if(path==null) {
			System.out.println("not found");
		}
		else {
			for(int i:path) {
				System.out.println(i);
			}
		}
	}
}
