package problems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sherxon on 5/1/17.
 */
public class StackOfPlates {
    int threshold;
    List<Stack<Integer>> list=new ArrayList<>();

    public void push(Integer n){
        if(list.isEmpty())list.add(new Stack<>());
        getAvailableStack().add(n);
    }
    public Integer pop(){
        if(list.get(list.size()-1).size()==0)
            list.remove(list.get(list.size()-1));
       return list.get(list.size()-1).pop();
    }
    public Integer popAt(int index){
        if(list.get(index).size()==0)
            list.remove(list.get(index));
       return list.get(index).pop();
    }
    private Stack<Integer> getAvailableStack() {
        if(list.get(list.size()-1).size() < threshold)
            return list.get(list.size()-1);
        list.add(new Stack<>());
        return list.get(list.size()-1);
    }


}
