package oops_2;

public class ExceptipnUse {

	public static void main(String[] args) {

		try {
			int a = 5 / 0;
		}
		 catch (ArithmeticException e) {
			System.out.print("Arithmetic Exception caught ");
		} catch (Exception e) {
			System.out.print("Exception caught ");
		}finally {
			System.out.println("finally block");
		}
		System.out.println("main");
	}
}