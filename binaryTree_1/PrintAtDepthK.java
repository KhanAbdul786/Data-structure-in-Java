package binaryTree_1;

public class PrintAtDepthK {
	public static void printAtdepth(BinaryTreeNode<Integer> root,int k) {
		if(root==null) {
			return;
		}
		if(k==0) {
			System.out.println(root.data);
			return;
		}
		printAtdepth(root.left, k-1);
		printAtdepth(root.right, k-1);
	}
}
