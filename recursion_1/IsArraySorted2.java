package recursion_1;

public class IsArraySorted2 {
	public static boolean isArraySorted2(int[] arr, int si) {
		if (si == arr.length - 1) {
			return true;
		}
		if (arr[si] > arr[si + 1]) {
			return false;
		}
		boolean out=isArraySorted2(arr, si+1);
		return out;

	}

	public static void main(String[] args) {
		int[] arr= {1,2,8,4,5,6};
		System.out.println(isArraySorted2(arr, 0));

	}

}
