//Problem statement
//Given a string S, you need to remove all the duplicates. That means, the output string should contain each character only once. The respective order of characters should remain same, as in the input string.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= Length of S <= 10^8
//Time Limit: 1 sec
//Sample Input 1 :
//ababacd
//Sample Output 1 :
//abcd
//Sample Input 2 :
//abcde
//Sample Output 2 :
//abcde

package hashmap;

import java.util.HashMap;

public class UniqueChar {
	public static String uniqueChar(String str) {
		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Return output and don't print it. Taking
		 * input and printing output is handled automatically.
		 */
		if(str.length()==0) {
			return "";
		}
		String ans="";
		HashMap<Character, Boolean> hs=new HashMap<Character, Boolean>();
		for (int i = 0; i < str.length(); i++) {
			if(!hs.containsKey(str.charAt(i))) {
				hs.put(str.charAt(i), true);
				ans=ans+str.charAt(i);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		String str="ababacd";
		System.out.println(uniqueChar(str));

	}

}
