package queues;

import linkedList_1.Node;

public class QueueUsingLL<T> {
	private Node<T> front;
	private Node<T> rear;
	private int size;

	public QueueUsingLL() {
		front = null;
		rear = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void enqueue(T elem) {

		Node<T> newNode = new Node<>(elem);
		if (front == null) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode; // rear=rear.next;
		}
		size++;
	}

	public T front() throws QueueEmptyException {
		if (front == null) {
			throw new QueueEmptyException();
		}
		return front.data;
	}

	public T dequeue() throws QueueEmptyException {
		if (front == null) {
			throw new QueueEmptyException();
		}
		T temp = front.data;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		size--;
		return temp;

	}
}

//public class Queue {
//	private Node head;
//	private Node tail;
//	private int size;
//
//	public Queue() {
//		this.head = null;
//		this.tail = null;
//		this.size = 0;
//	}
//
//	public int getSize() {
//		return this.size;
//	}
//
//	public boolean isEmpty() {
//		return this.size == 0;
//	}
//
//	public void enqueue(int data) {
//		this.size += 1;
//		Node newNode = new Node(data);
//		if (head == null) {
//			this.head = newNode;
//			this.tail = newNode;
//			return;
//		}
//		this.tail.next = newNode;
//		this.tail = newNode;
//	}
//
//	public int dequeue() {
//		if (this.isEmpty()) {
//			return -1;
//		}
//		int ans = this.head.data;
//		this.head = this.head.next;
//		this.size -= 1;
//		return ans;
//	}
//
//	public int front() {
//		if (this.isEmpty()) {
//			return -1;
//		}
//		return this.head.data;
//	}
//}
