//Problem statement
//An integer matrix of size (M x N) has been given. Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).
//
//From a cell (i, j), you can move in three directions:
//
//1. ((i + 1),  j) which is, "down"
//2. (i, (j + 1)) which is, "to the right"
//3. ((i+1), (j+1)) which is, "to the diagonal"
//The cost of a path is defined as the sum of each cell's values through which the route passes.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= M <= 10 ^ 2
//1 <= N <=  10 ^ 2
//
//Time Limit: 1 sec
//Sample Input 1 :
//3 4
//3 4 1 2
//2 1 8 9
//4 7 8 1
//Sample Output 1 :
//13
//Sample Input 2 :
//3 4
//10 6 9 0
//-23 8 9 90
//-200 0 89 200
//Sample Output 2 :
//76
//Sample Input 3 :
//5 6
//9 6 0 12 90 1
//2 7 8 5 78 6
//1 6 0 5 10 -4 
//9 6 2 -10 7 4
//10 -2 0 5 5 7
//Sample Output 3 :
//18

package dynamicPrograming_2;

public class MinCostPath {
	private static int minCostPathHelper(int[][] input, int mRows, int nCols, int currRow, int currCol) {
		if (currRow >= mRows || currCol >= nCols) {
			return Integer.MAX_VALUE;
		}
		if (currRow == (mRows - 1) && currCol == (nCols - 1)) {
			return input[currRow][currCol];
		}
		int downCost = minCostPathHelper(input, mRows, nCols, (currRow + 1), currCol);
		int diagonalCost = minCostPathHelper(input, mRows, nCols, (currRow + 1), (currCol + 1));
		int leftCost = minCostPathHelper(input, mRows, nCols, currRow, (currCol + 1));
		return input[currRow][currCol] + Math.min(diagonalCost, Math.min(downCost, leftCost));
	}

	public static int minCostPath(int[][] input) {
		int mRows = input.length;
		if (mRows == 0) {
			return Integer.MAX_VALUE;
		}
		int nCols = input[0].length;
		return minCostPathHelper(input, mRows, nCols, 0, 0);
	}

	// 2nd type
	public static int minCostPath2(int[][] cost, int i, int j) {
		int m = cost.length;
		int n = cost[0].length;
		// special case
		if (i == m - 1 && j == n - 1) {
			return cost[i][j];
		}
		// base case
		if (i >= m || j >= n) {
			return Integer.MAX_VALUE;
		}
		int ans1 = minCostPath2(cost, i + 1, j);
		int ans2 = minCostPath2(cost, i, j + 1);
		int ans3 = minCostPath2(cost, i + 1, j + 1);

		int myAns = cost[i][j] + Math.min(ans1, Math.min(ans2, ans3));
		return myAns;
	}

	public static void main(String[] args) {
		int[][] cost = { { 1, 5, 11 }, { 8, 13, 12 }, { 2, 3, 7 }, { 15, 16, 18 } };
		int ans = minCostPath2(cost, 0, 0);
		System.out.println(ans);
	}

}
