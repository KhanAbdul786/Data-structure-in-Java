//Problem statement
//Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
//
//Find the path using DFS and print the first path that you encountered.
//
//Note:
//
//1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
//2. E is the number of edges present in graph G.
//3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
//4. Save the input graph in Adjacency Matrix.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//2 <= V <= 1000
//1 <= E <= (V * (V - 1)) / 2
//0 <= a <= V - 1
//0 <= b <= V - 1
//0 <= v1 <= 2^31 - 1
//0 <= v2 <= 2^31 - 1
//Time Limit: 1 second
//Sample Input 1:
//4 4
//0 1
//0 3
//1 2
//2 3
//1 3
//Sample Output 1:
//3 0 1
//Sample Input 2:
//6 3
//5 3
//0 1
//3 4
//0 3
//Sample Output 2:

package graph_1;

/*
Time complexity: O(V + E)
Space complexity: O(V^2)
where V is the number of vertices in the input graph and
E is the number of edges in the input graph
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class DFSS {
	static Scanner sc = new Scanner(System.in);

	public static ArrayList<Integer> getPathDFSHelper(int[][] edges, int sv, int ev, boolean[] visited) {
		if (sv == ev) {
			ArrayList<Integer> ans = new ArrayList<>();
			ans.add(sv);
			return ans;
		}
		visited[sv] = true;
		int n = edges.length;
		for (int i = 0; i < n; i++) {
			if (edges[sv][i] == 1 && !visited[i]) {
				ArrayList<Integer> smallAns = getPathDFSHelper(edges, i, ev, visited);
				if (smallAns != null) {
					smallAns.add(sv);
					return smallAns;
				}
			}
		}
		return null;
	}

	public static ArrayList<Integer> getPathDFS(int[][] edges, int sv, int ev) {
		boolean visited[] = new boolean[edges.length];
		return getPathDFSHelper(edges, sv, ev, visited);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] strNums;
		strNums = sc.nextLine().split("\\s");
		int n = Integer.parseInt(strNums[0]);
		int e = Integer.parseInt(strNums[1]);
		int edges[][] = new int[n][n];
		for (int i = 0; i < e; i++) {
			String[] strNums1;
			strNums1 = sc.nextLine().split("\\s");
			int fv = Integer.parseInt(strNums1[0]);
			int sv = Integer.parseInt(strNums1[1]);
			edges[fv][sv] = 1;

			edges[sv][fv] = 1;
		}
		String[] strNums1;
		strNums1 = sc.nextLine().split("\\s");
		int sv = Integer.parseInt(strNums1[0]);
		int ev = Integer.parseInt(strNums1[1]);
		ArrayList<Integer> ans = getPathDFS(edges, sv, ev);
		if (ans != null) {
			for (int elem : ans) {
				System.out.print(elem + " ");
			}
		}
	}
}