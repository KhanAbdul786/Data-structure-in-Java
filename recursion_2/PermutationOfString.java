//Problem statement
//Given a string S, find and return all the possible permutations of the input string.
//
//Note 1 : The order of permutations is not important. Note 2 : If original string contains duplicate characters, permutations will also be duplicates.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input :
//abc
//Sample Output :
//abc
//acb
//bac
//bca
//cab
//cba

package recursion_2;

public class PermutationOfString {

	public static String[] permutationOfString(String input) {
		if (input.length() == 0) {
			String output[] = { "" };
			return output;
		}
		String[] smallerOutput = permutationOfString(input.substring(1));
		String output[] = new String[input.length() * smallerOutput.length];
		int k = 0;
		for (int i = 0; i < smallerOutput.length; i++) {
			String currentString = smallerOutput[i];
			for (int j = 0; j <= currentString.length(); j++) {
				output[k] = currentString.substring(0, j) + input.charAt(0) + currentString.substring(j);
				k++;
			}
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
