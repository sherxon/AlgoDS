package interviewquestions.easy;

import java.util.Stack;

/**
 * Created by sherxon on 12/29/16.
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    /** initialize your data structure here. */

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x <= min.peek())
            min.push(x);
    }

    public void pop() {
        int p = stack.pop();
        if (min.peek() == p)
            min.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
