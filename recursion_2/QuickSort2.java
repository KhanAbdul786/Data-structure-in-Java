package recursion_2;

public class QuickSort2 {

	public static int partitionArray(int input[], int start, int end) {
//Chose pivot
		int pivot = input[start];
//Count elements smaller than pivot and swap
		int count = 0;
		for (int i = start + 1; i <= end; i++) {
			if (input[i] <= pivot) {
				count++;
			}
		}
		int pivotIndex = start + count;
		int temp = input[start];
		input[start] = input[pivotIndex];
		input[pivotIndex] = temp;
//ensure left half contains elements smaller than pivot
//and right half larger
		int i = start, j = end;
		while (i <= pivotIndex && j >= pivotIndex) {
			while (i <= pivotIndex && input[i] <= pivot) {
				i++;
			}
			while (j >= pivotIndex && input[j] > pivot) {
				j--;
			}
			if (i < pivotIndex && j > pivotIndex) {
				temp = input[i];
				input[i] = input[j];
				input[j] = temp;
				i++;
				j--;
			}
		}
		return pivotIndex;
	}

	public static void quickSort(int input[], int start, int end) {
		if (start >= end) {
			return;
		}
		int pivotIndex = partitionArray(input, start, end);
		quickSort(input, start, pivotIndex - 1);
		quickSort(input, pivotIndex + 1, end);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
