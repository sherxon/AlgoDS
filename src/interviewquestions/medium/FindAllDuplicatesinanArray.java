package interviewquestions.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 1/5/17.
 */

public class FindAllDuplicatesinanArray {

    public static void main(String[] args) {
        int n=43261596;
        String padding = "00000000000000000000000000000000";
        String result = padding + Integer.toBinaryString(n);
        result = result.substring(result.length() - 32, result.length());  // take the right-most 64 digits
        char[] a=result.toCharArray();
        StringBuilder sb= new StringBuilder();
        for(int i=a.length-1; i>=0; i--)
            sb.append(a[i]);
        System.out.println(Integer.parseUnsignedInt(sb.toString(), 2));
    }

    /**
    * This find all duplicate elements from array. The idea is to negate previous elements. if the previous element
    * is already negative this element is duplicate. Time complexity is O(N) and in-place.
    * */
    public List<Integer> findDuplicates(int[] a) {

        List<Integer> list=new ArrayList<>();

        for(int i=0; i<a.length; ++i){
            int index=Math.abs(a[i])-1;
            if(a[index]<0)
                list.add(Math.abs(index+1));
            a[index]=-a[index];
        }
        return list;
    }
}
