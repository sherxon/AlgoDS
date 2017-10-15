package problems.easy;

import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] a) {
        if (a == null || a.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            String s = a[i];
            if (s.equals("D")) {
                stack.add(stack.peek() * 2);
            } else if (s.equals("C")) {
                stack.pop();
            } else if (s.equals("+")) {
                int top = stack.pop();
                int sc = stack.peek() + top;
                stack.add(top);
                stack.add(sc);
            } else {
                stack.add(Integer.parseInt(s));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
