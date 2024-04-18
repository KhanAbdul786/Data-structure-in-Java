//Problem statement
//You have been given two stacks that can store integers as the data. Out of the two given stacks, one is populated and the other one is empty. You are required to write a function that reverses the populated stack using the one which is empty.
//
//For Example:
//Alt txt
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^3
//-2^31 <= data <= 2^31 - 1
//
//Time Limit: 1sec 
//Sample Input 1:
//6
//1 2 3 4 5 10
//Note:
//Here, 10 is at the top of the stack.
//Sample Output 1:
//1 2 3 4 5 10
//Note:
//Here, 1 is at the top of the stack.
//Sample Input 2:
//5
//2 8 15 1 10
//Sample Output 2:
//2 8 15 1 10

package stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {
	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		if (input.size() <= 1) {
			return;
		}
		int lastElement = input.pop();
		reverseStack(input, extra);
		while (!input.isEmpty()) {
			int top = input.pop();
			extra.push(top);
		}
		input.push(lastElement);
		while (!extra.empty()) {
			int top = extra.pop();
			input.push(top);
		}
	}
	
	public static Stack<Integer> takeInput() 
    {
        Scanner sr = new Scanner(System.in);
        
    	int size = sr.nextInt();
    	Stack<Integer> input = new Stack<>();

    	if (size == 0) 
    	{
    		return input;
    	}

    	for(int i = 0; i < size; i++) 
    	{
    	    int var = sr.nextInt();
    		input.push(var);
    	}

    	return input;
    }
	public static void main(String[] args) {
		Stack<Integer> input = takeInput();
    	Stack<Integer> empty = new Stack<>();

    	reverseStack(input, empty);

    	while(!input.isEmpty()) 
    	{
    		System.out.print(input.pop() + " ");
    	}
		
	}

}
