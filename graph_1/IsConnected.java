//Problem statement
//Given an undirected graph G(V,E), check if the graph G is connected graph or not.
//
//Note:
//
//1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
//2. E is the number of edges present in graph G.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= V <= 1000
//0 <= E <= (V * (V - 1)) / 2
//0 <= a <= V - 1
//0 <= b <= V - 1
//Time Limit: 1 second
//Sample Input 1:
//4 4
//0 1
//0 3
//1 2
//2 3
//Sample Output 1:
//true
//Sample Input 2:
//4 3
//0 1
//1 3 
//0 3
//Sample Output 2:
//false 

package graph_1;

/*
Time complexity: O(V + E)
Space complexity: O(V^2)
where V is the number of vertices in the input graph and
E is the number of edges in the input graph
*/
import java.util.Scanner;
import java.io.IOException;

public class IsConnected {
	static Scanner sc = new Scanner(System.in);

	public static void DFS(int[][] edges, int sv, boolean[] visited) {
		visited[sv] = true;
		for (int i = 0; i < edges.length; i++) {
			if (edges[sv][i] == 1 && !visited[i]) {
				DFS(edges, i, visited);
				visited[i] = true;
			}
		}
	}

	public static boolean isConnected(int[][] edges) {
		boolean[] visited = new boolean[edges.length];
		DFS(edges, 0, visited);
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] strNums;
		strNums = sc.nextLine().split("\\s");
		int n = Integer.parseInt(strNums[0]);
		int e = Integer.parseInt(strNums[1]);
		if (n == 0) {
			System.out.println("true");
			return;
		}
		int edges[][] = new int[n][n]; // Space O(V^2)
		for (int i = 0; i < e; i++) {
			String[] strNums1;
			strNums1 = sc.nextLine().split("\\s");
			int fv = Integer.parseInt(strNums1[0]);
			int sv = Integer.parseInt(strNums1[1]);
			edges[fv][sv] = 1;
			edges[sv][fv] = 1;
		}
		System.out.println(isConnected(edges));
	}
}