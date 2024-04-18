//Problem statement
//In a given Generic Tree, replace each node with its depth value. You need to just update the data of each node, no need to return or print anything. Depth of a node is defined as the distance of the node from root. You may assume that depth of root node is 0.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//10 3 20 30 40 2 40 50 0 0 0 0 
//Representation of Input:
//
//
//Sample Output 1 : (Level wise, each level in new line)
//0 
//1 1 1 
//2 2
//Explanation
//Since root is 10 , so it's depth is 0
//Node 20, 30 , 40 are present at 1st level , so their depth is 1.
//Node 40,50 are present at 2nd level, so their depth is 2.

package tree;

public class ReplaceWithDepthValue {
	public static void replaceWithDepthValue(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		replaceWithDepthValue(root, 0);
	}

	public static void replaceWithDepthValue(TreeNode<Integer> root, int depth) {
		root.data = depth;
		for (TreeNode<Integer> child : root.child) {
			replaceWithDepthValue(child, depth + 1);
		}
	}
}
