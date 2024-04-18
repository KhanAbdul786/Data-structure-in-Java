//Problem statement
//Given a singly linked list of integers and position 'i', delete the node present at the 'i-th' position in the linked list recursively.
//
// Note :
//Assume that the Indexing for the linked list always starts from 0.
//
//No need to print the list, it has already been taken care. Only return the new head to the list.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= t <= 10^2
//0 <= M <= 10^5
//Where M is the size of the singly linked list.
//0 <= i < M
//
//Time Limit:  2 sec
//Sample Input 1 :
//1
//3 4 5 2 6 1 9 -1
//3
//Sample Output 1 :
//3 4 5 6 1 9
//Sample Input 2 :
//2
//30 -1
//0
//10 20 30 50 60 -1
//4
//Sample Output 2 :
//10 20 30 50 


package linkedList_2;

import linkedList_1.Node;

public class DeleteNodeRec {
	public static Node<Integer> deleteNodeRec(Node<Integer> head, int pos) {
    	//Your code goes here
        if(head==null){
            return head;
        }
        if(pos==0){
            head=head.next;
            return head;
        }
        Node<Integer> smallHead=deleteNodeRec(head.next,pos-1);
        head.next=smallHead;
        return head;
	}
}
