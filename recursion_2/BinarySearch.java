package recursion_2;

public class BinarySearch {
	public static int search(int[] ar,int si,int ei,int x) {
		if(si>ei) {
			return -1;
		}
		int mid=(si+ei)/2;
		if(ar[mid]==x) {
			return mid;
		}else if(ar[mid]<x){
			return search(ar, mid+1, ei, x);
		}
		else{
			return search(ar, si, mid-1, x);
		}
	}

	public static void main(String[] args) {
		int[] ar= {1,2,3,4,5,6,7};
		System.out.println(search(ar, 0, ar.length-1, 4));

	}

}
