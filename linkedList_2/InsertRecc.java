package linkedList_2;

import linkedList_1.Node;

public class InsertRecc {
	public static Node<Integer> inserAtPos(Node<Integer> head, int data, int pos) {
		//pos>0 mean inserting null at zero position
		if (head == null && pos > 0) {
			return head;
		}
		Node<Integer> newNod = new Node<Integer>(data);
		if (pos == 0) {
			newNod.next = head;
			head = newNod;
			return head;
		} else {
			Node<Integer> smallerHead = inserAtPos(head.next, data, pos - 1);
			head.next = smallerHead;
			return head;
		}
	}
}
