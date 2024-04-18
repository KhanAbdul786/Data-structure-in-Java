//Problem statement
//For a given singly linked list of integers, arrange the nodes such that all the even number nodes are placed after the all odd number nodes. The relative order of the odd and even terms should remain unchanged.
//
//Note :
//1. No need to print the linked list, it has already been taken care. Only return the new head to the list.
//2. Don't create a new linked list.
//3.  Just change the data, instead rearrange the provided list.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= t <= 10^2
//0 <= M <= 10^5
//Where M is the size of the singly linked list.
//
//Time Limit: 1sec
//Sample Input 1 :
//1
//1 4 5 2 -1
//Sample Output 1 :
//1 5 4 2 
//Sample Input 2 :
//2
//1 11 3 6 8 0 9 -1
//10 20 30 40 -1
//Sample Output 2 :
//1 11 3 9 6 8 0
//10 20 30 40


package linkedList_2;

import linkedList_1.Node;

public class EvenAfterOdd {
	public static Node<Integer> evenAfterOdd(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node<Integer> node = head, evenNode = null, evenHead = null, oddNode = null, OddHead = null;
		while (node != null) {
			int data = node.data;
			if (data % 2 == 0) {
				if (evenNode == null) {
					evenNode = node;
					evenHead = node;
				} else {
					evenNode.next = node;
					evenNode = evenNode.next;
				}
			} else {
				if (oddNode == null) {
					oddNode = node;
					OddHead = head;
				} else {
					oddNode.next = node;
					oddNode = oddNode.next;
				}
			}
			node = node.next;
		}
		if (OddHead == null) {
			return evenHead;
		} else {
			oddNode.next = evenHead;
		}

		if (evenNode != null) {
			evenNode.next = null;
		}

		return OddHead;

	}
}
