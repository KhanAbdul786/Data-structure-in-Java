//Problem statement
//Given a binary tree, write code to create a separate linked list for each level. You need to return the array which contains head of each level linked list.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//Time Limit: 1 second
//Sample Input 1:
//5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
//Sample Output 1:
//5 
//6 10 
//2 3 
//9



package bst_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Time complexity: O(N)
Space complexity: O(H)
where N is the number of nodes in the input BST
and H is the height of the input BST
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class QueueEmptyException extends Exception {
}

class QueueUsingLL<T> {

	class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public T front() throws QueueEmptyException {
		if (size == 0) {
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}

		return head.data;
	}

	public void enqueue(T element) {
		Node<T> newNode = new Node<T>(element);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	public T dequeue() throws QueueEmptyException {
		if (head == null) {
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		if (head == tail) {
			tail = null;
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}
}

class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static BinaryTreeNode<Integer> takeInput() throws IOException {
		st = new StringTokenizer(br.readLine());
		int rootData = Integer.parseInt(st.nextToken());
		if (rootData == -1) {
			return null;
		}
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = Integer.parseInt(st.nextToken());
			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = Integer.parseInt(st.nextToken());
			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}

	private static void print(LinkedListNode<Integer> temp) {
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		ArrayList<LinkedListNode<Integer>> output = ConstructLinkedListForEachLevel
				.constructLinkedListForEachLevel(root);
		if (output != null) {
			for (LinkedListNode<Integer> head : output) {
				print(head);

			}
		}
	}

}

public class ConstructLinkedListForEachLevel {
	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
		pendingNodes.add(root);
		int currentLevelRemaining = 1;
		int nextLevelCount = 0;
		LinkedListNode<Integer> currentLevelHead = null;
		LinkedListNode<Integer> currentLevelTail = null;
		ArrayList<LinkedListNode<Integer>> output = new ArrayList<>();
		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			currentNode = pendingNodes.remove();
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(currentNode.data);
			if (currentLevelHead == null) {
				currentLevelHead = newNode;
				currentLevelTail = newNode;
			} else {
				currentLevelTail.next = newNode;
				currentLevelTail = newNode;
			}
			if (currentNode.left != null) {
				pendingNodes.add(currentNode.left);
				nextLevelCount++;
			}
			if (currentNode.right != null) {
				pendingNodes.add(currentNode.right);
				nextLevelCount++;
			}
			currentLevelRemaining--;
			if (currentLevelRemaining == 0) {
				output.add(currentLevelHead);
				currentLevelHead = null;
				currentLevelTail = null;
				currentLevelRemaining = nextLevelCount;
				nextLevelCount = 0;
			}
		}
		return output;
	}

}

//Non nijas type/

//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Solution {
//
//	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root) {
//		if (root == null)
//			return null;
//		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
//		ArrayList<LinkedListNode<Integer>> arrayList = new ArrayList<>();
//		queue.add(root);
//		queue.add(null);
//		LinkedListNode<Integer> head = new LinkedListNode<>(-1), tail = head;
//		while (!queue.isEmpty()) {
//			if (queue.peek() == null) {
//				arrayList.add(head.next);
//				queue.add(queue.poll());
//				if (queue.peek() == null)
//					return arrayList;
//				head = new LinkedListNode<>(-1);
//				tail = head;
//				continue;
//			}
//			if (queue.peek().left != null)
//				queue.add(queue.peek().left);
//			if (queue.peek().right != null)
//				queue.add(queue.peek().right);
//			tail.next = new LinkedListNode<>(queue.peek().data);
//			tail = tail.next;
//			queue.poll();
//		}
//		return arrayList;
//	}
//
//}