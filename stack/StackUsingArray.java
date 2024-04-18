package stack;

public class StackUsingArray {
	private int[] data;
	private int topIndex;

	public StackUsingArray(int size) {
		data = new int[10];
		topIndex=-1;
	}

	public int size() {
		return topIndex+1;

	}

	public boolean isEmpty() {
		if(topIndex==-1) {
			return true;
		}
		else {
			return false;
		}
	}

	public void push(int value) throws StackFull {
		if(topIndex==data.length-1) {
//			throw new StackFull();
			doubleCapacity();
		}
		
		data[++topIndex]=value;
		
	}

	private void doubleCapacity() {
		
		int temp[] =data;
 		data=new int [data.length*2];
		for(int i=0;i<data.length;i++) {
			data[i]=temp[i];
		}
	}

	public int top() throws StackEmpty {
		if(topIndex==-1) {
			throw new StackEmpty();
		}
		return data[topIndex];
	}

	public int pop() throws StackEmpty {
		if(topIndex==-1) {
			throw new StackEmpty();
		}
		int temp =data[topIndex];
		topIndex--;
		return temp;
		
	}
}
