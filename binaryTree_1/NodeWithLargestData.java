package binaryTree_1;

public class NodeWithLargestData {
	
	public static int nodeWithLargestData(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return -1;
		}
		int largesLeft = nodeWithLargestData(root.left);
		int largestRight=nodeWithLargestData(root.right);
		
		if(root.data>largesLeft) {
			return root.data;
		}else if (largesLeft>largestRight) {
			return largesLeft;
		}else {
			return largestRight;
		}
	}
}
