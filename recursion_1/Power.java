


package recursion_1;

public class Power {
	public static int power(int x,int n) {
		if(n==0) {
			return 1;
		}
		int small=power(x, n-1);
		int out=x*small;
		return out;
	}

	public static void main(String[] args) {
		System.out.println(power(3, 3));

	}

}
