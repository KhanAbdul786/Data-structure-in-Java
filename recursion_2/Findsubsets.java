//Problem statement
//Given an integer array (of length n), find and return all the subsets of input array.
//
//NOTE- Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
//
//Note :
//The order of subsets are not important.
//
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input:
//3
//15 20 12
//Sample Output:
//[] (this just represents an empty array, don't worry about the square brackets)
//12 
//20 
//20 12 
//15 
//15 12 
//15 20 
//15 20 12 




package recursion_2;

public class Findsubsets {
	
	// Return a 2D array that contains all the subsets
		public static int[][] findsubsets(int arr[], int start){
	        
	        //base case
	        //if start pointer reaches the end of array, return empty array
	        int len = arr.length;
	        
	        if (start>len-1){
	            int output[][] = new int[1][0];
	            //output[0][0] = arr[start];
	            return output;
	        }
	        
	        //recursion call
	        
	        //make smallAns array
	        int[][] smallAns = findsubsets(arr, start+1);
	        
	        //make ans array
	        int ans[][] = new int [2*smallAns.length][];
	        
	        //copy elements as it is into the jagged array
	        for(int i = 0; i<smallAns.length; i++){
	            ans[i] = new int[smallAns[i].length];
	            for(int j = 0; j<smallAns[i].length; j++){
	                ans[i][j] = smallAns[i][j];
	            }
	        }
	        
	        //copy elements after adding the first element
	        for(int i = smallAns.length; i<ans.length; i++){
	            ans[i] = new int[smallAns[i-smallAns.length].length+1];
	            ans[i][0] = arr[start];
	            for(int j = 1; j<ans[i].length; j++){
	                ans[i][j] = smallAns[i-smallAns.length][j-1];
	            }
	        }
	        
	        return ans;
		}
		
		public static int[][] subsets(int input[]) {
			// Write your code here

			int start = 0;
	        int[][] jawaab = findsubsets(input,start);
	        return jawaab;

		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
