package problems.medium;

import java.util.Stack;

/**
 * Created by sherxon on 1/4/17.
 */
public class VerifyPreorderSerializationofBinaryTree {
    public boolean isValidSerialization(String s) {
        if(s==null)return true;
        String[] ss= s.split(",");
        Stack<String> stack= new Stack<>();
        for(String e:ss){
            stack.add(e);

            while(stack.size()>1 && stack.peek().equals("#")){

                String p=stack.pop();
                String p2=stack.peek();

                if(p.equals(p2) && p.equals("#")){
                    stack.pop();
                    if(stack.size()==0)return false;
                    stack.pop();
                    stack.add(p);
                }else{
                    stack.add(p);
                    break;
                }
            }
        }
        return stack.size()==1 && stack.peek().equals("#");
    }
}
