//Problem statement
//Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
//
//Find the path using BFS and print the shortest path available.
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
//Sample Input 1 :
//4 4
//0 1
//0 3
//1 2
//2 3
//1 3
//Sample Output 1 :
//3 0 1
//Sample Input 2 :
//6 3
//5 3
//0 1
//3 4
//0 3
//Sample Output 2 :

package graph_1;

/*
* In a typical BFS search, the time complexity is O(V+E)
* where V is the number of vertices and
* E is the number of edges.
*
* There are n nodes and m edges in this problem.
* We build adjacent list of all m edges in graph which takes O(m)
* Each node is added to the queue and popped from queue once, it takes O(n) to handle all nodes.
* The time complexity is O(n+m).
*
*/
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class BFSS {
	static Scanner sc = new Scanner(System.in);

	public static ArrayList<Integer> getPathBFSHelper(int[][] edges, int sv, int ev, boolean[] visited) {
		int n = edges.length;
		Map<Integer, Integer> map = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
// Check for invalid input of sv or ev
		if (sv > (edges.length - 1) || ev > (edges.length - 1)) {
			return null;
		}
		if (edges[sv][ev] == 1 && sv == ev) {
			ArrayList<Integer> ans = new ArrayList<>();
			ans.add(sv);
			return ans;
		}
		queue.add(sv);
		visited[sv] = true;
		while (!queue.isEmpty()) {
			int front = queue.remove();
			for (int i = 0; i < n; i++) {
				if (edges[front][i] == 1 && !visited[i]) {
					map.put(i, front);
					queue.add(i);
					visited[i] = true;
					if (i == ev) {
						ArrayList<Integer> ans = new ArrayList<>();
						ans.add(ev);
						int value = map.get(ev);
						while (value != sv) {
							ans.add(value);
							value = map.get(value);
						}
						ans.add(value);

						return ans;
					}
				}
			}
		}
		return null;
	}

	public static ArrayList<Integer> getPathBFS(int[][] edges, int sv, int ev) {
		boolean[] visited = new boolean[edges.length];
		return getPathBFSHelper(edges, sv, ev, visited);
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
		ArrayList<Integer> ans = getPathBFS(edges, sv, ev);
		if (ans != null) {
			for (int elem : ans) {
				System.out.print(elem + " ");
			}
		}
	}
}
