//Problem statement
//A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to count and return all possible ways in which the child can run-up to the stairs.
//
//Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
//0 <= n <= 10 ^ 4
//
//Time Limit: 1 sec
//Sample Input 1:
//4
//Sample Output 1:
//7
//Sample Input 2:
//10
//Sample Output 2:
//274


package dynamicPrograming_1;

/*
Time Complexity : O(n)
Space Complexity : O(n)
Where 'n' is the total number of steps in a staircase
*/
public class Staircase {
	public static long staircase(int n) {
		long[] ways = new long[n + 1]; // this is our DP array/list of size (n + 1)
//Base Cases
		if (n == 0) {
			return 1;
		}
		if (n == 1 || n == 2) {
			return n;
		}
		ways[0] = 1;
		ways[1] = 1;
		ways[2] = 2;
		for (int i = 3; i <= n; i++) {
			ways[i] = ways[i - 1] + ways[i - 2] + ways[i - 3];
		}
		return ways[n];
	}
	
	//Non ninja solution
//	public static long staircase(int n) {
//		//Your code goes here
//        
//        long steps[] = new long[n + 1];
//      steps[0]=1;
//      if(n>0)
//      steps[1]=1;
//      if(n>1)
//      steps[2]=2;
//      if(n>2)
//      steps[3]=4;
//    for(int i=4;i<=n;i++){
//        long count1,count2 = 0, count3 = 0;
//        count1 = steps[i-1]; 
//        count2 = steps[i-2]; 
//        count3 = steps[i-3];  
//        steps[i] = count1+count2+count3;
//    }
//    return steps[n];
//        
//	}

}
