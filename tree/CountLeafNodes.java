//Problem statement
//Given a generic tree, count and return the number of leaf nodes present in the given tree. A node is said to be a leaf node if it's not having any child
//
//
//Leaf nodes in the given tree are 40, 50, 30, 40. So the answer for this is 4.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//10 3 20 30 40 2 40 50 0 0 0 0 
//Sample Output 1 :
//4

package tree;

public class CountLeafNodes {
	public static int countLeafNodes(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		if (root.child.size() == 0) {
			return 1;
		}
		int count = 0;
		for (TreeNode<Integer> child : root.child) {
			count += countLeafNodes(child);
		}
		return count;
	}
}
