package problems.medium;

import java.util.List;
import java.util.Stack;

/**
 * Created by sherxon on 2/1/17.
 */

public class MiniParser {
    public NestedInteger deserialize(String s) {

        Stack<NestedInteger> stack = new Stack<>();
        char[] a = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a.length; i++) {
            if (a[i] == '[') {

                NestedInteger inn = new NestedInteger();
                if (!stack.isEmpty()) stack.peek().getList().add(inn);
                stack.add(inn);

            } else if (a[i] == ']') {

                if (sb.length() > 0) {
                    Integer n = Integer.parseInt(sb.toString());
                    NestedInteger inn = new NestedInteger(n);
                    stack.peek().getList().add(inn);
                    sb.setLength(0);
                }
                if (stack.size() > 1)
                    stack.pop();
            } else if (a[i] == ',') {
                if (sb.length() > 0) {
                    Integer n = Integer.parseInt(sb.toString());
                    NestedInteger inn = new NestedInteger(n);
                    stack.peek().getList().add(inn);
                    sb.setLength(0);
                }

            } else {
                sb.append(a[i]);
            }
        }
        if (sb.length() > 0) {
            if (stack.isEmpty()) return new NestedInteger(Integer.parseInt(sb.toString()));
            else stack.peek().setInteger(Integer.parseInt(sb.toString()));
        }

        return stack.peek();
    }

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation

    class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return null;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }
}
