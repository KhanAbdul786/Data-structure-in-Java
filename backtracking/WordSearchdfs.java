//Problem statement
//You are given a 2D board('N' rows and 'M' columns) of characters and a string 'word'.
//
//
//
//Your task is to return true if the given word exists in the grid, else return false. The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
//
//
//
//Note:
//The same letter cell should not be used more than once.
//For Example:
//For a given word “design” and the given 2D board 
//[[q’, ‘v’, ‘m’, ‘h’],
// [‘d’, ‘e’, ‘s’, ‘i’],
// [‘d’, ‘g’, ‘f’, ‘g’],
// [‘e’, ‘c’, ‘p’, ‘n’]]
//
//The word design can be formed by sequentially adjacent cells as shown by the highlighted color in the 2nd row and last column.
//board
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//coding
//4 4
//c z k l
//o d i a
//r g n m
//m r s d
//Sample Output 1:
//true
//Explanation For Sample Input 1:
//For the given word, and grid we can construct from letters of sequentially adjacent cells as shown below:
//board
//
//Sample Input 2:
//ninjas
//4 4
//c d k s
//o d s i
//d g n j
//e r i n
//Sample Output 2:
//false
//Constraints:
//1 <= N <= 6
//1 <= M <= 6
//1 <= |word| <=20
//
//Time Limit: 1 sec
//

package backtracking;

public class WordSearchdfs {
	private static boolean dfs(int i, int j, int n, int m, char[][] board, String word, int k) {
		// Check if the word has been found.
		if (k == word.length())
			return true;
		// Check if the current position is out of bounds or the cell is visited or
		// doesn't match the current letter.
		else if (i < 0 || i == n || j < 0 || j == m || board[i][j] == '#' || board[i][j] != word.charAt(k))
			return false;
		else {
			// Store the value of the current cell.
			char temp = board[i][j];
			// Mark the current cell as visited.
			board[i][j] = '#';
			// Recursively call dfs for the neighboring cells.
			boolean op1 = dfs(i + 1, j, n, m, board, word, k + 1);
			boolean op2 = dfs(i, j + 1, n, m, board, word, k + 1);
			boolean op3 = dfs(i - 1, j, n, m, board, word, k + 1);
			boolean op4 = dfs(i, j - 1, n, m, board, word, k + 1);
			// Restore the original value of the current cell.
			board[i][j] = temp;
			// Return true if any of the neighboring cells found the word.
			return op1 || op2 || op3 || op4;
		}
	}

	public static boolean present(char[][] board, String word, int n, int m) {
		// Checking for each cell on the 'board'.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// If the first letter matches.
				if (board[i][j] == word.charAt(0)) {
					// Call dfs function to check if the word can be formed starting from the
					// current cell.
					if (dfs(i, j, n, m, board, word, 0))
						return true;
				}
			}
		}
		// Word not found on the board.
		return false;
	}

}
