package problems.medium;

/**
 * Created by sherxon on 1/10/17.
 */
public class RemoveKDigits {

     String removeKdigits(String a, int k) {
        StringBuilder sb=new StringBuilder(a);
        while (k>0){
            int i=1;
            while (i<sb.length()){
                if(sb.charAt(i-1)>sb.charAt(i)) break;
                i++;
            }
            sb.delete(i-1, i);
            while (sb.length()>0 && sb.charAt(0)=='0')
                sb.delete(0, 1);
            k--;
        }
        return sb.length()==0 ? "0" : sb.toString();
    }
}
