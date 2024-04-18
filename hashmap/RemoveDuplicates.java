package hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {
	public static ArrayList<Integer> removeDuplicates(int[] arr){
		ArrayList<Integer> out=new ArrayList<Integer>();
		HashMap<Integer, Boolean> hm=new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			if(hm.containsKey(arr[i])) {
				continue;
			}
			out.add(arr[i]);
			hm.put(arr[i], true);
			
		}
		return out;
	}

	public static void main(String[] args) {
		int[] arr= {1,3,5,2,5,7,5,4,3,3,7,2,9};
		
		ArrayList<Integer> list=removeDuplicates(arr);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
	}

}
