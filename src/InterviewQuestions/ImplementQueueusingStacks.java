package InterviewQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sherxon on 12/29/16.
 */
public class ImplementQueueusingStacks {

}
class MyQueue {
    Stack<Integer> stack= new Stack<>();
    Queue<Integer> q= new LinkedList<>();

    // Push element x to the back of queue.
    public void push(int x) {
        
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> temp= new Stack<>();
        while(!stack.isEmpty())
            temp.add(stack.pop());
        temp.pop();
        while(!temp.isEmpty())
            stack.add(temp.pop());
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> temp= new Stack<>();
        while(!stack.isEmpty())
            temp.add(stack.pop());
        int i=temp.peek();
        while(!temp.isEmpty())
            stack.add(temp.pop());
        return i;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
