//Problem statement
//Given a BST, convert it into a sorted linked list. You have to return the head of LL.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//Time Limit: 1 second
//1<=n<=10^5
//Note:
//In case if you are facing any issue to solve this problem, please prefer to use the helper function.
//Sample Input 1:
//8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//
//
//Sample Output 1:
//2 5 6 7 8 10
package bst_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
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

	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		LinkedListNode<Integer> head = ConstructLinkedListClass.constructLinkedList(root);
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

}

public class ConstructLinkedListClass {
	/*
	 * Binary Tree Node class
	 *
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
	 * right;
	 *
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */
	/*
	 * LinkedList Node Class
	 *
	 *
	 * class LinkedListNode<T> { T data; LinkedListNode<T> next;
	 *
	 * public LinkedListNode(T data) { this.data = data; } }
	 */
	public static LinkedListNode<Integer> addNode(BinaryTreeNode<Integer> currBSTNode,
			LinkedListNode<Integer> currLLNode) {
		LinkedListNode<Integer> newNode = new LinkedListNode<>(currBSTNode.data);
		currLLNode.next = newNode;
		return newNode;
	}

	public static LinkedListNode<Integer> helper(BinaryTreeNode<Integer> currBSTNode,
			LinkedListNode<Integer> currLLNode) {
		if (currBSTNode == null)
			return currLLNode;
		if (currBSTNode.left != null)
			currLLNode = helper(currBSTNode.left, currLLNode);
		currLLNode = addNode(currBSTNode, currLLNode);
		if (currBSTNode.right != null)
			currLLNode = helper(currBSTNode.right, currLLNode);
		return currLLNode;
	}

	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
		if (root == null)
			return null;
		LinkedListNode<Integer> head = new LinkedListNode<>(root.data);
		helper(root, head);
		return head.next;
	}
}


