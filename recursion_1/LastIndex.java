package recursion_1;

public class LastIndex {
	/*
	 * public static int lastIndex(int input[], int x) { if (input.length == 0) {
	 * return -1; }
	 * 
	 * int[] small = new int[input.length - 1]; for (int i = 1; i < input.length;
	 * i++) { small[i - 1] = input[i]; } int li = lastIndex(small, x); if (li != -1)
	 * { return li+1; } else { if(input[0]==x) { return 0; } else { return -1; } } }
	 */
	
	public static int lastIndex(int input[],int x,int si) {
		if(si==input.length) {
			return -1;
		}
		int li=lastIndex(input, x, si+1);
		if(li!=-1) {
			return li;
		}
		else {
			if(input[si]==x) {
				return si;
			}
			else {
				return -1;
			}
		}
		
		
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 4, 5, 6 };
//		System.out.println(lastIndex(arr, 5));
		System.out.println(lastIndex(arr, 5, 0));

	}

}
