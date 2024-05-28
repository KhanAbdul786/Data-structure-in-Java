//Problem statement
//You are given a N*N maze with a rat placed at maze[0][0]. Find and print all paths that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
//
//Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//0 < N < 11 0 <= Maze[i][j] <=1
//
//Time Limit: 1sec
//Sample Input 1 :
//3
//1 0 1
//1 0 1
//1 1 1
//Sample Output 1 :
//1 0 0 1 0 0 1 1 1 
//Sample Output 1 Explanation :
//Only 1 path is possible
//
//1 0 0
//1 0 0
//1 1 1
//Which is printed from left to right and then top to bottom in one line.
//
//Sample Input 2 :
//3
//1 0 1
//1 1 1
//1 1 1
//Sample Output 2 :
//1 0 0 1 1 1 1 1 1 
//1 0 0 1 0 0 1 1 1 
//1 0 0 1 1 0 0 1 1 
//1 0 0 1 1 1 0 0 1 


package backtracking;

import java.io.*;
import java.util.*;

public class RatInAMazeAllPath {
	/*
	 * Time complexity : O(2^k) Space complexity : O(N^2) where N is the size of
	 * maze and K is the numer of cells in maze with value equal to one(1)
	 */
	static void printsolution(int[][] solution, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(solution[i][j] + " ");
			}
		}
	}

	static void solveMaze(int maze[][], int solution[][], int x, int y, int n) {
		if (x == n - 1 && y == n - 1) {
			solution[x][y] = 1;
			printsolution(solution, n);
			System.out.println();
			return;
		}
		if (x > n - 1 || x < 0 || y > n - 1 || y < 0) {
			return;
		}
		if (x > n - 1 || x < 0 || y > n - 1 || y < 0 || maze[x][y] == 0 || solution[x][y] == 1) {
			return;
		}
		solution[x][y] = 1;
		solveMaze(maze, solution, x - 1, y, n);
		solveMaze(maze, solution, x + 1, y, n);
		solveMaze(maze, solution, x, y - 1, n);
		solveMaze(maze, solution, x, y + 1, n);
		solution[x][y] = 0;
	}

	static void ratInAMaze(int maze[][], int n) {
		int[][] solution = new int[20][20];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				solution[i][j] = 0;
			}
		}
		solveMaze(maze, solution, 0, 0, n);
	}

}
