//Problem statement
//Given an undirected and disconnected graph G(V, E), print its BFS traversal.
//
//Note:
//
//1. Here you need to consider that you need to print BFS path starting from vertex 0 only. 
//2. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
//3. E is the number of edges present in graph G.
//4. Take graph input in the adjacency matrix.
//5. Handle for Disconnected Graphs as well
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
//0 1 3 2

package graph_1;

/*
Time complexity: O(V + E)
Space complexity: O(V^2)
where V is the number of vertices in the input graph and
E is the number of edges in the input graph
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.IOException;

public class BFS {
	static Scanner sc = new Scanner(System.in);

	public static void printBFSHelper(int edges[][], int sv, boolean visited[]) {
		Queue<Integer> queue = new LinkedList<>();
		visited[sv] = true;
		queue.add(sv);
		while (!queue.isEmpty()) {
			int front = queue.remove();
			System.out.print(front + " ");
			for (int i = 0; i < edges.length; i++) {
				if (edges[front][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

	public static void printBFS(int edges[][]) {
		boolean visited[] = new boolean[edges.length];
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
//This check is performed for the disconnected components
//Condition 6.
				printBFSHelper(edges, i, visited);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] strNums;
		strNums = sc.nextLine().split("\\s");
		int n = Integer.parseInt(strNums[0]); // Vertices
		int e = Integer.parseInt(strNums[1]); // Edges
		if (n == 0) {
			return;
		}
		int edges[][] = new int[n][n]; // Space O(V^2)
		for (int i = 0; i < e; i++) {
			String[] strNums1;
			strNums1 = sc.nextLine().split("\\s"); // Taking edges as input
			int fv = Integer.parseInt(strNums1[0]); // Edge from node
			int sv = Integer.parseInt(strNums1[1]); // Edge to node
			edges[fv][sv] = 1;

			edges[sv][fv] = 1;
		}
		printBFS(edges);
	}
}