package interviewquestions.easy;

import java.util.Stack;

/**
 * Created by sherxon on 12/29/16.
 */
public class ImplementQueueusingStacks {

    static class MyQueue {
        Stack<Integer> stack;
        Stack<Integer> helper;
        Integer peek = null;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new Stack<>();
            helper = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack.push(x);
            if (peek == null) peek = x;
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            helper.clear();

            while (!stack.isEmpty())
                helper.push(stack.pop());
            int x = helper.pop();

            if (!helper.isEmpty())
                peek = helper.peek();
            else peek = null;

            while (!helper.isEmpty())
                stack.push(helper.pop());
            return x;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return peek;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.isEmpty();
        }
    }

}