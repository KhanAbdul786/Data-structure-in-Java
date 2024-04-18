package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binaryTree_1.BinaryTreeNode;
import queues.QueueEmptyException;
import queues.QueueUsingLL;

public class TreeTest {
	public static void printTree(TreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		for(int i=0;i<root.child.size();i++) {
			TreeNode<Integer> child = root.child.get(i);
			printTree(child);
		}
	}
	
	public static void printTreeBetter(TreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+": ");
		for(int i=0;i<root.child.size();i++) {
			System.out.print(root.child.get(i).data+" ");
		}
		System.out.println();
		for(int i=0;i<root.child.size();i++) {
			TreeNode<Integer> child = root.child.get(i);
			printTreeBetter(child);
		}
	}
	public static int numberOfNodes(TreeNode<Integer> root) {
		int count=1;
		for(int i=0;i<root.child.size();i++) {
			int childCount=numberOfNodes(root.child.get(i));
			count +=childCount;
		}
		return count;
	}
	public static TreeNode<Integer> takeInput() throws QueueEmptyException{
		Scanner sc=new Scanner(System.in);
		Queue<TreeNode<Integer>> pendingChild = new LinkedList<>();
		System.out.println("Enter root data");
		int rootData=sc.nextInt();
		if(rootData==-1) {
			return null;
		}
		TreeNode<Integer> root=new TreeNode<Integer>(rootData);
		pendingChild.add(root);
		
		while(!pendingChild.isEmpty()) {
			TreeNode<Integer> front=pendingChild.poll();
			System.out.println("Enter the number of children for "+front.data);
			int numChild=sc.nextInt();
			for(int i=0;i<numChild;i++) {
				System.out.println("Enter the "+i+"th child for:"+front.data);
				int childData=sc.nextInt(); 	
				TreeNode<Integer> childNode=new TreeNode<Integer>(childData);
				front.child.add(childNode);
				pendingChild.add(childNode);
			}
		}
		return root;
	}

	public static void main(String[] args) throws QueueEmptyException {
		TreeNode<Integer> root = new TreeNode<Integer>(4);
		TreeNode<Integer> node1 = new TreeNode<Integer>(2);
		TreeNode<Integer> node2 = new TreeNode<Integer>(3);
		TreeNode<Integer> node3 = new TreeNode<Integer>(1);
		TreeNode<Integer> node4 = new TreeNode<Integer>(5);
		TreeNode<Integer> node5 = new TreeNode<Integer>(6);
		
		root.child.add(node1);
		root.child.add(node2);
		root.child.add(node3);
		
		node2.child.add(node4);
		node2.child.add(node5);
		
		TreeNode<Integer> root1=takeInput();
		
		printTreeBetter(root1);
//		System.out.println(numberOfNodes(root));

	}

}
