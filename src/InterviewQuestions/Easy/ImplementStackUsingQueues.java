package InterviewQuestions.Easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sherxon on 12/29/16.
 */
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack myStack= new MyStack();
        myStack.push(2);
        myStack.pop();
        System.out.println(myStack.empty());
    }
}
class MyStack {
    Queue<Integer> q= new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(q.size()==1) q.poll();
        Queue<Integer> temp= new LinkedList<>();
        for(int i=0; i<q.size(); i++)
            temp.add(q.poll());
        q=temp;
    }

    // Get the top element.
    public int top() {
        if(q.size()==1)return q.peek();
        Queue<Integer> temp= new LinkedList<>();
        for(int i=0; i<q.size(); i++)
            temp.add(q.poll());
        int j=q.peek();
        temp.add(q.poll());
        q=temp;
        return j;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
