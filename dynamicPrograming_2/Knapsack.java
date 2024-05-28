//Problem statement
//A thief robbing a store can carry a maximal weight of W into his knapsack. There are N items, and i-th item weigh 'Wi' and the value being 'Vi.' What would be the maximum value V, that the thief can steal?
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= N <= 20
//1<= Wi <= 100
//1 <= Vi <= 100
//
//Time Limit: 1 sec
//Sample Input 1 :
//4
//1 2 4 5
//5 4 8 6
//5
//Sample Output 1 :
//13
//Sample Input 2 :
//5
//12 7 11 8 9
//24 13 23 15 16
//26
//Sample Output 2 :
//51

package dynamicPrograming_2;

/*
Time Complexity : O(3 ^ n)
Space Complexity : O(N)
Where N is the total number of weights
*/
public class Knapsack {
	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		if (n == 0 || maxWeight == 0) {
			return 0;
		}
		if (weights[n - 1] > maxWeight) {
			return knapsack(weights, values, n - 1, maxWeight);
		}
		int includeItem = values[n - 1] + knapsack(weights, values, n - 1, maxWeight - weights[n - 1]);
		int excludeItem = knapsack(weights, values, n - 1, maxWeight);
		return Math.max(includeItem, excludeItem);
	}
}
