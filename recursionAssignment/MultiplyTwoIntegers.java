package recursionAssignment;

public class MultiplyTwoIntegers {
	public static int multiplyTwoIntegers(int m,int n) {
		if(m==0||n==0) {
			return 0;
		}
		return m+multiplyTwoIntegers(m, n-1);
	}

	public static void main(String[] args) {
		System.out.println(multiplyTwoIntegers(3, 3));

	}

}
