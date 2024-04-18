package oops_1;



public class DynamicArrayUse {

	public static void main(String[] args) {
		DynamicArray ar=new DynamicArray();
		for (int i = 1; i < 100; i++) {
			ar.add(100+i);
		}
		System.out.println(ar.size());
		System.out.println(ar.get(98));
//		ar.set(2, 170);
		System.out.println(ar.get(2));
//		while(!ar.isEmpty()) {
//			System.out.println(ar.removeLast());
//			System.out.println("size "+ar.size());
//		}
		ar.add(2, 160);
		System.out.println(ar.get(2));

	}

}
