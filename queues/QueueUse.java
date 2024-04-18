package queues;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueUse {

	public static void main(String[] args) throws QueueEmptyException {
//		QueueUsingArray q1 = new QueueUsingArray();
		QueueUsingLL q1 = new QueueUsingLL();
		
		Queue<Integer> q=new PriorityQueue<>();
		
		
		int[] arr= {10,20,30,40};
		
		for (int i = 0; i < arr.length; i++) {
			q1.enqueue(arr[i]);
		}
		
		System.out.println(q1.size());
		System.out.println(q1.isEmpty());
		System.out.println(q1.dequeue());
		System.out.println(q1.size());

	}

}
