//Problem statement
//Given an array of integers, check whether it represents max-heap or not. Return true if the given array represents max-heap, else return false.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^5
//1 <= Ai <= 10^5
//Time Limit: 1 sec
//Sample Input 1:
//8
//42 20 18 6 14 11 9 4
//Sample Output 1:
//true

package prioritiesQueues_2;

public class CheckMaxHeap {
	public static boolean checkMaxHeap(int arr[]) {
		int n = arr.length;
		for (int i = 0; 2 * i + 1 < n; i++) {
			int leftChildIndex = 2 * i + 1;
			int rightChildIndex = leftChildIndex + 1;
			// if left child greater than parent then return false
			if (arr[i] < arr[leftChildIndex]) {
				return false;
			}
			// if right child exists and is greater than parent then return false
			if (rightChildIndex < n && arr[i] < arr[rightChildIndex]) {
				return false;
			}
		}
		return true;
	}
}
