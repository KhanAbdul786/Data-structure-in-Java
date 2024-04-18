package oops_3;

public class Print {
	public static<T extends PrintInterFace> void printArray(T arr[]) {
		for (int i = 0; i < arr.length; i++) {
			arr[i].print();
//			System.out.println(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		Vehicle v[]=new Vehicle[5];
		for (int i = 0; i < v.length; i++) {
			v[i]=new Vehicle(10*i,"abc");
		}
		
		printArray(v);
	}

}
