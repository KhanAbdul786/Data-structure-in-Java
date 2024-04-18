//Problem statement
//Given a Binary Search Tree and two integers k1 and k2, find and print the elements which are in range k1 and k2 (both inclusive).
//
//Print the elements in increasing order.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//Time Limit: 1 second
//Sample Input 1:
//8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//6 10
//Sample Output 1:
//6 7 8 10

package bst_1;

import binaryTree_1.BinaryTreeNode;

public class ElementsInRangeK1K2 {
	
	//ninjas type
	public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2) {
		if (root == null) {
			return;
		}
		if (root.data >= k1 && root.data <= k2) {
			elementsInRangeK1K2(root.left, k1, k2);
			System.out.print(root.data + " ");
			elementsInRangeK1K2(root.right, k1, k2);
		} else if (root.data < k1) {
			elementsInRangeK1K2(root.right, k1, k2);
		} else if (root.data > k2) {
			elementsInRangeK1K2(root.left, k1, k2);
		}
		
		
//		OR
//		if (root.data <k1) {
//			elementsInRangeK1K2(root.right, k1, k2);;
//		} else if (root.data > k1) {
//			elementsInRangeK1K2(root.left, k1, k2);
//		} else  {
//			System.out.println(root.data+" ");
//			elementsInRangeK1K2(root.left, k1, k2);
//			elementsInRangeK1K2(root.right, k1, k2);
//		}
		
	}
}




//Non nijas type
//import java.util.*;
//public class Solution {
//
//	/*	Binary Tree Node class 
//	 * 
//	 * 	class BinaryTreeNode<T> {
//			T data;
//			BinaryTreeNode<T> left;
//			BinaryTreeNode<T> right;
//			
//			public BinaryTreeNode(T data) {
//				this.data = data;
//			}
//		}
//		*/
//		
//		private static ArrayList<Integer> arr = new ArrayList<Integer>();
//    
//        public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2)
//        {
//            elementsInRangeK1K2Helper(root,k1,k2);
//            Collections.sort(arr);
//            for (int i:arr)
//                System.out.print(i+" ");
//        }
//		public static void elementsInRangeK1K2Helper(BinaryTreeNode<Integer> root,int k1,int k2){
//            
//            //Base case - if root=null
//            if (root==null)
//                return;
//            
//            int rootData=root.data;
//            if (rootData<k1)
//            {
//                elementsInRangeK1K2Helper(root.right,k1,k2);
//            }
//            else if (rootData>k2)
//            {
//                elementsInRangeK1K2Helper(root.left,k1,k2);
//            }
//            else
//            {
//                //System.out.print(rootData+" ");
//                arr.add(rootData);
//                elementsInRangeK1K2Helper(root.right,k1,k2);
//                elementsInRangeK1K2Helper(root.left,k1,k2);
//            }
//			
//		}
//		
//		
//	}