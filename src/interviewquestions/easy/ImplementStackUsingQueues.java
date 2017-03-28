package interviewquestions.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sherxon on 12/29/16.
 */
public class ImplementStackUsingQueues {

    static class MyStack {
        Queue<Integer> q;
        Queue<Integer> temp;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            q = new LinkedList<>();
            temp = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if (q.isEmpty()) q.add(x);
            else {
                while (!q.isEmpty()) // copy all to helper
                    temp.add(q.poll());
                q.add(x); // add element
                while (!temp.isEmpty()) // copy back all to helper
                    q.add(temp.poll());
            }

        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return q.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return q.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q.isEmpty();
        }
    }
}

