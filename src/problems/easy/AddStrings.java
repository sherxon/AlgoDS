package problems.easy;

/**
 * Created by sherxon on 1/10/17.
 */

/**
 * Problem: Given two non-negative integers a and b (length of a and b < 5100) represented as string, return the sum of a and b.
 */
public class AddStrings {
    /**
     * Start adding from the least significant digit.
     */
   static String addStrings(String a, String b) {
       int i=a.length()-1;
       int j=b.length()-1;
       int carry=0;
       StringBuilder sb= new StringBuilder();
       while (i>=0 || j>=0){
           int aa=0;
           int bb=0;
           if(i>=0)
               aa=a.charAt(i--)-'0';
           if(j>=0)
               bb=b.charAt(j--)-'0';

           int sum=(aa+bb+carry);
           sb.append(sum%10);
           carry=sum/10;
       }
       sb=sb.reverse();
       if(carry>0)sb.insert(0, carry);
        return sb.toString();
    }
}
