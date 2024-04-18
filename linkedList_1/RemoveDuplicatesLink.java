//Problem statement
//You have been given a singly linked list of integers where the elements are sorted in ascending order. Write a function that removes the consecutive duplicate values such that the given list only contains unique elements and returns the head to the updated list.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= t <= 10^2
//0 <= M <= 10^5
//Time Limit: 1sec
//
//Where 'M' is the size of the singly linked list.
// Remember/Consider :
//While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
//Sample Input 1 :
//1
//1 2 3 3 3 3 4 4 4 5 5 7 -1
//Sample Output 1 :
//1 2 3 4 5 7 
//Sample Input 2 :
//2
//10 20 30 40 50 -1
//10 10 10 10 -1
//Sample Output 2 :
//10 20 30 40 50
//10

package linkedList_1;

public class RemoveDuplicatesLink {
	public static Node<Integer> removeDuplicates(Node<Integer> head) {
		// Your code goes here
		if (head == null)
			return head;
		if (head.next == null)
			return head;
		Node<Integer> t1 = head, t2 = head.next;
		Node<Integer> finalhead = head;
		while (t2 != null) {
			if (t1.data.equals(t2.data)) {
				t2 = t2.next;
			} else {
				t1.next = t2;
				t1 = t2;
			}
		}

		t1.next = null;
		return finalhead;
	}
	
	//Ninjas method

//	public static Node<Integer> removeDuplicates(Node<Integer> head) {
//		if (head == null) {
//			return head;
//		}
//		Node<Integer> currHead = head;
//		while (currHead.next != null) {
//			if (currHead.data.equals(currHead.next.data)) {
//				currHead.next = currHead.next.next;
//			} else {
//				currHead = currHead.next;
//			}
//		}
//		return head;
//	}
}
