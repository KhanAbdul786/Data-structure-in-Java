//Problem statement
//Write a program to find x to the power n (i.e. x^n). Take x and n from the user. You need to return the answer.
//
//Do this recursively.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= x <= 30
//0 <= n <= 30
//Sample Input 1 :
// 3 4
//Sample Output 1 :
//81
//Sample Input 2 :
// 2 5
//Sample Output 2 :
//32


package recursion_1;

public class SumOfNNaturalNumber {
	public static int sum(int n) {
		if(n==0) {
			return 0;
		}
		int out=sum(n-1);
		return n+out;
	}

	public static void main(String[] args) {
		System.out.println(sum(4));

	}

}