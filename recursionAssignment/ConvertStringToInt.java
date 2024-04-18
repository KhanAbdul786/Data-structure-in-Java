//Problem statement
//Write a recursive function to convert a given string into the number it represents. That is input will be a numeric string that contains only numbers, you need to convert the string into corresponding integer and return the answer.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 < |S| <= 9
//where |S| represents length of string S.
//Sample Input 1 :
//00001231
//Sample Output 1 :
//1231
//Sample Input 2 :
//12567
//Sample Output 2 :
//12567

package recursionAssignment;

public class ConvertStringToInt {
	public static int convertStringToInt(String input) {
		if(input.length()==1) {
			System.out.println(input.charAt(0)-'0');
			return input.charAt(0)-'0';
		}
		int smallOut=convertStringToInt(input.substring(0, input.length()-1));
		int lastDigit=input.charAt(input.length()-1)-'0';
		return smallOut*10+lastDigit;
	}

	public static void main(String[] args) {
		System.out.println(convertStringToInt("1231"));

	}

}
