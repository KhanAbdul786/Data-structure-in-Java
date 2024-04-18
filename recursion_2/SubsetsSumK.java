//Problem statement
//Given an array A of size n and an integer K, return all subsets of A which sum to K.
//
//Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
//
//
//Note :
//The order of subsets are not important.
//
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= n <= 20
//
//Sample Input :
//9 
//5 12 3 17 1 18 15 3 17 
//6
//Sample Output :
//3 3
//5 1




package recursion_2;

public class SubsetsSumK {
	
	// Return a 2D array that contains all the subsets which sum to k
		private static int[][] subsetsSumK (int input[], int k, int start, int end){
	        
	        if (start > end){
	            if (k==0){
	                int[][] output = new int[1][0];
	                return output;
	            }
	            else{
	                int[][] output = new int[0][0];
	                return output;
	            }
	        }
	        
	        int[][] smallAns1 = subsetsSumK(input, k-input[start], start + 1, end);
	        int[][] smallAns2 = subsetsSumK(input, k, start+1, end);
	        
	        //initialize rows
	        int[][] ans = new int[smallAns1.length + smallAns2.length][];
	        //loop over smallAns1 rows
	        for(int i = 0; i<smallAns1.length;i++){
	            //add columns len + 1
	            ans[i] = new int[smallAns1[i].length + 1];
	            //add first element
	            ans[i][0] = input[start];
	            //add remaining elements
	            for(int j = 0; j<smallAns1[i].length; j++){
	                ans[i][j+1] = smallAns1[i][j];
	            }
	        }
	        
	        //copy smallAns2 k elements
	        
	        //loop over smallAns2 elements
	        for(int i = 0; i<smallAns2.length; i++){
	            //add columns after smallAns1 ki length
	            ans[i + smallAns1.length] = new int[smallAns2[i].length];
	            for(int j = 0; j<smallAns2[i].length; j++){
	                ans[i + smallAns1.length][j] = smallAns2[i][j];
	            }
	        }
	        
	        return ans;
	    }

		// Return a 2D array that contains all the subsets which sum to k
		public static int[][] subsetsSumK(int input[], int k) {
			// Write your code here
	        int start = 0;
	        int end = input.length-1;
	        int[][] jawaab = subsetsSumK(input, k, start, end);
	        return jawaab;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
