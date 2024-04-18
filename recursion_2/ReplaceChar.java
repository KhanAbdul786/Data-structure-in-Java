//Problem statement
//Given an input string S and two characters c1 and c2, you need to replace every occurrence of character c1 with character c2 in the given string.
//
//Do this recursively.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= Length of String S <= 10^6
//
//Sample Input :
//abacd
//a x
//Sample Output :
//xbxcd
//
//public class Solution {
//
//	public static String replaceCharacter(String input, char c1, char c2) {
//		/* Your class should be named Solution
//		 * Don't write main().
//		 * Don't read input, it is passed as function argument.
//		 * Return output and don't print it.
//		 * Taking input and printing output is handled automatically.
//		 */
//



package recursion_2;

public class ReplaceChar {
	public static String replaceChar(String str, char a, char b) {
		if (str.length() == 0) {
			return str;
		}
		String small=replaceChar(str.substring(1), a, b);
		if(str.charAt(0)=='x') {
			return b+small;
		}else {
			return str.charAt(0)+small;
		}
	}

	public static void main(String[] args) {
		String str = "abxcxdx";
		System.out.println(replaceChar(str, 'x', 'y'));
	}

}
