package interviewquestions.medium;

import java.util.Stack;

/**
 * Created by sherxon on 2/6/17.
 */

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2"}));
    }

    /**
     * To solve this problem, I used stack. if the array element is operator, two elements from stack is popped
     * and do operation according to operator and push back to stack. In this way we calculate the whole expression
     * The last stack element is result of expression
     */
    static int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.length() == 1 && !Character.isDigit(token.charAt(0))) {
                int f = Integer.parseInt(stack.pop());
                int s = Integer.parseInt(stack.pop());
                if (token.equals("+")) stack.push(String.valueOf(f + s));
                else if (token.equals("/")) stack.push(String.valueOf(s / f));
                else if (token.equals("*")) stack.push(String.valueOf(s * f));
                else stack.push(String.valueOf(s - f));
            } else stack.push(token);
        }

        return Integer.parseInt(stack.pop());
    }
}
