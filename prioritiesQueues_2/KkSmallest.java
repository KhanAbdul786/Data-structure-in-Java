//Problem statement
//You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k smallest numbers from given array. You need to save them in an array and return it.
//
//Time complexity should be O(n * logk) and space complexity should not be more than O(k).
//
//Note: Order of elements in the output is not important.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//Time Limit: 1 sec
//Sample Input 1 :
//13
//2 12 9 16 10 5 3 20 25 11 1 8 6 
//4
//Sample Output 1 :
//1 2 3 5 

package prioritiesQueues_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KkSmallest {
	public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
		// Making a max PQ
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			pq.add(input[i]);
		}
		for (int i = k; i < n; i++) {
			if (input[i] < pq.peek()) {
				pq.poll();
				pq.add(input[i]);
			}
		}
		ArrayList<Integer> output = new ArrayList<>();
		while (!pq.isEmpty()) {
			output.add(pq.poll());
		}
		return output;
	}
}
