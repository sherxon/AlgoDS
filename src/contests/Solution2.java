package contests;

/**
 * Created by sherxon on 2/27/17.
 */
public class Solution2 {
    public static void main(String[] args) {

    }

    static public String shortestPalindrome(String s) {

        if (s.length() <= 1) return s;
        char[] a = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            if (a[j] == a[i]) {
                j--;
                i++;
            } else {
                i = 0;
            }
        }
        System.out.println(s.substring(0, i));

        return sb.toString() + s.substring(i);
    }


}
