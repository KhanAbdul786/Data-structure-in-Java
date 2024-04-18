//Problem statement
//You are given the starting 'l' and the ending 'r' positions of the array 'ARR'.
//
//
//
//You must sort the elements between 'l' and 'r'.
//
//
//
//Note:
//Change in the input array itself. So no need to return or print anything.
//Example:
//Input: ‘N’ = 7,
//'ARR' = [2, 13, 4, 1, 3, 6, 28]
//
//Output: [1 2 3 4 6 13 28]
//
//Explanation: After applying 'merge sort' on the input array, the output is [1 2 3 4 6 13 28].
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//7
//2 13 4 1 3 6 28
//Sample Output 1:
//1 2 3 4 6 13 28
//Explanation of Sample Output 1:
//After applying 'merge sort' on the input array, the output is [1 2 3 4 6 13 28].
//Sample Input 2:
//5
//9 3 6 2 0
//Sample Output 2:
//0 2 3 6 9
//Explanation of Sample Output 2:
//After applying 'merge sort' on the input array, the output is [0 2 3 6 9].
//Constraints :
//1 <= N <= 10^3
//0 <= ARR[i] <= 10^9

//SOlution 

//public static void mergeSort(int[] arr,int start,int mid,int end){
//        int n1=mid-start+1;
//        int n2=end-mid;
//
//        int[] s1 =new int[n1];
//        int[] s2 = new int[n2];
//
//        for(int i=0;i<n1;i++){
//            s1[i]=arr[start+i];
//        }
//        for(int i=0;i<n2;i++){
//            s2[i]=arr[mid+1+i];
//        }
//
//        int i=0;
//        int j=0;
//        int k=0;
//
//        k=start;
//
//        while(i<n1 && j< n2){
//            if(s1[i]<=s2[j]){
//                arr[k]=s1[i];
//                i++;
//                k++;
//            }else{
//                arr[k]=s2[j];
//                j++;
//                k++;
//            }
//        }
//        while(i<n1){
//            arr[k]=s1[i];
//            i++;
//            k++;
//        }
//        while(j<n2){
//            arr[k]=s2[j];
//            j++;
//            k++;
//        }
//        
//    }
//    public static void mergeSort(int[] arr, int l, int r){
//        // Write your code here
//        if(l<r){
//            int mid = (l+r)/2;
//            mergeSort(arr, l, mid);
//            mergeSort(arr, mid+1, r);
//            mergeSort(arr, l,mid, r);
//        }
//
//    }
//}



package recursion_2;

public class MergeSort {
	public static void mergeSort(int[] arr) {
		if(arr.length<=1) {
			return;
		}
		int[] a=new int[arr.length/2];
		int[] b=new int[arr.length-a.length];
		
		for(int i=0;i<arr.length/2;i++) {
			a[i]=arr[i];
		}
		for(int i=arr.length/2;i<arr.length;i++) {
			b[i-arr.length/2]=arr[i];
		}
		
		mergeSort(a);
		mergeSort(b);
		
		merge(a,b,arr);
	}

	private static void merge(int[] a, int[] b, int[] a2) {
		int i=0;
		int j=0;
		int k=0;
		while(i<a.length && j<b.length) {
			if(a[i]<=b[j]) {
				a2[k]=a[i];
				i++;
				k++;
			}
			else {
				a2[k]=b[j];
				j++;
				k++;
			}
		}
		while(i<a.length) {
			a2[k]=a[i];
			i++;
			k++;
		}
		while(j<b.length) {
			a2[k]=b[j];
			j++;
			k++;
		}
		
	}

	public static void main(String[] args) {
		int[] arr= {3,4,6,12,2,5,7,8,9};
		mergeSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
