//Problem statement
//You have been given a singly linked list of integers along with two integers, 'i,' and 'j.' Swap the nodes that are present at the 'i-th' and 'j-th' positions and return the new head to the list.
//
//Note :
//1. Remember, You need to swap the nodes, not only the data.
//2. Indexing starts from 0.
//3. No need to print the list, it has already been taken care.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= t <= 10^2
//0 <= M <= 10^5
//Where M is the size of the singly linked list.
//0 <= i < M
//0 <= j < M
//
//Time Limit: 1sec
//Sample Input 1 :
//1
//3 4 5 2 6 1 9 -1
//3 4
//Sample Output 1 :
//3 4 5 6 2 1 9 
// Sample Input 2 :
//2
//10 20 30 40 -1
//1 2
//70 80 90 25 65 85 90 -1
//0 6
// Sample Output 2 :
//10 30 20 40 
//90 80 90 25 65 85 70 


package linkedList_2;

import linkedList_1.Node;

public class SwapNodes {

	public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
		if (i == j) {
			return head;
		}
		Node<Integer> currentNode = head, prev = null;
		Node<Integer> firstNode = null, secondNode = null, firstNodePrev = null, secondNodePrev = null;
		int pos = 0;
		while (currentNode != null) {
			if (pos == i) {
				firstNodePrev = prev;
				firstNode = currentNode;
			} else if (pos == j) {
				secondNodePrev = prev;
				secondNode = currentNode;
			}
			prev = currentNode;
			currentNode = currentNode.next;
			pos += 1;
		}
		if (firstNodePrev != null) {
			firstNodePrev.next = secondNode;
		} else {
			head = secondNode;
		}
		if (secondNodePrev != null) {
			secondNodePrev.next = firstNode;
		} else {
			head = firstNode;
		}
		Node<Integer> currentfirstNode = secondNode.next;
		secondNode.next = firstNode.next;
		firstNode.next = currentfirstNode;
		return head;
	}

}
