package recursion_1;

public class Fcatorial {
	public static int fact(int n) {
		if(n==0) {
			return 1;
		}
		int small=fact(n-1);
		int out=n*small;
		return out;
	}

	public static void main(String[] args) {
		System.out.println(fact(5));

	}

}
