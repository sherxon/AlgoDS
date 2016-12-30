package InterviewQuestions.Easy;

import java.util.Stack;

/**
 * Created by sherxon on 12/29/16.
 */
public class MinStack {
    Stack<Integer> stack= new Stack<>();
    int min=Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(x<min)min=x;
        stack.push(x);

    }

    public void pop() {
        int p=stack.peek();
        stack.pop();
        if(p==min){
            min=Integer.MAX_VALUE;
            for(Integer i:stack){
                min=Math.min(i, min);
            }
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
