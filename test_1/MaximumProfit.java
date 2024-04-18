//Problem statement
//You have made a smartphone app and want to set its subscription price such that the profit earned is maximised. There are certain users who will subscribe to your app only if their budget is greater than or equal to your price.
//
//You will be provided with a list of size N having budgets of subscribers and you need to return the maximum profit that you can earn.
//
//Lets say you decide that price of your app is Rs. x and there are N number of subscribers. So maximum profit you can earn is :
//
// m * x
//where m is total number of subscribers whose budget is greater than or equal to x.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= N <= 10^6
//
//1 <=budget[i]<=9999
//
//Sample Input 1 :
//4
//30 20 53 14
//Sample Output 1 :
//60
//Sample Output 1 Explanation :
//Price of your app should be Rs. 20 or Rs. 30. For both prices, you can get the profit Rs. 60.
//Sample Input 2 :
//5
//34 78 90 15 67
//Sample Output 2 :
//201
//Sample Output 2 Explanation :
//Price of your app should be Rs. 67. You can get the profit Rs. 201 (i.e. 3 * 67).


//import java.util.*;
//import java.lang.*;
//public class solution {
//
//	public static int maximumProfit(int budget[]) {
//		// Write your code here
//
//		 Arrays.sort(budget);
//        /*for (int i=0;i<budget.length;i++)
//        {
//            System.out.print(budget[i]+" ");
//        }*/
//        //System.out.println();
//        
//        int ans=Integer.MIN_VALUE;
//        int n=budget.length;
//        // sort(budget,budget+n);
//    	for(int i=0;i<n;i++)
//    	{
//        	ans=Math.max(ans,budget[i]*(n-i));
//    	}
//    	return ans;
//
//	}
//
//}




package test_1;

public class MaximumProfit {

	
	// ninja solution
	
	public static int[] merge(int arr1[], int arr2[]) {
		int i = 0, j = 0, k = 0;
		int output[] = new int[arr1.length + arr2.length];
		while ((i < arr1.length) && (j < arr2.length)) {
			if (arr1[i] <= arr2[j]) {
				output[k] = arr1[i];
				i++;
				k++;
			} else {
				output[k] = arr2[j];
				k++;
				j++;
			}
		}
		while (i < arr1.length) {
			output[k] = arr1[i];
			i++;
			k++;
		}
		while (j < arr2.length) {
			output[k] = arr2[j];
			j++;
			k++;
		}
		return output;
	}

	public static int[] mergesort(int input[]) {
		if (input.length == 1) {
			int out[] = { input[0] };
			return out;
		}
		int lefthalf[] = new int[input.length / 2];
		int righthalf[] = new int[input.length - (input.length / 2)];
		for (int i = 0; i < lefthalf.length; i++)
			lefthalf[i] = input[i];
		for (int i = 0; i < righthalf.length; i++)
			righthalf[i] = input[lefthalf.length + i];
		lefthalf = mergesort(lefthalf);
		righthalf = mergesort(righthalf);
		input = merge(lefthalf, righthalf);
		return input;
	}

	public static int maximumProfit(int budget[]) {
		budget = mergesort(budget);
		int cost[] = new int[budget.length];
		for (int i = 0; i < budget.length; i++)
			cost[i] = budget[i] * (budget.length - i);
		int max = Integer.MIN_VALUE;
		for (int i : cost) {
			if (i > max)
				max = i;
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
