package dynamicPrograming_2;

public class LongestCommonSubsequenceIterative {
	public static int lcs(String s, String t) {
		int m = s.length();
		int n = t.length();

		int[][] dp = new int[m + 1][n + 1];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int ans;
				if (s.charAt(i) == t.charAt(i)) {
					ans = 1 + dp[i + 1][j + 1];
				} else {
					int ans1 = dp[i][j + 1];
					int ans2 = dp[i + 1][j];
					ans = Math.max(ans1, ans2);
				}
				dp[i][j] = ans;
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		String s = "bedgmc";
		String t = "abdfglc";
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		int ans = lcs(s, t);
		System.out.println(ans);
	}

}
