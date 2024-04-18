package linkedList_1;

import java.util.ArrayList;

public class RemoveDuplicates {
	public static ArrayList<Integer> removeDuplicates(int[] arr) {
		
		ArrayList<Integer> lst=new ArrayList<Integer>();
		lst.add(arr[0]);
		for (int i = 1; i < arr.length-1; i++) {
			if(arr[i]!=arr[i-1]) {
				lst.add(arr[i]);
			}
		}
		return lst;
		
	}

	public static void main(String[] args) {
		int[] arr= {10,10,20,30,30};
		ArrayList<Integer> lst = removeDuplicates(arr);
		for (Integer integer : lst) {
			System.out.println(integer);
		}

	}

}
