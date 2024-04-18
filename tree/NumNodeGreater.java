//Problem statement
//Given a tree and an integer x, find and return number of Nodes which are greater than x.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//35 10 3 20 30 40 2 40 50 0 0 0 0 
//Sample Output 1 :
//3
//Explanation
//Since x=35, the elements which are greater than 35 are 40, 40, 50, so the output for this is 3.
//Sample Input 2 :
//10 10 3 20 30 40 2 40 50 0 0 0 0 
//Sample Output 2:
//5

package tree;

public class NumNodeGreater {
	public static int numNodeGreater(TreeNode<Integer> root, int x) {
		int count = 0;
		if (root == null)
			return 0;
		if (root.data > x)
			count++;
		for (TreeNode<Integer> child : root.child) {
			count = count + numNodeGreater(child, x);
		}
		return count;
	}
}
