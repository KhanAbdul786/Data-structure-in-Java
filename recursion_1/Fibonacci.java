package recursion_1;

public class Fibonacci {
	public static int fib(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		int fib_1 = fib(n - 1);
		int fib_2 = fib(n - 2);
		int out = fib_1 + fib_2;
		return out;
	}

	public static void main(String[] args) {
		System.out.println(fib(6));

	}

}
