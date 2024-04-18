//Problem statement
//Determine if a given string ‘S’ is a palindrome using recursion. Return a Boolean value of true if it is a palindrome and false if it is not.
//
//Note: You are not required to print anything, just implement the function. Example:
//Input: s = "racecar"
//Output: true
//Explanation: "racecar" is a palindrome.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//abbba
//Sample Output 1:
//true
//Explanation Of Sample Input 1 :
//“abbba” is a palindrome
//Sample Input 2:
//abcd
//Sample Output 2:
//false
//Explanation Of Sample Input 2 :
//“abcd” is not a palindrome.
//Constraints:
//0 <= |S| <= 10^6
//where |S| represents the length of string S.


package recursionAssignment;

public class IsPalindrome {
	public static boolean isPalindrome(String str) {
		// Write your code here.

		String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		return isPalindromeRecursive(cleanStr, 0, cleanStr.length() - 1);
	}

	private static boolean isPalindromeRecursive(String str, int left, int right) {
		if (left >= right) {
			return true; // Base case: One character or empty string, it's a palindrome
		}

		if (str.charAt(left) != str.charAt(right)) {
			return false; // Characters don't match, not a palindrome
		}

		return isPalindromeRecursive(str, left + 1, right - 1); // Recurse with updated pointers

	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("aabbaaa"));

	}

}
