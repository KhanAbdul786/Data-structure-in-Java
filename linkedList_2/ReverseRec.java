//Problem statement
//Given a singly linked list of integers, reverse it using recursion and return the head to the modified list. You have to do this in O(N) time complexity where N is the size of the linked list.
//
// Note :
//No need to print the list, it has already been taken care. Only return the new head to the list.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//1
//1 2 3 4 5 6 7 8 -1
//Sample Output 1 :
//8 7 6 5 4 3 2 1
//Sample Input 2 :
//2
//10 -1
//10 20 30 40 50 -1
//Sample Output 2 :
//10 
//50 40 30 20 10 


package linkedList_2;

import linkedList_1.Node;

public class ReverseRec {
	public static Node<Integer> reverseRec(Node<Integer> head) {
		// Your code goes here
		if (head == null || head.next == null) {
			return head;
		}

		Node<Integer> smallerHead = reverseRec(head.next);
		Node<Integer> node = smallerHead;
		while (node.next != null) {
			node = node.next;
		}
		node.next = head;
		head.next = null;
		return smallerHead;

	}
	
	public static void main(String[] args) {
		Node<Integer> node = NodeUse2.createLinkedList();
		reverseRec(node);
//		NodeUse2.printRecursive(node);
	}
}
