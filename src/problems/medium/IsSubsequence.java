package problems.medium;

/**
 * Created by sherxon on 1/9/17.
 */
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("", "adddfdbdfdfdciiisderefdfdfdf"));
    }
    public static boolean isSubsequence(String s, String t) {
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        int i=0;
        for (int j = 0; j < b.length; j++) {
            if(i<a.length && a[i]==b[j])i++;
            else if(i==a.length)return true;
        }

        return i==a.length;
    }
}
