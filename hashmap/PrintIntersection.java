//Problem statement
//You have been given two integer arrays/lists (ARR1 and ARR2) of size N and M, respectively. You need to print their intersection; An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, when there is a common value that exists in both the arrays/lists.
//
//Note :
//Input arrays/lists can contain duplicate elements.
//
//The intersection elements printed would be in the order they appear in the second array/list (ARR2).
//
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= N <= 10^6
//0 <= M <= 10^6
//
//Time Limit: 1 sec 
//Sample Input 1 :
//6
//2 6 8 5 4 3
//4
//2 3 4 7 
//Sample Output 1 :
//2
//3 
//4
//Sample Input 2 :
//4
//2 6 1 2
//5
//1 2 3 4 2
//Sample Output 2 :
//1 
//2 
//2

package hashmap;

import java.util.HashMap;

public class PrintIntersection {
	public static void printIntersection(int[] arr1, int[] arr2) {
		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Return output and don't print it. Taking
		 * input and printing output is handled automatically.
		 */
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i : arr1) {
			// if(hm.containsKey(i)) {
			// hm.put(i, hm.get(i) + 1); }
			// else {
			// hm.put(i, 1);
			// }
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}
		for (int i = 0; i < arr2.length; i++) {
			if (hm.containsKey(arr2[i])) {
				System.out.println(arr2[i]);
				if (hm.get(arr2[i]) > 1) {
					hm.put(arr2[i], hm.get(arr2[i]) - 1);
				} else {
					hm.remove(arr2[i]);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr1= {2 ,6 ,8 ,5 ,4 ,3};
		int[] arr2= {2 ,3 ,4 ,7 };
		printIntersection(arr1, arr2);
	}
}
