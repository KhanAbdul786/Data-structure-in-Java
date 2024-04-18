//Problem statement
//You are given an array of integers that contain numbers in random order. Write a program to find and return the number which occurs the maximum times in the given input.
//
//If two or more elements are having the maximum frequency, return the element which occurs in the array first.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//0 <= N <= 10^8
//Time Limit: 1 sec
//Sample Input 1 :
//13
//2 12 2 11 12 2 1 2 2 11 12 2 6 
//Sample Output 1 :
//2
//Sample Input 2 :
//6
//7 2 2 4 8 4
//Sample Output 2 :
//2

package hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxFrequencyNumber {
	public static int maxFrequencyNumber(int[] arr) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (hm.containsKey(arr[i])) {
				hm.put(arr[i], hm.get(arr[i]) + 1);
			} else {
				hm.put(arr[i], 1);
			}
		}
		int maxCount = Integer.MIN_VALUE, maxEle = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (hm.get(arr[i]) > maxCount) {
				maxCount = hm.get(arr[i]);
				maxEle = arr[i];
			}
		}
		return maxEle;

	}

	/// usinf foreach looop

	public static int maxFrequencyNumberr(int[] arr) {
		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Return output and don't print it. Taking
		 * input and printing output is handled automatically.
		 */
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if (hm.containsKey(i)) {
				hm.put(i, hm.get(i) + 1);
			} else {
				hm.put(i, 1);
			}
		}
		int max = 0, ans = Integer.MIN_VALUE;
		for (int i : arr) {
			if (hm.get(i) > max) {
				max = hm.get(i);
				ans = i;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 2, 5, 7, 5, 4, 3, 3, 7, 2, 9 };

		System.out.println(maxFrequencyNumber(arr));

	}

}
