//Problem statement
//For a given expression in the form of a string, find if there exist any redundant brackets or not. It is given that the expression contains only rounded brackets or parenthesis and the input expression will always be balanced.
//
//A pair of the bracket is said to be redundant when a sub-expression is surrounded by unnecessary or needless brackets.
//
//Example:
//Expression: (a+b)+c
//Since there are no needless brackets, hence, the output must be 'false'.
//
//Expression: ((a+b))
//The expression can be reduced to (a+b). Hence the expression has redundant brackets and the output will be 'true'.
//Note:
//You will not get a partial score for this problem. You will get marks only if all the test cases are passed.
//Return "false" if no brackets are present in the input.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//0 <= N <= 10^6
//Where N is the length of the expression.
//
//Time Limit: 1 second
//Sample Input 1:
//a+(b)+c 
//Sample Output 1:
//true
//Explanation:
//The expression can be reduced to a+b+c. Hence, the brackets are redundant.
//Sample Input 2:
//(a+b)
//Sample Output 2:
//false

package stack;

import java.util.Stack;

public class CheckRedundantBrackets {
	public static boolean checkRedundantBrackets(String expression) {
		//Your code goes here
		Stack<Character> stack=new Stack<Character>();
        int count=0;
        for(int i=0;i<expression.length();i++)
        {
            char c=expression.charAt(i);
            //System.out.print(c);
            
            if (c==')')
            {
                //System.out.println();
                while(!stack.isEmpty() && stack.peek()!='(')
                {
                    count=count+1;
                    stack.pop();
                    //System.out.print(stack.pop());
                }
                //System.out.println();
                //System.out.println(count);
                if (count==0 || count==1)
                {
                    return true;
                }
                stack.pop();
                count=0;
                
            }
            else
            {
                stack.push(c);
            }
        }
        return false;
	}
}

// ninjas type

/*
 * Time complexity: O(N) Space complexity: O(N) where N is the length of the
 * input expression
 */
//import java.util.Stack;
//
//public class Solution {
//	private static boolean find(char ch) {
//		if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
//			return true;
//		}
//		return false;
//	}
//
//	public static boolean checkRedundantBrackets(String expression) {
//		Stack<Character> stk = new Stack<>();
//		for (int i = 0; i < expression.length(); ++i) {
//			if (expression.charAt(i) == '(' || find(expression.charAt(i))) {
//				stk.push(expression.charAt(i));
//			} else if (expression.charAt(i) == ')') {
//				boolean hasOperator = false;
//				while (!stk.isEmpty() && stk.peek() != '(') {
//					stk.pop();
//					hasOperator = true;
//				}
//				if (!hasOperator) {
//					return true;
//				}
//				if (!stk.isEmpty()) {
//					stk.pop();
//				}
//			}
//		}
//		return false;
//	}
//}
