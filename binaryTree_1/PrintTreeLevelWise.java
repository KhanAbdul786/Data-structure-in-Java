//Problem statement
//For a given a Binary Tree of type integer, print the complete information of every node, when traversed in a level-order fashion.
//
//To print the information of a node with data D, you need to follow the exact format :
//
//           D:L:X,R:Y
//
//Where D is the data of a node present in the binary tree. 
//X and Y are the values of the left(L) and right(R) child of the node.
//Print -1 if the child doesn't exist.
//Example:
//alt text
//
//For the above depicted Binary Tree, the level order travel will be printed as followed:
//
//1:L:2,R:3
//2:L:4,R:-1
//3:L:5,R:6
//4:L:-1,R:7
//5:L:-1,R:-1    
//6:L:-1,R:-1
//7:L:-1,R:-1
//
//Note: There is no space in between while printing the information for each node.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec
//Sample Input 1:
//8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
// Sample Output 1:
//8:L:3,R:10
//3:L:1,R:6
//10:L:-1,R:14
//1:L:-1,R:-1
//6:L:4,R:7
//14:L:13,R:-1
//4:L:-1,R:-1
//7:L:-1,R:-1
//13:L:-1,R:-1
//Sample Input 2:
//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
// Sample Output 2:
//1:L:2,R:3
//2:L:4,R:5
//3:L:6,R:7
//4:L:-1,R:-1
//5:L:-1,R:-1
//6:L:-1,R:-1
//7:L:-1,R:-1

package binaryTree_1;
/*

Following is the structure used to represent the Binary Tree Node

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

*/
import java.util.Queue;
import java.util.LinkedList;
public class PrintTreeLevelWise {
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if (root == null) {
			return;
		}
		Queue<Integer> que=new LinkedList<Integer>();
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = queue.poll();
			System.out.print(frontNode.data + ":");
			if (frontNode.left != null) {
				System.out.print("L:" + frontNode.left.data + ",");
				queue.add(frontNode.left);

			} else {
				System.out.print("L:" + -1 + ",");
			}
			if (frontNode.right != null) {
				System.out.print("R:" + frontNode.right.data);
				queue.add(frontNode.right);
			} else {
				System.out.print("R:" + -1);
			}
			System.out.println();
		}
	}
	
	//Program to count nodes in Binary Tree
	public static int countNodes(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0; 
		}
		int ans = 1;
		ans += countNodes(root.left);
		ans += countNodes(root.right);
		return ans;
	}
}
