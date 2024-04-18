//Problem statement
//Given an array of length N and an integer x, you need to find and return the first index of integer x present in the array. Return -1 if it is not present in the array.
//
//First index means, the index of first occurrence of x in the input array.
//
//Do this recursively. Indexing in the array starts from 0.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= N <= 10^3
//
//Sample Input :
//4
//9 8 10 8
//8
//Sample Output :
//1
package recursion_1;

public class FirstIndex {
	public static int firstIndex(int input[], int x) {
		if (input.length == 0) {
			return -1;
		}
		if (input[0] == x) {
			return 0;
		}
		int[] samll = new int[input.length - 1];
		for (int i = 1; i < input.length; i++) {
			samll[i - 1] = input[i];
		}
		int fi = firstIndex(samll, x);
		if (fi == -1) {
			return -1;
		} else {
			return fi + 1;
		}
	}

//		public static int firstIndex(int input[], int x,int i) {
//
//			if(startIndex==input.length) {
//				return -1;
//			}
//			if(input[startIndex]==x) {
//				return startIndex;
//			}
//			return firstIndex(input,x, startIndex+1);
//		}

	/*
	 * public class Solution {
	 * 
	 * public static int firstIndex(int input[], int x) { Your class should be named
	 * Solution Don't write main(). Don't read input, it is passed as function
	 * argument. Return output and don't print it. Taking input and printing output
	 * is handled automatically.
	 * 
	 * int si=0; int fi=firstIndex(input, x,si); return fi;
	 * 
	 * }
	 * 
	 * public static int firstIndex(int[] input,int x,int si){ if(si==input.length){
	 * return -1; } if(input[si]==x){ return si; } return firstIndex(input, x,
	 * si+1); }
	 * 
	 * }
	 */

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 8 };
		System.out.println(firstIndex(arr, 4));

	}

}
