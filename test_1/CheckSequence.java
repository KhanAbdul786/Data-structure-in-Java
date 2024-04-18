//Problem statement
//Given two string s and t, write a function to check if s contains all characters of t (in the same order as they are in string t).
//
//Return true or false.
//
//Do it recursively.
//
//E.g. : s = “abchjsgsuohhdhyrikkknddg” contains all characters of t=”coding” in the same order. So function will return true.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//abchjsgsuohhdhyrikkknddg
//coding
//Sample Output 1 :
//true
//Sample Input 2 :
//abcde
//aeb
//Sample Output 2 :
//false

//public static boolean checkSequence(String a, String b, int a_idx, int b_idx)
//   {
//       if (b_idx==b.length())
//       {
//           return true;
//       }
//       if (a_idx==a.length())
//       {
//           return false;
//       }
//       if (b.charAt(b_idx)==a.charAt(a_idx))
//       {
//           return checkSequence(a,b,a_idx+1,b_idx+1);
//       }
//       else
//       {
//           return checkSequence(a,b,a_idx+1,b_idx);
//       }
//       
//   }

package test_1;

public class CheckSequence {

	public static boolean checkSequence(String a, String b) {
		if (b.length() == 0) {
			return true;
		}
		if (a.length() == 0) {
			return false;
		}
		if (a.charAt(0) == b.charAt(0)) {
			return checkSequence(a.substring(1), b.substring(1));
		} else {
			return checkSequence(a.substring(1), b);
		}
	}

	public static void main(String[] args) {
		System.out.println(checkSequence("abcde", "ace"));

	}

}
