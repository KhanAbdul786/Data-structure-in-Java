//Problem statement
//Implement the function RemoveMin for the min priority queue class.
//
//For a minimum priority queue, write the function for removing the minimum element present. Remove and return the minimum element.
//
//Note : main function is given for your reference which we are using internally to test the code.
package priorityQuesues_1;

import java.util.ArrayList;

public class Priority_queue<T> {
	ArrayList<Element<T>> heap;

	public Priority_queue() {
		heap = new ArrayList<>();
	}

	public void insert(T value, int priority) {
		Element<T> e = new Element<>(value, priority);
		heap.add(e);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;
		while (childIndex > 0) {
			if (heap.get(childIndex).priority < heap.get(parentIndex).priority) {
				Element temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;

			} else {
				return;
			}
		}

	}

	public T getMin() throws PriorityQueueException {
		if (isEmpty()) {
			throw new PriorityQueueException();
		}
		return heap.get(0).value;
	}

	public int removeMin() throws PriorityQueueException {
		if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
		int ans = heap.get(0).priority;
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		// Heapify-Down
		int index = 0;
		int minIndex = index;
		int leftChildIndex = 1;
		int rightChildIndex = 2;

		while (leftChildIndex < heap.size()) {
			if (heap.get(leftChildIndex).priority < heap.get(minIndex).priority) {
				minIndex = leftChildIndex;
			}
			if (rightChildIndex < heap.size() && heap.get(rightChildIndex).priority < heap.get(minIndex).priority) {
				minIndex = rightChildIndex;
			}
			if (minIndex == index) {
				break;
			} else {
				Element<T> temp = heap.get(index);
				heap.set(index, heap.get(minIndex));
				heap.set(minIndex, temp);
				index = minIndex;
				leftChildIndex = 2 * index + 1;
				rightChildIndex = 2 * index + 2;
			}
		}
		return ans;
	}

	

	public int size() {
		return heap.size();
	}

	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}
}
