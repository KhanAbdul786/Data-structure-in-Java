//Problem statement
//For a given queue containing all integer data, reverse the first K elements.
//
//You have been required to make the desired change in the input queue itself.
//
//Example:
//alt txt
//
//For the above input queue, if K = 4 then after reversing the first 4 elements, the queue will be updated as:
//alt txt
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= N <= 10^6
//1 <= K <= N
//-2^31 <= data <= 2^31 - 1
//
// Time Limit: 1sec
//Sample Input 1:
//5 3
//1 2 3 4 5
//Sample Output 1:
//3 2 1 4 5
//Sample Input 2:
//7 7
//3 4 2 5 6 7 8
//Sample Output 2:
//8 7 6 5 2 4 3


package queues;

import java.util.Queue;
import java.util.Stack;

public class ReverseKElements {
	public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
		if (input.isEmpty() || k > input.size()) {
			return input;
		}
		if (k <= 0) {
			return input;
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < k; i++) {
			stack.push(input.poll());
		}
		while (!stack.isEmpty()) {
			input.add((stack.pop()));
		}
		for (int i = 0; i < input.size() - k; i++) {
			input.add(input.poll());
		}
		return input;
	}
}
