//Problem statement
//You have been given a random integer array/list(ARR) of size N. Write a function that rotates the given array/list by D elements(towards the left).
//
// Note:
//Change in the input array/list itself.You don't need to return or print the elements.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= t <= 10^4
//0 <= N <= 10^6
//0 <= D <= N
//Time Limit: 1 sec
//Sample Input 1:
//1
//7
//1 2 3 4 5 6 7
//2
//Sample Output 1:
//3 4 5 6 7 1 2
//Sample Input 2:
//2
//7
//1 2 3 4 5 6 7
//0
//4
//1 2 3 4
//2
//Sample Output 2:
//1 2 3 4 5 6 7
//3 4 1 2



package timeComplexity;

public class RotateArray {

	public static void swapElements(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}

	public static void reverse(int[] arr, int start, int end) {
		while (start < end) {
			swapElements(arr, start, end);
			start += 1;
			end -= 1;
		}
	}

	public static void rotate(int[] arr, int d) {
		if (arr.length == 0) {
			return;
		}
		if (d >= arr.length && arr.length != 0) {
			d %= arr.length;
		}
		reverse(arr, 0, arr.length - 1);
		reverse(arr, 0, arr.length - d - 1);
		reverse(arr, arr.length - d, arr.length - 1);
	}

	public static void main(String[] args) {
		int[] arr= {1 ,2 ,3 ,4 ,5 ,6 ,7};
		rotate(arr, 2);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
