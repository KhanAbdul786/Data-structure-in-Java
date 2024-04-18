//Problem statement
//For a given Binary Tree of type integer and a number X, find whether a node exists in the tree with data X or not.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^5
//
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec.
//Sample Input 1:
//8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
//7
//Sample Output 1:
//true
//Explanation For Output 1:
//Clearly, we can see that 7 is present in the tree. So, the output will be true.
//Sample Input 2:
//2 3 4 -1 -1 -1 -1
//10
//Sample Output 2:
//false

package binaryTree_1;

public class IsNodePresent {
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
		if (root == null) {
			return false;
		}
		if (root.data.equals(x)) {
			return true;
		}
		return (isNodePresent(root.left, x) || isNodePresent(root.right, x));
		
		
//		OR
		
//		if (root==null)
//        {
//            return false;
//        }
//        
//        if (root.data==x)
//        {
//            return true;
//        }
//        else
//        {
//            return (isNodePresent(root.left,x)||isNodePresent(root.right,x));
//        }
	}
}
