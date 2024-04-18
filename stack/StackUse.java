package stack;

public class StackUse {

	public static void main(String[] args) throws StackFull, StackEmpty {
//		StackUsingArray stack=new StackUsingArray(10);
//		stack.push(10);
//		stack.push(20);
//		stack.push(30);
//		stack.push(40);
//		stack.push(50);
		
		StackUsingLL stack=new StackUsingLL<>();
		int[] arr= {2,3,4,5,6,7};
		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());

	}

}
