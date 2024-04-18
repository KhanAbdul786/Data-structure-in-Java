//Problem statement
//Given a string S, remove consecutive duplicates from it recursively.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= |S| <= 10^3
//where |S| represents the length of string
//Sample Input 1 :
//aabccba
//Sample Output 1 :
//abcba
//Sample Input 2 :
//xxxyyyzwwzzz
//Sample Output 2 :
//xyzwz
package recursion_2;

public class RemoveConsecutiveDuplicates {
	public static String removeConsecutiveDuplicates(String s) {
		if(s.length()<=1) {
			return s;
		}
		if(s.charAt(0)==s.charAt(1)) {
			return removeConsecutiveDuplicates(s.substring(1));
		}
		else {
			String small=removeConsecutiveDuplicates(s.substring(1));
			return s.charAt(0)+small;
		}
	}

	public static void main(String[] args) {
		String st="xxxyyyzwwzzz";
		System.out.println(removeConsecutiveDuplicates(st));

	}

}
