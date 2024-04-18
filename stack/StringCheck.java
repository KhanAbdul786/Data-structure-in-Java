package stack;

public class StringCheck {
	public static int checkString(String str) {
		if (str.length() == 0) {
			return 0;
		}
		int ans = 0;
		int n = str.length();
		int startIndex = 0;
		while (startIndex < n) {
			int nextIndex = startIndex + 1;
			char ch = str.charAt(startIndex);
			while (nextIndex < n && str.charAt(nextIndex) == ch) {
				nextIndex++;
			}
			ans = ans + 1;
			startIndex = nextIndex;
		}
		return ans;
	
		
	}

	public static void main(String[] args) {
		String str="aaabbbccaaad";
		System.out.println(checkString(str));

	}

}
