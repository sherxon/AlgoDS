package problems.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sherxon on 2016-12-29.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        char[] a= s.toCharArray();
        Stack<Character> stack= new Stack<>();
        Map<Character, Character> map= new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
        for(int i=0; i < a.length; i++){
            if(a[i] =='(' || a[i] == '{' || a[i] == '['){
                stack.add(a[i]);
            }else{
                if(stack.isEmpty() || stack.peek()!=map.get(a[i]))return false;
                stack.pop();
            }

        }
        return stack.isEmpty();
    }
}
