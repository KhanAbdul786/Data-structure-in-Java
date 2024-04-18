//Problem statement
//Write a recursive function that returns the sum of the digits of a given integer.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= N <= 10^9
//Sample Input 1 :
//12345
//Sample Output 1 :
//15
//Sample Input 2 :
//9
//Sample Output 2 :
//9


package recursionAssignment;

public class SumOfDigit {
	
	public static int sumOfDigit(int n) {
		
		if(n==0) {
			return 0;
		}
		int small=sumOfDigit(n/10);
		int rem=n%10;
		int ans = rem+small;
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(sumOfDigit(12345));
	}

}
