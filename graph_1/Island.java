//Problem statement
//An island is a small piece of land surrounded by water . A group of islands is said to be connected if we can reach from any given island to any other island in the same group . Given V islands (numbered from 0 to V-1) and E connections or edges between islands. Can you count the number of connected groups of islands.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= V <= 1000
//0 <= E <= (V * (V-1)) / 2
//0 <= a <= V - 1
//0 <= b <= V - 1
//Time Limit: 1 second
//Sample Input 1:
//5 8
//0 1
//0 4
//1 2
//2 0
//2 4
//3 0
//3 2
//4 3
//Sample Output 1:
//1 
//public class Solution {
//
//	public static int numConnected(int[][] edges, int n) {
//		boolean[] visited = new boolean[n];
//		int count = 0;
//		for (int i = 0; i < n; i++) {
//			if (visited[i] == false) {
//				dfs(edges, i, visited, n);
//				count++;
//			}
//

package graph_1;

/*
Time complexity: O(N^2)
Space complexity: O(N^2)
where N is the number of vertex in the graph
*/
public class Island {
	public static int numConnected(int[][] edges, int n) {
		boolean[] visited = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs(edges, i, visited, n);
				count++;
			}
		}
		return count;
	}

	private static void dfs(int[][] edges, int v1, boolean[] visited, int n) {
		visited[v1] = true;
		for (int i = 0; i < n; i++) {
			if (visited[i] == false && edges[v1][i] == 1) {
				dfs(edges, i, visited, n);
			}
		}
	}
}