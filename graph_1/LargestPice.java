//Problem statement
//It's Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's . But Gary wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with each other on the cake. Given the size of cake N and the cake, can you find the count of '1's in the biggest piece of '1's for Gary ?
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= N <= 1000
//Time Limit: 1 sec
//Sample Input 1:
//2
//1 1
//0 1
//Sample Output 1:
//3

package graph_1;

/*
Time complexity: O(N*N)
Space complexity: O(N*N)
where N is the size of cake
*/
public class LargestPice {
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static int dfs(String[] edge, int n) {
		boolean[][] visited = new boolean[n][n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == false && edge[i].charAt(j) == '1') {
					ans = Math.max(ans, dfs(edge, visited, i, j, n));
				}
			}
		}
		return ans;
	}

	private static int dfs(String[] edge, boolean[][] visited, int x, int y, int n) {
		visited[x][y] = true;
		int count = 1;
		for (int i = 0; i < 4; i++) {
			int nex = x + dir[i][0];
			int ney = y + dir[i][1];
			if (valid(nex, ney, n) && edge[nex].charAt(ney) == '1' && visited[nex][ney] == false) {
				count += dfs(edge, visited, nex, ney, n);
			}
		}
		return count;
	}

	private static boolean valid(int x, int y, int n) {
		return (x >= 0 && y >= 0 && x < n && y < n);
	}
}