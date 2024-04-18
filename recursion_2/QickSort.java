//Problem statement
//Given the 'start' and the 'end'' positions of the array 'input'. Your task is to sort the elements between 'start' and 'end' using quick sort.
//
//
//
//Note :
//Make changes in the input array itself.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//6 
//2 6 8 5 4 3
//Sample Output 1 :
//2 3 4 5 6 8
//Sample Input 2 :
//5
//1 2 3 5 7
//Sample Output 2 :
//1 2 3 5 7 
//Constraints :
//1 <= N <= 10^3
//0 <= input[i] <= 10^9

/*
Time Complexity : O('N' * log('N'))
Space Complexity : O(log('N'))
where 'N' is size of input array
*/
//public class Solution {
//public static int partitionArray(int input[], int start, int end) {
////Chose pivot
//		int pivot = input[start];
////Count elements smaller than pivot and swap
//		int count = 0;
//		for (int i = start + 1; i <= end; i++) {
//			if (input[i] <= pivot) {
//				count++;
//			}
//		}
//		int pivotIndex = start + count;
//		int temp = input[start];
//		input[start] = input[pivotIndex];
//		input[pivotIndex] = temp;
////ensure left half contains elements smaller than pivot
////and right half larger
//		int i = start, j = end;
//		while (i <= pivotIndex && j >= pivotIndex) {
//			while (i <= pivotIndex && input[i] <= pivot) {
//				i++;
//			}
//			while (j >= pivotIndex && input[j] > pivot) {
//				j--;
//			}
//			if (i < pivotIndex && j > pivotIndex) {
//				temp = input[i];
//				input[i] = input[j];
//				input[j] = temp;
//				i++;
//				j--;
//			}
//		}
//		return pivotIndex;
//	}
//
//	public static void quickSort(int input[], int start, int end) {
//		if (start >= end) {
//			return;
//		}
//		int pivotIndex = partitionArray(input, start, end);
//		quickSort(input, start, pivotIndex - 1);
//		quickSort(input, pivotIndex + 1, end);
//	}

package recursion_2;

public class QickSort {

	public static void quickSort(int[] a, int si, int ei) {
		if (si >= ei) {
			return;
		}
		int pivotIndex = partition(a, si, ei);
		quickSort(a, si, pivotIndex - 1);
		quickSort(a, pivotIndex + 1, ei);
	}

	private static int partition(int[] a, int si, int ei) {
		int pivotELement = a[si];
		int smallerNumCount = 0;
		for (int i = si + 1; i <= ei; i++) {
			if (a[i] < pivotELement) {
				smallerNumCount++;
			}
		}
		int temp = a[si + smallerNumCount];
		a[si + smallerNumCount] = pivotELement;
		a[si] = temp;

		int i = si;
		int j = ei;

		while (i < j) {
			if (a[i] < pivotELement) {
				i++;
			} else if (a[j] >= pivotELement) {
				j--;
			} else {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		return si + smallerNumCount;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 6, 12, 2, 5, 7, 8, 9 };
		quickSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
