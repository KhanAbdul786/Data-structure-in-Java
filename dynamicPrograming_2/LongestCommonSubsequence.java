//Problem statement
//Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'.
//
//For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same relative order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.
//
//Example :
//Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= M <= 10 ^ 3
//0 <= N <= 10 ^ 3
//
//Time Limit: 1 sec
//Sample Input 1 :
//adebc
//dcadb
//Sample Output 1 :
//3
//Explanation of the Sample Output 1 :
//Both the strings contain a common subsequence 'adb', which is the longest common subsequence with length 3. 
//Sample Input 2 :
//ab
//defg
//Sample Output 2 :
//0
//Explanation of the Sample Output 2 :
//The only subsequence that is common to both the given strings is an empty string("") of length 0.


package dynamicPrograming_2;

public class LongestCommonSubsequence {
	public static int lcs(String s, String t) {
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j <= t.length(); j++) {
				dp[i][j] = -1;
			}
		}
		return lcsdp(s, t, 0, 0, dp);
	}

	private static int lcsdp(String s, String t, int i, int j, int[][] dp) {
		if (s.length() == i || t.length() == j) {
			return 0;
		}
		if (s.charAt(i) == t.charAt(j)) {
			int subProblm;
			if (dp[i + 1][j + 1] == -1) {
				subProblm = lcsdp(s, t, i + 1, j + 1, dp);
				dp[i + 1][j + 1] = subProblm;
			} else {
				subProblm = dp[i + 1][j + 1];
			}
			return 1 + subProblm;
		} else {
			int m;
			if (dp[i + 1][j] == -1) {
				m = lcsdp(s, t, i + 1, j, dp);
				dp[i + 1][j] = m;
			} else {
				m = dp[i + 1][j];
			}
			int n;
			if (dp[i][j + 1] == -1) {
				n = lcsdp(s, t, i, j + 1, dp);
				dp[i][j + 1] = n;
			} else {
				n = dp[i][j + 1];
			}
			return Math.max(m, n);
		}
	}
}
