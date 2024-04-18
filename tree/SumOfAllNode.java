//Problem statement
//Given a generic tree, count and return the sum of all nodes present in the given tree.
//
//
//
//For the above tree , total sum of all nodes is 10 + 30 + 50 + 25 + 5 + 45 + 56 + 34 = 225
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input :
//10 3 20 30 40 2 40 50 0 0 0 0 
//Sample Output :
//190
//Explananation
//For 10, 3 children are there : 20, 30, 40
//For 20. 2 children are there : 40, 50
//For 30, 40, 40, 50 no child is there , so the answer for this is 10+20+30+40+40+50 = 190


package tree;

public class SumOfAllNode {
	public static int sumOfAllNode(TreeNode<Integer> root){
		if(root == null) {
			return Integer.MIN_VALUE;
			}
			int total = 0;
			for(int i=0;i<root.child.size();++i) {
			total+=sumOfAllNode(root.child.get(i));
			}
			return root.data+total;
	}
	
}
