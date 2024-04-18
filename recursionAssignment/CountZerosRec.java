//Problem statement
//Given an integer N, count and return the number of zeros that are present in the given integer using recursion.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Input Format :
//Integer N
//Output Format :
//Number of zeros in N
//Constraints :
//0 <= N <= 10^9
//Sample Input 1 :
//0
//Sample Output 1 :
//1
//Sample Input 2 :
//00010204
//Sample Output 2 :
//2
//Explanation for Sample Output 2 :
//Even though "00010204" has 5 zeros, the output would still be 2 because when you convert it to an integer, it becomes 10204.
//Sample Input 3 :
//708000
//Sample Output 3 :
//4

package recursionAssignment;

public class CountZerosRec {

	public static int countZerosRec(int input) {
		// Write your code here

		if (input < 10) {
			if (input == 0) {
				return 1;
			} else {
				return 0;
			}
		}
		if (input % 10 == 0) {
			return countZerosRec(input / 10) + 1;
		} else {
			return countZerosRec(input / 10);
		}
	}

	public static void main(String[] args) {
		System.out.println(countZerosRec(10000204));

	}

}
