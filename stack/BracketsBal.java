package stack;

import java.util.Stack;

public class BracketsBal {
	public static boolean isBal(String str) {

		Stack<Character> stack = new Stack<Character>();
		for (int j = 0; j < str.length(); j++) {
			char i = str.charAt(j);
			
			if(i=='[' || i==']' || i=='{' || i=='(') {
				stack.push(i);
			}
			else if (i==']' || i=='}' || i=='}' || i=='}') {
				if(stack.isEmpty()) {
					return false;
				}
				else {
					if(i==']') {
						if(stack.peek()!=']') {
							return false;
						}
						else {
							stack.pop();
						}
					}
					
					else if(i=='}') {
						if(stack.peek()!='}') {
							return false;
						}
						else {
							stack.pop();
						}
					}
					
					if(i==')') {
						if(stack.peek()!=')') {
							return false;
						}
						else {
							stack.pop();
						}
					}
				}
			}
			 
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
