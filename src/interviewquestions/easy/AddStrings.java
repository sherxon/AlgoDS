package interviewquestions.easy;

/**
 * Created by sherxon on 1/10/17.
 */
public class AddStrings {

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
