//Problem statement
//Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA” .
//
//There is a path from any cell to all its neighbouring cells. For a particular cell, neighbouring cells are those cells that share an edge or a corner with the cell.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= N <= 1000
//1 <= M <= 1000
//Time Limit: 1 second
//Sample Input 1:
//2 11
//CXDXNXNXNXA
//XOXIXGXIXJX
//Sample Output 1:
//1
//Sample Input 2:
//5 5
//DANDO
//NNINJ
//AXGJC
//INJAA
//CODDI
//Sample Output 2:
//0


package graph_1;

/*
Time complexity: O(N * M)
Space complexity: O(N * M)
where N and M are the rows and columns respectively of the board
*/
public class NMatrix {
	int[][] a = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	String pattern = "CODINGNINJA";
	int[][] used;

	int validPoint(int x, int y, int N, int M) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return 1;
		return 0;
	}

	int DFS(String[] G, int x, int y, int index, int N, int M) {
		if (index == 11)
			return 1;
		used[x][y] = 1;
		int i, newx, newy;
		int found = 0;
		for (i = 0; i < 8; i++) {
			newx = x + a[i][0];
			newy = y + a[i][1];
			if (validPoint(newx, newy, N, M) == 1 && G[newx].charAt(newy) == pattern.charAt(index)
					&& used[newx][newy] == 0) {
				found = found | DFS(G, newx, newy, index + 1, N, M);
			}
		}
		used[x][y] = 0;
		return found;
	}

	int solve(String[] Graph, int N, int M) {
		int i, j, found = 0;
		used = new int[N][M];
		for (i = 0; i < N; i++) {
			for (j = 0, found = 0; j < M; j++) {
				if (Graph[i].charAt(j) == 'C') {
					found = DFS(Graph, i, j, 1, N, M);
					if (found == 1)
						break;
				}
			}
			if (found == 1)
				break;
		}
		return found;
	}

}