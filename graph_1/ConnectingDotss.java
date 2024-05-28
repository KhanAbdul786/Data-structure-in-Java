//Problem statement
//Gary has a board of size NxM. Each cell in the board is a coloured dot. There exist only 26 colours denoted by uppercase Latin characters (i.e. A,B,...,Z). Now Gary is getting bored and wants to play a game. The key of this game is to find a cycle that contain dots of same colour. Formally, we call a sequence of dots d1, d2, ..., dk a cycle if and only if it meets the following condition:
//
//1. These k dots are different: if i ≠ j then di is different from dj.
//2. k is at least 4.
//3. All dots belong to the same colour.
//4. For all 1 ≤ i ≤ k - 1: di and di + 1 are adjacent. Also, dk and d1 should also be adjacent. Cells x and y are called adjacent if they share an edge.
//Since Gary is colour blind, he wants your help. Your task is to determine if there exists a cycle on the board.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//2 <= N <= 1000
//2 <= M <= 1000
//Time Limit: 1 second
//Sample Input 1:
//3 4
//AAAA
//ABCA
//AAAA
//Sample Output 1:
//true

package graph_1;

/*
Time complexity: O(N * M)
Space complexity: O(N * M)
where N and M are the rows and columns respectively of the board
*/
import java.util.*;

public class ConnectingDotss {
	int[] dx = { 1, -1, 0, 0 };
	int[] dy = { 0, 0, 1, -1 };
	int[][] visited;
	int findCycle = 0;

	void dfs(String[] board, int x, int y, int fromX, int fromY, char needColor, int n, int m) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return;
		if (board[x].charAt(y) != needColor)
			return;
		if (visited[x][y] == 1) {
			findCycle = 1;
			return;
		}
		visited[x][y] = 1;
		for (int f = 0; f < 4; f++) {
			int nextX = x + dx[f];
			int nextY = y + dy[f];
			if (nextX == fromX && nextY == fromY)
				continue;
			dfs(board, nextX, nextY, x, y, needColor, n, m);
		}
	}

	int solve(String[] board, int n, int m) {
		visited = new int[n][m];
		for (int i = 0; i < n; i++)
			Arrays.fill(visited[i], 0);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (visited[i][j] == 0)
					dfs(board, i, j, -1, -1, board[i].charAt(j), n, m);
		return findCycle;
	}
}
