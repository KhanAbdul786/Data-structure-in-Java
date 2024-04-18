//Problem statement
//Given a generic tree, print the input tree in level wise order. That is, print the elements at same level in one line (separated by space). Print different levels in different lines.
//
//
//
//The output for the above tree should be 
//10
//20 30 40
//40 50
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input :
//10 3 20 30 40 2 40 50 0 0 0 0 
//Sample Output :
//10
//20 30 40 
//40 50

package tree;

import queues.QueueEmptyException;
import queues.QueueUsingLL;

public class PrintLevelWise {
	public static void printLevelWise(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		QueueUsingLL<TreeNode<Integer>> q = new QueueUsingLL<TreeNode<Integer>>();
		TreeNode<Integer> nullNode = new TreeNode<Integer>(Integer.MIN_VALUE);
		q.enqueue(root);
		q.enqueue(nullNode);
		System.out.println(root.data);
		while (q.size() != 1) {
			TreeNode<Integer> temp = null;
			try {
				temp = q.dequeue();
			} catch (QueueEmptyException e) {
			}
			if (temp == nullNode) {
				q.enqueue(nullNode);
				System.out.println();
				continue;
			}
			for (int i = 0; i < temp.child.size(); ++i) {
				System.out.print(temp.child.get(i).data + " ");
				q.enqueue(temp.child.get(i));
			}
		}
	}
}
	
	//Another ways
	
//	public static void printLevelWise(TreeNode<Integer> root){
//		/* Your class should be named Solution 
// 		 * Don't write main(). 
//		 * Don't read input, it is passed as function argument. 
//		 * Print output and don't return it. 
//		 * Taking input is handled automatically. 
//		 */
//        
//        Queue<TreeNode<Integer>> q = new LinkedList<>();
//        if(root == null)
//            return;
//        q.add(root);
//        q.add(null);
//        
//        while(!q.isEmpty()){
//            TreeNode<Integer> node = q.poll();
//            if(node != null)
//            {
//                System.out.print(node.data + " ");
//                for(int i=0; i<node.children.size(); i++)
//                    q.add(node.children.get(i));
//            }
//            else{
//                System.out.println();
//                if(!q.isEmpty())
//                    q.add(null);
//            }
//        }
//
//	}
//}
