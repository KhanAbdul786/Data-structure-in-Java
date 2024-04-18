//Problem statement
//You have been given a singly linked list of integers. Write a function that returns the index/position of integer data denoted by 'N' (if it exists). Return -1 otherwise.
//
//Note :
//Assume that the Indexing for the singly linked list always starts from 0.
//Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
//1 <= T <= 10^2
//0 <= M <= 10^5
//
//Where 'M' is the size of the singly linked list.
//
//Time Limit: 1 sec
//Sample Input 1 :
//2
//3 4 5 2 6 1 9 -1
//5
//10 20 30 40 50 60 70 -1
//6
//Sample Output 1 :
//2
//-1
// Explanation for Sample Output 1:
//In test case 1, 'N' = 5 appears at position 2 (0-based indexing) in the given linked list.
//
//In test case 2, we can see that 'N' = 6 is not present in the given linked list.
//Sample Input 2 :
//2
//1 -1
//2
//3 4 5 2 6 1 9 -1
//6
//Sample Output 2 :
//-1
//4
// Explanation for Sample Output 2:
//In test case 1, we can see that 'N' = 2 is not present in the given linked list.
//
//In test case 2, 'N' = 6 appears at position 4 (0-based indexing) in the given linked list.

package linkedList_1;

public class FindNode {
	public static int findNode(Node<Integer> head, int n) {
		// Write your code here.
		if(head==null)
            return -1;
        Node<Integer> temp=head;
        int count=0;
        while(temp!=null && temp.data!=n)
        {
            temp=temp.next;
            count++;
        }
        if(temp!=null)
            return count;
        else
            return -1;
	}
	
//	Ninjas method
	
//	public static int findNode(Node<Integer> head, int n) {
//		// Variable to maintain the position in the list.
//		int pos = 0;
//		while(head != null) {
//		// If element found, return the position of the element.
//		if(head.data.equals(n)) {
//		return pos;
//		}
//		head = head.next;
//		pos++;
//		}
//		return -1;
//		}

}
