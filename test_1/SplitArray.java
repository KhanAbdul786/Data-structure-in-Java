package test_1;

public class SplitArray {
	
	
//	public static boolean splitArray(int input[]) {
//		/* Your class should be named solution
//		* Don't write main().
//		* Don't read input, it is passed as function argument.
//		* Return output and don't print it.
//		* Taking input and printing output is handled automatically.
//		*/
//		return splitArray(input,0,0,0);
//	}
//
//	public static boolean splitArray(int arr[], int si, int lsum, int rsum) 
//	{ 
//         //lsum for sum of numbers divisible by 5 and rsum for sum of numbers divisible by 3
//  
//    	if (si == arr.length) 
//        {
//            return lsum == rsum;
//        }
//         
//    	if (arr[si] % 5 == 0)
//        {
//            lsum += arr[si];
//        }
//        else if (arr[si] % 3 == 0) 
//        {
//            rsum += arr[si]; 
//        }
//        else
//        {
//            return splitArray(arr,si+1, lsum+arr[si], rsum)  || splitArray(arr,si+1,lsum,rsum+arr[si]);
//        }
//         
//    	return splitArray(arr,si+1,lsum,rsum); 
//	}
	
	
	// Ninjas solution 

	public static boolean splitArray(int input[]) {
		return check(input, 0, 0, 0);
	}

	public static boolean check(int input[], int startIndex, int lSum, int rSum) {
		if (startIndex == input.length) {
			return lSum == rSum;
		}
		if (input[startIndex] % 5 == 0) {
			lSum += input[startIndex];
		} else if (input[startIndex] % 3 == 0) {
			rSum += input[startIndex];
		} else {
			boolean leftAns = check(input, startIndex + 1, lSum + input[startIndex], rSum);
			boolean rightAns = check(input, startIndex + 1, lSum, rSum + input[startIndex]);
			return leftAns || rightAns;
		}
		return check(input, startIndex + 1, lSum, rSum);
	}

	public static void main(String[] args) {
		int[] arr= {1 ,4 ,3};
		System.out.println(splitArray(arr));

	}

}
