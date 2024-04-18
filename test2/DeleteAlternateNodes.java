//Problem statement
//Given a Singly Linked List of integers, delete all the alternate nodes in the list.
//
//Example:
//List: 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> null
//Alternate nodes will be:  20, 40, and 60.
//
//Hence after deleting, the list will be:
//Output: 10 -> 30 -> 50 -> null
//Note :
//The head of the list will remain the same. Don't need to print or return anything.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//1 2 3 4 5 -1
//Sample Output 1:
//1 3 5
//Explanation of Sample Input 1:
//2, 4 are alternate nodes so we need to delete them 
//Sample Input 2:
//10 20 30 40 50 60 70 -1
//Sample Output 2:
//10 30 50 70 


package test2;

import linkedList_1.Node;

public class DeleteAlternateNodes {
	/*
	 * Time complexity: O(N) Space complexity: O(1) where N is the size of the
	 * linked list.
	 */

	public static void deleteAlternateNodes(Node<Integer> head) {
		Node<Integer> cur = head;
		Node<Integer> curNext;
		while (cur != null && cur.next != null) {
			curNext = cur.next;
			cur.next = curNext.next;
			cur = cur.next;
		}
	}
}
