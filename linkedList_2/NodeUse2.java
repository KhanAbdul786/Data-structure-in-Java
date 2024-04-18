package linkedList_2;

import linkedList_1.Node;

class DoubleNode {
	Node<Integer> head;
	Node<Integer> tail;

	public DoubleNode() {
		// TODO Auto-generated constructor stub
	}

	public DoubleNode(Node<Integer> head, Node<Integer> tail) {
		this.head = head;
		this.tail = tail;
	}
}

public class NodeUse2 {

	public static Node<Integer> createLinkedList() {
		Node<Integer> node = new Node<Integer>(10);
		Node<Integer> node1 = new Node<Integer>(20);
		Node<Integer> node2 = new Node<Integer>(30);
		Node<Integer> node3 = new Node<Integer>(40);
		Node<Integer> node4 = new Node<Integer>(50);

		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		return node;
	}

	public static Node<Integer> createLinkedList2() {
		Node<Integer> node3 = new Node<Integer>(40);
		Node<Integer> node4 = new Node<Integer>(50);

		node3.next = node4;
		return node3;
	}

	public static void printRecursive(Node<Integer> head) {
		if (head == null) {
			return;
		}
		System.out.print(head.data + " ");
		printRecursive(head.next);

	}

	public static Node<Integer> inserAtPos(Node<Integer> head, int data, int pos) {
		if (head == null && pos > 0) {
			return head;
		}
		Node<Integer> newNod = new Node<Integer>(data);
		if (pos == 0) {
			newNod.next = head;
//			head = newNod;
			System.out.println(newNod.data);
			System.out.println(newNod.next.data);
			return newNod;
		} else {
			Node<Integer> smallerHead = inserAtPos(head.next, data, pos - 1);
			System.out.println(smallerHead.data);
			System.out.println(smallerHead.next.data);
			head.next = smallerHead;
			return head;
		}
	}

	public static Node<Integer> deleteNodeRec(Node<Integer> head, int pos) {
		if (head == null && pos > 0) {
			return head;
		}
		if (pos == 0) {
			head = head.next;
			return head;
		}
		Node<Integer> smaller = deleteNodeRec(head.next, pos - 1);
		head.next = smaller;
		return head;
	}

	public static Node<Integer> reverseLLRC(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node<Integer> smaller = reverseLLRC(head.next);
		Node<Integer> node = smaller;
		while (node.next != null) {
			node = node.next;
		}
		node.next = head;
		head.next = null;
		return smaller;
	}

	public static DoubleNode reverseBetter(Node<Integer> head) {
		DoubleNode ans = null;
		if (head == null || head.next == null) {
			ans = new DoubleNode(head, head);
//			ans.head = head;
//			ans.tail = head;
			return ans;
		}
		DoubleNode smallAns = reverseBetter(head.next);
		smallAns.tail.next = head;
		head.next = null;
		ans = new DoubleNode();
		ans.head = smallAns.head;
		ans.tail = head;
		return ans;
	}

	public static Node<Integer> reverseBetter1(Node<Integer> head) {
		DoubleNode ans = reverseBetter(head);
		return ans.head;
	}

	public static Node<Integer> reverseBest(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node<Integer> smallerHead = reverseBest(head.next);
		Node<Integer> reverTail = head.next;
		reverTail.next = head;
		head.next = null;
		return smallerHead;
	}

	public static Node<Integer> midPoint(Node<Integer> head) {
		if (head == null) {
			return head;
		}

		Node<Integer> slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static Node<Integer> mergeTwoSorteds(Node<Integer> head1, Node<Integer> head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		Node<Integer> newHead = null, newTail = null;
		if (head1.data < head2.data) {
			newHead = head1;
			newTail = head1;
			head1 = head1.next;
		} else {
			newHead = head2;
			newTail = head2;
			head2 = head2.next;
		}
		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				newTail.next = head1;
				newTail = newTail.next;
				head1 = head1.next;
			} else {
				newTail.next = head2;
				newTail = newTail.next;
				head2 = head2.next;
			}
		}
		if (head1 != null) {
			newTail.next = head1;
		}
		if (head2 != null) {
			newTail.next = head2;
		}
		return newHead;
	}

	public static void main(String[] args) {
		Node<Integer> node1 = createLinkedList();
//		Node<Integer> node1 = deleteNodeRec(node,3);
//		printRecursive(node1);
//		DoubleNode node1 = reverseBetter(node);
//		printRecursive(node1.head);
//		Node<Integer> node1 = reverseBetter1(node);
//		printRecursive(node1);
//		Node<Integer> node1 = reverseBest(node);
//		printRecursive(node1);
//		Node<Integer> node1 = midPoint(node);
//		System.out.println(node1.data);
		Node<Integer> node2 = createLinkedList();
		Node<Integer> head = mergeTwoSorteds(node1, node2);
		printRecursive(head);

	}

}
