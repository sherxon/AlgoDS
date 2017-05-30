package problems.medium;

import java.util.Stack;

/**
 * Created by sherxon on 5/1/17.
 */
/**
* Sort stack elements so that top element is smallest in the stack,using only additional stack.
* */
public class SortStack {
    /**
    *  pop element from stack and push it to helper stack and continue this as long as helper peek is smaller than
     *  stack pop. when top element in stakc is smaller than peek element in helper, move all elements
     *  from helper into stack and push poped stack element into helper.
    * */
   static void sort(Stack<Integer> stack){
        if(stack.size()<=1)return;
        Stack<Integer> helper=new Stack<>();
        Integer pop=stack.pop();
        helper.push(pop);
        while (!stack.isEmpty()){
            if(stack.peek() < helper.peek()){
                pop=stack.pop();
                while (!helper.isEmpty() && helper.peek()>pop){
                    stack.push(helper.pop());
                }
                helper.push(pop);
            }else{
                helper.push(stack.pop());
            }
        }
       while (!helper.isEmpty())stack.push(helper.pop());
    }
}
