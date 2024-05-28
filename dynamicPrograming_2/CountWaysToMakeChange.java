package dynamicPrograming_2;
//
//Problem statement
//For the given infinite supply of coins of each of denominations, D = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total number of ways W, in which you can make the change for Value V using coins of denominations D.
//
//Return 0 if the change isn't possible.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//3
//1 2 3
//4
//Sample Output 1 :
//4
//Explanation to Sample Input 1 :
//Number of ways are - 4 total i.e. (1,1,1,1), (1,1, 2), (1, 3) and (2, 2).
//Sample Input 2 :
//6
//1 2 3 4 5 6
//250
//Sample Output 2 :
//13868903

/*
Time Complexity: O(mn)
Space Complexity: O(mn)
where n is number of demoninationsa and m is the value inputted
*/
public class CountWaysToMakeChange {
	public static int countWaysToMakeChange(int denominations[], int value) {
		int n = denominations.length;
		int ways[][] = new int[n][value + 1];
		for (int i = 0; i < n; i++) {
			ways[i][0] = 1;
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 1; j <= value; j++) {
				int count1 = 0;
				if (i + 1 <= n - 1) {
					count1 = ways[i + 1][j];
				}
				int count2 = 0;
				if (j - denominations[i] >= 0) {
					count2 = ways[i][j - denominations[i]];
				}
				ways[i][j] = count1 + count2;
			}
		}
		return ways[0][value];
	}
}