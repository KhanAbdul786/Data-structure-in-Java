package recursionAssignment;

public class StairCase {
	public static int stairCase(int n) {
		if(n<0) {
			return 0;
		}
		if(n==0) {
			return 1;
		
		}
		return stairCase(n-1)+stairCase(n-2)+stairCase(n-3);
	}

	public static void main(String[] args) {
		System.out.println(stairCase(4));

	}

}
