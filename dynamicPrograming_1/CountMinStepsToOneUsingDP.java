//Problem statement
//Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:
//
//1.) Subtract 1 from it. (n = n - �1) ,
//2.) If n is divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
//3.) If n is divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= n <= 10 ^ 6
//Time Limit: 1 sec
//Sample Input 1 :
//4
//Sample Output 1 :
//2 
//Explanation of Sample Output 1 :
//For n = 4
//Step 1 :  n = 4 / 2  = 2
//Step 2 : n = 2 / 2  =  1 
//Sample Input 2 :
//7
//Sample Output 2 :
//3
//Explanation of Sample Output 2 :
//For n = 7
//Step 1 :  n = 7 �- 1 = 6
//Step 2 : n = 6  / 3 = 2 
//Step 3 : n = 2 / 2 = 1  


package dynamicPrograming_1;

/*
Time Complexity : O(n)
Space Complexity : O(n)
Where 'n' is the total number of steps
*/
public class CountMinStepsToOneUsingDP {
	public static int countMinStepsToOne(int n) {
		if (n == 1) {
			return 0;
		}
		int[] minSteps = new int[n + 1];
		minSteps[1] = 0;
		for (int currStep = 2; currStep <= n; currStep++) {
			int subtractOne = Integer.MAX_VALUE;
			int divideByTwo = Integer.MAX_VALUE;
			int divideByThree = Integer.MAX_VALUE;
			subtractOne = minSteps[currStep - 1];
			if (currStep % 2 == 0) {
				divideByTwo = minSteps[currStep / 2];
			}
			if (currStep % 3 == 0) {
				divideByThree = minSteps[currStep / 3];
			}
			minSteps[currStep] = 1 + Math.min(subtractOne, Math.min(divideByTwo, divideByThree));
		}
		return minSteps[n];
	}
}
