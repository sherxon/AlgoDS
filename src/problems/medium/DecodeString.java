package problems.medium;

import java.util.Stack;

/**
 * Created by sherxon on 1/30/17.
 */

public class DecodeString {

    static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] a = s.toCharArray();

        for (int i = 0; i < a.length; i++) {

            if (a[i] == ']') {
                String inString = "";
                while (!stack.isEmpty() && stack.peek() != '[')
                    inString += stack.pop();
                if (stack.peek() == '[') stack.pop();
                StringBuilder num = new StringBuilder();

                while (!stack.isEmpty() && Character.isDigit(stack.peek()))
                    num.append(stack.pop());
                int lim = Integer.parseInt(num.reverse().toString());
                for (int j = 0; j < lim; j++) {
                    for (int k = inString.length() - 1; k >= 0; k--) {
                        stack.add(inString.charAt(k));
                    }
                }

            } else
                stack.push(a[i]);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
