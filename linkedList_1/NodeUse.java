package linkedList_1;

import java.util.Scanner;

public class NodeUse {

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

	public static void printNode(Node<Integer> node) {
		Node<Integer> temp = node;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void increment(Node<Integer> head) {
		Node<Integer> temp = head;
		while (temp != null) {
			temp.data++;
			temp = temp.next;
		}
	}

	public static int lenthLink(Node<Integer> head) {
		Node<Integer> temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public static void printIthNode(Node<Integer> head, int i) {
		if (head == null) {
			System.out.println();
			return;
		}
		Node<Integer> temp = head;
		int ptr = 0;
		while (temp != null) {
			if (ptr == i) {
				System.out.println(temp.data);
				break;
			}
			temp = temp.next;
			ptr++;
		}
	}

	public static Node<Integer> takeInput() {
		Node<Integer> head = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first node ");
		int input = sc.nextInt();

		while (input != -1) {
			Node<Integer> currNode = new Node<Integer>(input);
			// if head is null
			if (head == null) {
				// make currNode to head node
				head = currNode;
			} else {
				Node<Integer> tail = head;
				while (tail.next != null) {
					tail = tail.next;
				}
				// now tail refer to last node
				// make connection
				tail.next = currNode;
			}

			input = sc.nextInt();
		}

		return head;
	}

	public static Node<Integer> takeInput2() {
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();

		Node<Integer> head = null, tail = null;
		while (data != -1) {
			Node<Integer> currNode = new Node<Integer>(data);
			if (head == null) {
				head = currNode;
				tail = currNode;
			} else {
				tail.next = currNode;
				tail = tail.next;
//				OR tail=currNode;
			}

			data = sc.nextInt();

		}
		return head;
	}

	public static Node<Integer> insert(Node<Integer> head, int data, int pos) {
		Node<Integer> nodeToBeInserted = new Node<Integer>(data);
		
		if(pos==0) {
			nodeToBeInserted.next=head;
			head=nodeToBeInserted;
			return head;
		}
		else {
			Node<Integer> prev=head;
			int count=0;
			while(count<pos-1 &&prev!=null) {
				count++;
				prev=prev.next;
			}
			if(prev!=null) {
////				10 -> 20-> 30 -> 40 -> 50
////				temp=30 -> 40 -> 50	
				Node<Integer> temp=prev.next;
////				20-> 70
//				prev.next=nodeToBeInserted;
////				70 -> 30 -> 40 -> 50	
//				nodeToBeInserted.next=temp;
				
				nodeToBeInserted.next=temp.next;
				prev.next=nodeToBeInserted;
				
			}
			return head;
		}
		
	}
	
	public static Node<Integer> deleteNode( Node<Integer> head, int pos) {
		// Write your code here.
		if(head==null )
            return head;
        if(pos==0)
            return head.next;
        int count=0;
        Node<Integer> temp=head;
        while(temp!=null && count<pos-1)
        {
            temp=temp.next;
            count++;
        }
        if(temp==null)
            return head;
        if(temp.next!=null)
            temp.next=temp.next.next;
         
        
        return head;
	}
	public static void main(String[] args) {
		Node<Integer> node = createLinkedList();
//		increment(node);
//		printNode(node);
//		System.out.println(lenthLink(node));
//		Node<Integer> node = takeInput2();
//		printIthNode(node, 3);
//		printNode(node);
		Node<Integer> node1 = insert(node, 70, 2);
		printNode(node1);
	}

}
