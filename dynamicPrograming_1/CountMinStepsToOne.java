//Problem statement
//Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:
//
//1.) Subtract 1 from it. (n = n - ­1) ,
//2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
//3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
//Write brute-force recursive solution for this.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= n <= 200
//
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
//Step 1 :  n = 7 ­- 1 = 6
//Step 2 : n = 6  / 3 = 2 
//Step 3 : n = 2 / 2 = 1  

package dynamicPrograming_1;

/*
Time Complexity : O(3^n)
Space Complexity : O(n)
Where 'n' is the total number of steps
*/
public class CountMinStepsToOne {
	public static int countMinStepsToOne(int n) {
		if (n == 1) {
			return 0;
		}
		int subtractOne = Integer.MAX_VALUE;
		int divideByTwo = Integer.MAX_VALUE;
		int divideByThree = Integer.MAX_VALUE;
		subtractOne = countMinStepsToOne(n - 1);
		if (n % 2 == 0) {
			divideByTwo = countMinStepsToOne(n / 2);
		}
		if (n % 3 == 0) {
			divideByThree = countMinStepsToOne(n / 3);
		}
		return 1 + Math.min(subtractOne, Math.min(divideByTwo, divideByThree));
	}
	
	//Another ways
	public static int countMinStepsToOne2(int n,int[] dp) {
		if (n == 1) {
			return 0;
		}
		int ans1;
		if(dp[n-1]==-1) {
			ans1=countMinStepsToOne2(n-1,dp);
			dp[n-1]=ans1;
		}
		else {
			ans1=dp[n-1];
		}
		int ans2=Integer.MAX_VALUE;
		if(n%2==0) {
			if(dp[n/2]==-1) {
				ans2=countMinStepsToOne2(n/2, dp);
				dp[n/2]=ans2;
			}else {
				ans2=dp[n/2];
			}
		}
		int ans3=Integer.MAX_VALUE;
		if(n%3==0) {
			if(dp[n/3]==-1) {
				ans3=countMinStepsToOne2(n/3, dp);
				dp[n/3]=ans2;
			}else {
				ans3=dp[n/3];
			}
		}
		return Math.min(ans1, Math.min(ans2, ans3))+1;
	}
	
	
	public static void main(String[] args) {
		int n=10;
		int[] dp=new int[n+1];
		for (int i = 0; i < dp.length; i++) {
			dp[i]=-1;
		}
		int ans=countMinStepsToOne(n);
		System.out.println(ans);
	}
}
