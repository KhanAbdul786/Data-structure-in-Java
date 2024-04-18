package recursion_2;

public class ReplacePi {
	public static String replacePi(String str) {
		if(str.length()<=1) {
			return str;
		}
		if(str.charAt(0)=='p' &&str.charAt(1)=='i') {
			//call recursion on string length n-2
			String small=replacePi(str.substring(2));
			return "3.14"+small;
		}
		else {
			//call recursion on string length n-1
			String small=replacePi(str.substring(1));
			return str.charAt(0)+small;
		}
	}

	public static void main(String[] args) {
		String str="apiapipipiip";
		System.out.println(replacePi(str));

	}

}
