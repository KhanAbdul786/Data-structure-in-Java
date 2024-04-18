//Problem statement
//You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.
//
//Time complexity should be O(nlogk) and space complexity should be not more than O(k).
//
//Order of elements in the output is not important.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input :
//13
//2 12 9 16 10 5 3 20 25 11 1 8 6 
//4
//Sample Output :
//12
//16
//20
//25

package prioritiesQueues_2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KkLargest {

	public static ArrayList<Integer> kLargest(int input[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < k; i++) {
			pq.add(input[i]);
		}
		for (int i = k; i < input.length; i++) {
			if (input[i] > pq.peek()) {
				pq.poll();
				pq.add(input[i]);
			}
		}
		ArrayList<Integer> output = new ArrayList<Integer>();
		while (!pq.isEmpty()) {
			output.add(pq.poll());
		}
		return output;
	}
}
