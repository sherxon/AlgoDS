package interviewquestions.easy;

/**
 * Created by sherxon on 1/9/17.
 */
public class RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String str) {
        char[] a=str.toCharArray();
        int i=1;
        while (i<=a.length/2){
            if(a.length%i==0){
                StringBuilder sb=new StringBuilder();
                String ss=str.substring(0, i);
                while (sb.length()<a.length)
                    sb.append(ss);
                if(sb.toString().equals(str))return true;
            }
            i++;
        }

        return false;
    }
}
