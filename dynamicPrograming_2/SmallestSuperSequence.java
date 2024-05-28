//Problem statement
// Given two strings S and T with lengths M and N. Find and return the length of their shortest 'Super Sequence'.
//
// The shortest 'Super Sequence' of two strings is defined as the smallest string possible that will have both the given strings as its subsequences.
//
//Note :
//If the two strings do not have any common characters, then return the sum of the lengths of the two strings. 
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= M <= 10 ^ 3
//0 <= N <= 10 ^ 3
//
//Time Limit: 1 sec
//Sample Input 1 :
//ab
//ac
//Sample Output 1 :
//3
//Explanation of Sample Output 1 :
//Their smallest super sequence can be "abc" which has length = 3.
//Sample Input 2 :
//pqqrpt
//qerepct
//Sample Output 2 :
//9

package dynamicPrograming_2;

/*
Time Complexity: O(n*m)
Space Complexity: O(n*m)
where n and m are lengths of input strings
*/
public class SmallestSuperSequence {
	public static int smallestSuperSequence(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int superseq[][] = new int[len1 + 1][len2 + 1];
		for (int p = 0; p <= len1; p++) {
			for (int q = 0; q <= len2; q++) {
				if (p == 0) {
					superseq[p][q] = q;
				} else if (q == 0) {
					superseq[p][q] = p;
				} else if (str1.charAt(p - 1) == str2.charAt(q - 1)) {
					superseq[p][q] = 1 + superseq[p - 1][q - 1];
				} else {
					superseq[p][q] = 1 + Math.min(superseq[p - 1][q], superseq[p][q - 1]);
				}
			}
		}
		return superseq[len1][len2];
	}
}