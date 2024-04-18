//Problem statement
//Given a singly linked list of integers, reverse the nodes of the linked list 'k' at a time and return its modified list.
//
// 'k' is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of 'k,' then left-out nodes, in the end, should be reversed as well.
//
//Example :
//Given this linked list: 1 -> 2 -> 3 -> 4 -> 5
//
//For k = 2, you should return: 2 -> 1 -> 4 -> 3 -> 5
//
//For k = 3, you should return: 3 -> 2 -> 1 -> 5 -> 4
// Note :
//No need to print the list, it has already been taken care. Only return the new head to the list.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= t <= 10^2
//0 <= M <= 10^5
//Where M is the size of the singly linked list.
//0 <= k <= M
//
//Time Limit:  1sec
//Sample Input 1 :
//1
//1 2 3 4 5 6 7 8 9 10 -1
//4
//
//
//Sample Output 1 :
//4 3 2 1 8 7 6 5 10 9
//Sample Input 2 :
//2
//1 2 3 4 5 -1
//0
//10 20 30 40 -1
//4
//Sample Output 2 :
//1 2 3 4 5 
//40 30 20 10 


package linkedList_2;

import linkedList_1.Node;

public class KReverse {

	public static Node<Integer> kReverse(Node<Integer> head, int k) {
		if (k == 0 || k == 1) {
			return head;
		}
		Node<Integer> current = head;
		Node<Integer> fwd = null;
		Node<Integer> prev = null;
		int count = 0;
		/* Reverse first k nodes of linked list */
		while (count < k && current != null) {
			fwd = current.next;
			current.next = prev;
			prev = current;
			current = fwd;
			count++;
		}
		if (fwd != null) {
			head.next = kReverse(fwd, k);
		}
		return prev;
	}
}

//ANother ways

//private static DoubleNode reversePart(Node<Integer> head)
//{
//    if(head==null || head.next==null)
//    { DoubleNode ans=new DoubleNode();
//    ans.head=head;
//    ans.tail=head;
//    return ans;}
// 
//    DoubleNode ans=reversePart(head.next);
//    ans.tail.next=head;
//    head.next=null;
//    ans.tail=ans.tail.next;
//    return ans;
//}
//
//}
//
//class DoubleNode{
//Node<Integer> head;
//Node<Integer> tail;
//}
