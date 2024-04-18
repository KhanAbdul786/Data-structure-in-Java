//Problem statement
//Given an array of length N, you need to find and return the sum of all elements of the array.
//
//Do this recursively.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= N <= 10^3
//Sample Input 1 :
//3
//9 8 9
//Sample Output 1 :
//26
//Sample Input 2 :
//3
//4 2 1
//Sample Output 2 :
//7    

package recursion_1;

public class SumOfArray {
	public static int sumOfArray(int[] arr) {
		if(arr.length==1) {
			return arr[0];
		}
		
		int[] small=new int[arr.length-1];
		for(int i=1;i<arr.length;i++) {
			small[i-1]=arr[i];
		}
		int out=sumOfArray(small);
		int val=arr[0]+out;
		return val;
	}

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5};
		System.out.println(sumOfArray(arr));

	}

}
