//Problem statement
//You have been given a queue that can store integers as the data. You are required to write a function that reverses the populated queue itself without using any other data structures.
//
//Example:
//Alt txt
//
//Alt txt
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= t <= 100
//1 <= N <= 10^4
//-2^31 <= data <= 2^31 - 1
//
//Time Limit: 1sec 
//Sample Input 1:
//1
//6
//1 2 3 4 5 10
//Note:
//Here, 1 is at the front and 10 is at the rear of the queue.
//Sample Output 1:
//10 5 4 3 2 1
//Sample Input 2:
//2
//5
//2 8 15 1 10
//3
//10 20 30
//Sample Output 2:
//10 1 15 8 2 
//30 20 10 
//

package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReverseQueue {
	public static void reverseQueue(Queue<Integer> input) {
		if (input.size() <= 1) {
			return;
		}
		int front = input.poll();
		reverseQueue(input);
		input.add(front);
	}

	public static void main(String[] args) {
		 Scanner sr = new Scanner(System.in);
		int t = sr.nextInt();

		while (t > 0) {
			Queue<Integer> queue = Runner.takeInput();
			reverseQueue(queue);

			while (!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}

			System.out.println();

			t -= 1;
		}
	}

}

class Runner {
	static Scanner sr = new Scanner(System.in);

	public static Queue<Integer> takeInput() {

		int n = sr.nextInt();

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			int var = sr.nextInt();
			queue.add(var);
		}

		return queue;

	}
}
