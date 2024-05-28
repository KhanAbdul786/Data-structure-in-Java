//Problem statement
//You are given a magic grid A with R rows and C columns. In the cells of the grid, you will either get magic juice, which increases your strength by |A[i][j]| points, or poison, which takes away |A[i][j]| strength points. If at any point of the journey, the strength points become less than or equal to zero, then you will die.
//
//You have to start from the top-left corner cell (1,1) and reach at the bottom-right corner cell (R,C). From a cell (i,j), you can only move either one cell down or right i.e., to cell (i+1,j) or cell (i,j+1) and you can not move outside the magic grid. You have to find the minimum number of strength points with which you will be able to reach the destination cell.
//
//Detailed explanation ( Input/output format, Notes, Images )
//A[1][1] = A[R][C] = 0
//Time Limit: 1 second
//Sample Input 1:
//3
//2 3
//0 1 -3
//1 -2 0
//2 2
//0 1
//2 0
//3 4
//0 -2 -3 1
//-1 4 0 -2
//1 -2 -3 0
//Sample Output 1:
//2
//1
//2

package dynamicPrograming_2;

/*
Time complexity: O(N * M)
Space complexity: O(N * M)
where N and M are the rows and columns respectively of the given grid
*/
public class GetMinimumStrength {
	public static int getMinimumStrength(int[][] grid) {
		/*
		 * dp[i][j] stores the minimum strength required to reach bottom right corner of
		 * grid from the index (i, j)
		 */
		int n = grid.length;
		int m = grid[0].length;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; ++i) {
			for (int j = 0; j <= m; ++j) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		dp[n][m - 1] = 1;
		dp[n - 1][m] = 1;
		for (int i = n - 1; i >= 0; --i) {
			for (int j = m - 1; j >= 0; --j) {
// 'neededStrength' stores the minimum strength needed to survive
				int neededStrength = Integer.min(dp[i + 1][j], dp[i][j + 1]) - grid[i][j];
				dp[i][j] = (neededStrength <= 0) ? 1 : neededStrength;
			}
		}
		int ans = dp[0][0];
		return ans;
	}
}
