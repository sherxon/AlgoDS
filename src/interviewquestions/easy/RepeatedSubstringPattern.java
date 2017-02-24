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

    public boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        int i = 2;
        while (i <= n) {
            if (n % i == 0) {
                String ss = s.substring(0, n / i);
                boolean b = true;
                for (int j = n / i; j < n; j += n / i) {
                    if (!ss.equals(s.substring(j, j + n / i))) {
                        b = false;
                        break;
                    }
                }
                if (b) return true;
            }
            i++;
        }
        return false;
    }
}
