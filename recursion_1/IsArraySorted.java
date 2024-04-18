package recursion_1;

public class IsArraySorted {
	public static boolean isSorted(int[] a) {
		if (a.length == 1) {
			return true;
		}
		if (a[0] > a[1]) {
			return false;
		}
		int[] smallArray = new int[a.length - 1];
		for (int i = 1; i < a.length; i++) {
			smallArray[i - 1] = a[i];
		}
		boolean isSort = isSorted(smallArray);
		return isSort;

	}

	public static void main(String[] args) {
		int[] ar= {1,2,3,4,5,9,};
		System.out.println(isSorted(ar));

	}

}
