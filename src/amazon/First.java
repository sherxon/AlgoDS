package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sherxon on 5/18/17.
 */
public class First {

}
 class Solution {
     public static void main(String[] args) {
        List<List<String>> lists= new ArrayList<>();
        lists.add(Arrays.asList("orange"));
        lists.add(Arrays.asList("apple", "apple"));
        lists.add(Arrays.asList("banana", "orange", "apple"));
        lists.add(Arrays.asList("banana"));
        List<String> list= new ArrayList<>();
        list.add("orange");
        list.add("apple");
        list.add("apple");
        list.add("banana");
        list.add("orange");
        list.add("apple");
        list.add("banana");
         System.out.println(new Solution().checkWinner(lists, list));
     }
    public int checkWinner(List<List<String>> codeList, List<String> shoppingCart){
        if(codeList==null || shoppingCart==null)return 0;
        if(codeList.isEmpty() || shoppingCart.isEmpty())return 0;

        int finder=0;
        for (int i = 0; i < codeList.size(); i++) {
            List<String> current=codeList.get(i);
            finder=getIndex(shoppingCart, current, finder);
            if(finder==-1)
                return 0;
            for (int j = 0; j < current.size(); j++) {
                if(current.get(j).equals("anything") || current.get(j).equals(shoppingCart.get(finder)))
                     finder++;
                else
                    return 0;
            }
        }
        return 1;
    }
    private int getIndex(List<String> shoppingCart, List<String> crt, int finder) {

        String anything1=crt.get(0);

        if(anything1.equals("anything"))
            return finder;

        for (int i = finder; i <shoppingCart.size(); i++) {
            if(shoppingCart.get(i).equals(anything1))
                return i;
        }
        return -1;

    }
    // METHOD SIGNATURE ENDS
}
