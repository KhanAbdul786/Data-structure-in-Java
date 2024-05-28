//Problem statement
//You are given two strings S and T of lengths M and N, respectively. Find the 'Edit Distance' between the strings.
//
//Edit Distance of two strings is the minimum number of steps required to make one string equal to the other. In order to do so, you can perform the following three operations:
//
//1. Delete a character
//2. Replace a character with another one
//3. Insert a character
//Note :
//Strings don't contain spaces in between.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= M <= 10 ^ 3
//0 <= N <= 10 ^ 3
//
//Time Limit: 1 sec
//Sample Input 1 :
//abc
//dc
//Sample Output 1 :
//2
// Explanation to the Sample Input 1 :
// In 2 operations we can make string T to look like string S.
//First, insert character 'a' to string T, which makes it "adc".
//
//And secondly, replace the character 'd' of string T with 'b' from the string S. This would make string T as "abc" which is also string S. 
//
//Hence, the minimum distance.
//Sample Input 2 :
//whgtdwhgtdg
//aswcfg
//Sample Output 2 :
//9


package dynamicPrograming_2;

/*
Time Complexity : O(M * N)
Space Complexity : O(M * N)
Where M and N are the lengths of string 's' and 't' respectively
*/
public class EditDistance {
	private static int editDistanceHelper(String s, String t, int[][] subProblems) {
		if (s.length() == 0) {
			return t.length();
		}
		if (t.length() == 0) {
			return s.length();
		}
		int m = s.length();
		int n = t.length();
		if (subProblems[m][n] != -1) {
			return subProblems[m][n];
		}
		if (s.charAt(0) == t.charAt(0)) {
			int smallAns = editDistanceHelper(s.substring(1), t.substring(1), subProblems);
			subProblems[m - 1][n - 1] = smallAns;
			subProblems[m][n] = 0 + smallAns;
		} else {
			int remove = editDistanceHelper(s.substring(1), t, subProblems);
			subProblems[m - 1][n] = remove;
			int insert = editDistanceHelper(s, t.substring(1), subProblems);
			subProblems[m][n - 1] = insert;
			int substitute = editDistanceHelper(s.substring(1), t.substring(1), subProblems);
			subProblems[m - 1][n - 1] = substitute;
			subProblems[m][n] = 1 + Math.min(remove, Math.min(insert, substitute));
		}
		return subProblems[m][n];
	}

	public static int editDistance(String s, String t) {
		int m = s.length();
		int n = t.length();
		int[][] subProblems = new int[(m + 1)][(n + 1)];
//Assigning all the values with -1
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				subProblems[i][j] = -1;
			}
		}
		return editDistanceHelper(s, t, subProblems);

	}
}
