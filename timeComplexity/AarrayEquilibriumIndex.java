//Problem statement
//For a given array/list(ARR) of size 'N,' find and return the 'Equilibrium Index' of the array/list.
//
//Equilibrium Index of an array/list is an index 'i' such that the sum of elements at indices [0 to (i - 1)] is equal to the sum of elements at indices [(i + 1) to (N-1)]. One thing to note here is, the item at the index 'i' is not included in either part.
//
//If more than one equilibrium indices are present, then the index appearing first in left to right fashion should be returned. Negative one(-1) if no such index is present.
//
//Example:
//Let's consider an array/list Arr = [2, 3, 10, -10, 4, 2, 9]  of size, N = 7.
//
//There exist three equilibrium indices, one at 2, another at 3, and another at 5.
//
//At index 2, the sum of all the elements to the left, [2 + 3] is 5, and the elements to its right, [-10 + 4 + 2 + 9] is also 5. Hence index 2 is an equilibrium index according to the condition we want to achieve. Mind it that we haven't included the item at index 2, which is 10, to either of the parts.
//
//Similarly, we can see at index 3 and 5, the elements to its left sum up to 15 and 9 respectively and to the right, sum up to 15 and 9 respectively either. 
//
//Hence the answer would be 2.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= t <= 10^2
//0 <= N <= 10^6
//
//Time Limit: 1 sec 
//Sample Input 1 :
//1
//5
//1 4 9 3 2
//Sample Output 1 :
//2
//Sample Input 2 :
//2
//3
//1 4 6
//3
//1 -1 4
//Sample Output 2 :
//-1
//2
package timeComplexity;

public class AarrayEquilibriumIndex {
//	public static int arrayEquilibriumIndex(int[] arr) {
//		int LeftSum,RightSum;
//		for (int i = 0; i < arr.length; i++) {
//			LeftSum=0;
//			for (int j = 0; j < i; j++) {
//				LeftSum +=arr[j];
//			}
//			RightSum=0;
//			for (int j = i+1; j < arr.length; j++) {
//				RightSum +=arr[j];
//			}
//			
//			if(LeftSum==RightSum) {
//				return i;
//			}
//		}
//		return -1;
//	}
	
	
//	ninjas 2nd type

	
//	public static int arrayEquilibriumIndex(int[] arr) {
//		
//		int leftSum=0, rightSum=0;
//		
//		for (int i = 0; i < arr.length; i++) {
//			leftSum +=arr[i];
//		}
//		
//		for (int i = 0; i < arr.length; i++) {
//			leftSum -=arr[i];
//			
//			if(leftSum==rightSum) {
//				return i;
//			}
//			
//			rightSum +=arr[i];
//		}
//		
//		return -1;
//		
//		
//	}
	
//	ninjas 3rd type
	
	public static int arrayEquilibriumIndex(int[] arr) {
		int totalSum=0;
		for (int i = 0; i < arr.length; i++) {
			totalSum +=arr[i];
		}
		int index=0,rightSum=0,leftSum=0;
		while(index<arr.length) {
			rightSum=totalSum-leftSum-arr[index];
			if (leftSum==rightSum) {
				return index;
			}
			leftSum =leftSum+arr[index];
			index++;
		}
		return -1;
	}
	

	public static void main(String[] args) {
		int[] arr = { 1, 4, 9, 3, 2 };
		System.out.println(arrayEquilibriumIndex(arr));

	}

}
