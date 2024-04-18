//Problem statement
//You are given an array of unique integers that contain numbers in random order. You have to find the longest possible sequence of consecutive numbers using the numbers from given array.
//
//You need to return the output array which contains starting and ending element. If the length of the longest possible sequence is one, then the output array must contain only single element.
//
//Note:
//1. Best solution takes O(n) time.
//2. If two sequences are of equal length, then return the sequence starting with the number whose occurrence is earlier in the array.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= n <= 10^6
//Time Limit: 1 sec
//Sample Input 1 :
//13
//2 12 9 16 10 5 3 20 25 11 1 8 6 
//Sample Output 1 :
//8 12 
//Explanation:The longest consecutive sequence here is [8, 9, 10, 11, 12]. So the output is the start and end of this sequence: [8, 12].
//Sample Input 2 :
//7
//3 7 2 1 9 8 41
//Sample Output 2 :
//7 9
//Explanation:There are two sequences of equal length here: [1,2,3] and [7,8,9]. But since [7,8,9] appears first in the array (7 comes before 1), we return this sequence. So the output is [7,9].
//Sample Input 3 :
//7
//15 24 23 12 19 11 16
//Sample Output 3 :
//15 16

package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveIncreasingSequence {
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		Map<Integer, Boolean> vis = new HashMap<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			map.put(num, i);
			if (!vis.containsKey(num)) {
				vis.put(num, false);
			}
		}
		ArrayList<Integer> ls = new ArrayList<>();
		int globalMaxSequenceLength = 1;
		int globalMinStartIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			int currentMinStartIndex = i;
			int count = 0;
			int tempNum = num;
			// Forward
			while (vis.containsKey(tempNum) && !vis.get(tempNum)) {
				vis.put(tempNum, true); 
				// Mark Visited elements in the array as

				count++;
				tempNum++;
			}
			// Backward
			tempNum = num - 1;
			while (vis.containsKey(tempNum) && !vis.get(tempNum)) {
				vis.put(tempNum, true); 
				// Mark Visited elements in the array as

				count++;
				currentMinStartIndex = map.get(tempNum);
				tempNum--;
			}
			if (count > globalMaxSequenceLength) {
				globalMaxSequenceLength = count;
				globalMinStartIndex = currentMinStartIndex;
			} else if (count == globalMaxSequenceLength) {
				if (currentMinStartIndex < globalMinStartIndex) {
					globalMinStartIndex = currentMinStartIndex;
				}
			}

		}
		int globalStartNum = arr[globalMinStartIndex];
		ls.add(globalStartNum);
		if (globalMaxSequenceLength > 1) {
			ls.add(globalStartNum + globalMaxSequenceLength - 1);
		}
		return ls;
	}
}
