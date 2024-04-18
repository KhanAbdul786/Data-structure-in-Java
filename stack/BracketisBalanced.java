//Problem statement
//For a given a string expression containing only round brackets or parentheses, check if they are balanced or not. Brackets are said to be balanced if the bracket which opens last, closes first.
//
//
//
//Example:
//Expression: (()())
//Since all the opening brackets have their corresponding closing brackets, we say it is balanced and hence the output will be, 'true'.
//You need to return a boolean value indicating whether the expression is balanced or not.
//
//Note:
//The input expression will not contain spaces in between.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^7
// Where N is the length of the expression.
//
//Time Limit: 1sec
//Sample Input 1 :
//(()()())
//Sample Output 1 :
//true
//Sample Input 2 :
//()()(()
//Sample Output 2 :
//false
//Explanation to Sample Input 2:
//The initial two pairs of brackets are balanced. But when you see, the opening bracket at the fourth index doesn't have its corresponding closing bracket which makes it imbalanced and in turn, making the whole expression imbalanced. Hence the output prints 'false'.

/// ninjas coding

package stack;

import java.util.Stack;

public class BracketisBalanced {

	public static boolean isBalanced(String expression) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i)=='(') {
				stack.push(expression.charAt(i));	
			}
			else if (expression.charAt(i)==')') {
				if (stack.isEmpty()) {
					return false;
				}
				char topChar=stack.pop();
				if(expression.charAt(i)==')' && topChar=='(') {
					continue;
				}else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

//	public static boolean isBalanced(String expression) {
//		// Your code goes here
//		Stack<Character> stack = new Stack<Character>();
//		for (int j = 0; j < expression.length(); j++) {
//			char i = expression.charAt(j);
//			if (i == '[' || i == '{' || i == '(') {
//				stack.push(i);
//			} else if (i == ']' || i == '}' || i == ')') {
//				if (stack.isEmpty())
//					return false;
//
//				else {
//					if (i == ']') {
//						if (stack.peek() != '[')
//							return false;
//						else
//							stack.pop();
//					}
//
//					else if (i == '}') {
//						if (stack.peek() != '{')
//							return false;
//						else
//							stack.pop();
//					}
//
//					else if (i == ')') {
//						if (stack.peek() != '(')
//							return false;
//						else
//							stack.pop();
//					}
//				}
//			}
//
//		}
//		return stack.isEmpty();
//	}
	
	
	
}
