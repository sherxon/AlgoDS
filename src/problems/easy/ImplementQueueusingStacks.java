package problems.easy;

import java.util.Stack;

/**
 * Created by sherxon on 2016-12-29.
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

    /**
    * This is the second optimized solution with
    * */
    public class MyQueue2 {
        Stack<Integer> stack;
        Stack<Integer> helper;

        /** Initialize your data structure here. */
        public MyQueue2() {
            stack= new Stack<>();
            helper= new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(helper.isEmpty()){

                while(!stack.isEmpty())
                    helper.push(stack.pop());
            }

            return helper.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(helper.isEmpty()){

                while(!stack.isEmpty())
                    helper.push(stack.pop());
            }
            return helper.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return helper.isEmpty() && stack.isEmpty();
        }
    }
}