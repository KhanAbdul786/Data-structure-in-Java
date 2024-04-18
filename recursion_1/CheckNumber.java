//Problem statement
//Given an array of length N and an integer x, you need to find if x is present in the array or not. Return true or false.
//
//Do this recursively.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= N <= 10^3
//Sample Input 1 :
//3
//9 8 10
//8
//Sample Output 1 :
//true
//Sample Input 2 :
//3
//9 8 10
//2
//Sample Output 2 :
//false



package recursion_1;

public class CheckNumber {
	public static boolean checkNumber(int[] input,int x) {
		if(input.length==1) {
			if(input[0]==0) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (input[0]==x) {
			return true;
		}
		int[] small=new int[input.length-1];
		for(int i=1;i<input.length;i++) {
			small[i-1]=input[i];
		}
		boolean out=checkNumber(small, x);
		return out;
	}

	public static void main(String[] args) {
		int[] arr= {7,8,9};
		System.out.println(checkNumber(arr, 8));

	}

}
