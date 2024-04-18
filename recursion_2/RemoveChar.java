//Problem statement
//Given a string, compute recursively a new string where all 'x' chars have been removed.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= |S| <= 10^3
//where |S| represents the length of string S. 
//Sample Input 1 :
//xaxb
//Sample Output 1:
//ab
//Sample Input 2 :
//abc
//Sample Output 2:
//abc
//Sample Input 3 :
//xx
//Sample Output 3:


package recursion_2;

public class RemoveChar {
	public static String removeX(String input) {
		if (input.length() == 0) {
			return "";
		}
		if (input.charAt(0) == 'x') {
			return removeX(input.substring(1));
		}
		return input.charAt(0) + removeX(input.substring(1));
	}

	public static void main(String[] args) {
		String str = "xaxb";
		System.out.println(removeX(str));

	}

}
