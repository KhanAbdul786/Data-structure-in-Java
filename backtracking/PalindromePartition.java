//Problem statement
//You are given a string 'S'. Your task is to partition 'S' such that every substring of the partition is a palindrome. You need to return all possible palindrome partitioning of 'S'.
//
//Note: A substring is a contiguous segment of a string.
//
//For Example:
//For a given string “BaaB”
//3 possible palindrome partitioning of the given string are:
//{“B”, “a”, “a”, “B”}
//{“B”, “aa”, “B”}
//{“BaaB”}
//Every substring of all the above partitions of “BaaB” is a palindrome.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= |S|<= 15
//where |S| denotes the length of string 'S'.
//
//Time Limit: 1 sec.
//Sample Input 1:
//aaC
//Sample Output 1:
//["C", "a", "a"]
//["C", "aa"]
//Explanation for input 1:
//For the given string "aaC" there are two partitions in which all substring of partition is a palindrome.
//Sample Input 2:
//BaaB
//Sample Output 2:
//["B", "B", "a", "a"]
//["B", "B", "aa"]
//["BaaB"]
//Explanation for input 2:
//For the given string "BaaB", there are 3 partitions that can be made in which every substring is palindromic substrings.
//


package backtracking;

/*
Time Complexity:O(N*2^N)
Space Complexity:O(N^2)
Where N is the length of string.
*/
import java.util.List;
import java.util.ArrayList;

public class PalindromePartition {
	public static List<List<String>> partition(String S) {
// It store all the possible palindromic partitions
		List<List<String>> answer = new ArrayList<>();
// Create a boolean dp for checking substing[i..j] is palindrome or not.
		boolean[][] dp = new boolean[S.length()][S.length()];
		for (int i = 0; i < S.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if (S.charAt(i) == S.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
					dp[j][i] = true;
				}
			}
		}
// Recursive function to generate all the possible palindromic partitions.
		partitionHelper(S, 0, answer, new ArrayList<>(), dp);
		return answer;
	}

	private static void partitionHelper(String S, int start, List<List<String>> answer, List<String> currentList,
			boolean[][] dp) {
// If start reach the end of String.
		if (start >= S.length()) {
// Add the current generated Palindromic Partition to answer List
			answer.add(new ArrayList<>(currentList));
			return;
		}
		for (int k = start; k < S.length(); k++) {
// Check if substring S[start...k] is Palindrome or not
			if (dp[start][k]) {
// Add the substring S[start...k]
				currentList.add(S.substring(start, k + 1));
// Recurence for rest of the string to get all the palindromic partitions
				partitionHelper(S, k + 1, answer, currentList, dp);
// Remove the substring S[start...k] from current partition
				currentList.remove(currentList.size() - 1);
			}
		}
	}
}