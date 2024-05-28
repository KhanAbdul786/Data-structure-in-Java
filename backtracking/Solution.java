//Problem statement
//Ninja is planning to make dessert. For which he is going to buy ingredients. There are ‘N’ base flavors and ‘M’ toppings. Ninja has a target that he will be needing an amount of ‘K’ for making the dessert.
//
//For making dessert, there are some basic rules
//
//1. There should be exactly one base flavor.
//2. Toppings can be one or more or none.
//3. There are at most two toppings of each type.
//Ninja wants to make a dessert with a total cost as close to the target price as possible.
//
//You will be given an array/list flavor of size N representing the cost of each base flavor and another array/list toppings of size 'M' representing the cost of each topping and the target price.
//
//Your task is to help Ninja to find the closest possible cost of the dessert to the target price 'K'. If there are multiple answers, return the lower one.
//
//Example
//
//Let N = 2 , M = 2 , K = 10, FLAVOR = [1,7] , TOPPING = [3, 4] , K = 10
//
//Here we can make a dessert with the base flavor of price 7 and adding 1 topping of price 3. Which will cost 7 + 3 = 10, which is exactly equal to k, so the closest possible price would be 10.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints
//1 <= T <= 5
//1 <= N, M <= 10
//1 <= FLAVOUR[i] , TOPPINGS[i] <= 10 ^ 4
//1 <= K <= 10 ^ 4 
//
//Time limit: 1 sec.
//Sample Input 1
//2
//2
//1 7
//3
//1 2 3
//10
//1
//10
//3
//5 6 11
//9
//Sample Output 1
//10
//10
//Explanation
//Test case 1
//
//In this case, Ninja has 2 base flavours of cost 1 and 7,  and 3 toppings of price 1 and 2. Here target price is 10. So if Ninja takes a base of cost 7 and 1 topping of cost 3, then Ninja can make a dessert exactly of cost 10 ( 7 + 3), i.e., target price.
//
//Test case 2
//
//In this case, Ninja has only one base flavour of cost 10 and 3 toppings of 5, 6, 11. To make the dessert, Ninja must need a base, so 10 is the minimum cost that he must spend. Now, if he will add toppings price will rise further. So the closest possible price is 10.
//Sample Input 2:
//2
//4
//1 8 3 4
//3
//2 3 4
//20
//1
//2
//1
//2
//7
//Sample Output 2:
//20
//6


package backtracking;

/*
Time complexity : O(N * 3 ^ m)
Space complexity : O(M)
where N is the number of base flavors and M is the number of toppings.
*/
import java.util.ArrayList;

public class Solution {
// function to find closest price
	public static int close(int a, int b, int target) {
		if (a == 0) {
			return b;
		}
		if (b == 0) {
			return a;
		}
// if both are equally closest return the lower price
		if (Math.abs(target - a) == Math.abs(target - b)) {
			return a < b ? a : b;
		}
		return (Math.abs(target - a) < Math.abs(target - b) ? a : b);
	}

// function to find closest price possible for a specific flavor
	public static int dfs(ArrayList<Integer> top, int i, int sum, int target) {
		if (i >= top.size()) {
			return sum;
		}
// base + one topping
		int a = dfs(top, i + 1, sum + top.get(i), target);
// base + two toppings
		int b = dfs(top, i + 1, sum + top.get(i) * 2, target);
// only base
		int c = dfs(top, i + 1, sum, target);
// return the closest
		sum = close(a, close(b, c, target), target);
		return sum;
	}

	public static int closestCost(int n, int m, ArrayList<Integer> baseCosts, ArrayList<Integer> toppingCosts,
			int target) {
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = close(dfs(toppingCosts, 0, baseCosts.get(i), target), ans, target);
		}
		return ans;
	}
}
