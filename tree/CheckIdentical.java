//Problem statement
//Given two Generic trees, return true if they are structurally identical i.e. they are made of nodes with the same values arranged in the same way.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//10 3 20 30 40 2 40 50 0 0 0 0 
//10 3 20 30 40 2 40 50 0 0 0 0
//Sample Output 1 :
//true
//Explanation
//If we draw the tree for the above inputs, both the trees will look like this. So the answer for this is true.
//
//
//Sample Input 2 :
//10 3 20 30 40 2 40 50 0 0 0 0 
//10 3 2 30 40 2 40 50 0 0 0 0
//Sample Output 2:
//false

package tree;

public class CheckIdentical {
	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null) {
			return false;
		}
		if (!root1.data.equals(root2.data)) {
			return false;
		}
		if (root1.child.size() != root2.child.size()) {
			return false;
		}
		for (int i = 0; i < root1.child.size(); i++) {
			if (!checkIdentical(root1.child.get(i), root2.child.get(i))) {
				return false;
			}
		}
		return true;
	}
}
