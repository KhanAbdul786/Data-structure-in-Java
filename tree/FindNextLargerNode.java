//Problem statement
//Given a generic tree and an integer n. Find and return the node with next larger element in the Tree i.e. find a node with value just greater than n.
//
//Return NULL if no node is present with value greater than n.
//
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//18
//10 3 20 30 40 2 40 50 0 0 0 0 
//Representation of Input
//
//
//Sample Output 1 :
//20
//Explanation
//In the given tree, the value which is just greater than 18 is 20.
//Sample Input 2 :
//21
//10 3 20 30 40 2 40 50 0 0 0 0 
//Sample Output 2:
//30

package tree;

public class FindNextLargerNode {
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
		if (root == null) {
			return null;
		}
		TreeNode<Integer> nextLargerNode = null;
		if (root.data > n) {
			nextLargerNode = root;
		}
		for (TreeNode<Integer> child : root.child) {
			TreeNode<Integer> nextLargerInChild = findNextLargerNode(child, n);
			if (nextLargerInChild != null) {
				if (nextLargerNode == null || nextLargerNode.data > nextLargerInChild.data) {
					nextLargerNode = nextLargerInChild;
				}
			}
		}
		return nextLargerNode;
	}
}
