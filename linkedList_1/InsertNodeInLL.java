//Problem statement
//You have been given a singly linked list of integers, an integer value called 'data' and a position with the name 'pos.'
//
// Write a function to add a node to the list with the 'data' at the specified position, 'pos.'
//
//Note :
//Assume that the Indexing for the singly linked list always starts from 0.
//
//If the position is greater than the length of the singly linked list, you should return the same linked list without any change.
// Illustration :
//The following images depict how the insertion has been taken place.
//Image-I :
//
//Alt txt
//
//Image-II :
//
//Alt txt
//
//Image-III :
//
//Alt txt
//
//Image-IV :
//
//Alt txt
//
//Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
//1 <= t <= 10^2
//0 <= N <= 10^5
//pos >= 0
//Time Limit: 1sec
//Sample Input 1 :
//1
//3 4 5 2 6 1 9 -1
//3 100
//Sample Output 1 :
//3 4 5 100 2 6 1 9
//Sample Input 2 :
//2
//3 4 5 2 6 1 9 -1
//0 20
//10 98 7 66 8 -1
//5 99
//Sample Output 2 :
//20 3 4 5 2 6 1 9
//10 98 7 66 8 99 

package linkedList_1;

public class InsertNodeInLL {
	public static Node<Integer> insert(Node<Integer> head, int pos, int data) {
		int currPos = 0;
		Node<Integer> newNode = new Node<Integer>(data);
		if (pos == 0) {
			newNode.next = head;
			head = newNode;
			return head;
		}
		Node<Integer> temp = head;
		while (temp != null && currPos < (pos - 1)) {
			temp = temp.next;
			currPos++;
		}
		if (temp == null) {
			return head;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}

}
