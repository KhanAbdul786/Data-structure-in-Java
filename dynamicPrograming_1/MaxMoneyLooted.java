//Problem statement
//A thief wants to loot houses. He knows the amount of money in each house. He cannot loot two consecutive houses. Find the maximum amount of money he can loot.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= n <= 10 ^ 4
//
//Time Limit: 1 sec
//Sample Input 1 :
//6
//5 5 10 100 10 5
//Sample Output 1 :
//110
//Sample Input 2 :
//6
//10 2 30 20 3 50
//Sample Output 2 :
//90
//Explanation of Sample Output 2 :
//Looting first, third, and the last houses([10 + 30 + 50]) will result in the maximum loot, and all the other possible combinations would result in less than 90.

package dynamicPrograming_1;

/*
Time Complexity : O(n)
Space Complexity : O(n)
Where 'n' is the total number of houses
*/
public class MaxMoneyLooted {
	public static int maxMoneyLooted(int[] houses) {
		int n = houses.length;
//Special case
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return houses[0];
		}
		int[] maxMoneyCanBeLooted = new int[n];
		maxMoneyCanBeLooted[0] = houses[0];
		maxMoneyCanBeLooted[1] = Math.max(houses[0], houses[1]);
		for (int currHouse = 2; currHouse < n; currHouse++) {
			maxMoneyCanBeLooted[currHouse] = Math.max(maxMoneyCanBeLooted[currHouse - 1],
					(houses[currHouse] + maxMoneyCanBeLooted[currHouse - 2]));
		}
		return maxMoneyCanBeLooted[n - 1];
	}
}
