package interviewquestions.medium;

import java.util.Arrays;

/**
 * Created by sherxon on 2/9/17.
 */
public class DecodeWays {
    public static void main(String[] args) {
        /*
        * 1 -> 1
        * 12-> 1,2 | 12
        *
        * 9 -> 9
        * 98-> 9,8
        *
        * 123-> 1,2,3  | 12,3 -> 1,23
        * 1234 -> 1,2,3,4 | 12,3,4 | 1,23,4
        *
        * 121->1,2,1 | 12,1 ->1,21
        * 1212->1,2,1,2 | 12,1,2 | 1,21,2 -> 1,2,12 | 12,12
        * 12121->1,2,1,2,1 | 12,1,2,1 | 1,21,2,1 | 1,2,12,1 | 12,12,1 -> 1,2,1,21 | 1,2,1,21 | 1,21,21
        * */
        System.out.println(new DecodeWays().numDecodings("11210"));
    }

    public int numDecodings(String s) {
        if (s.length() == 0 || s.startsWith("0")) return 0;
        if (s.length() == 1) return 1;
        int[] a = find(s, s.length());
        return a[1];
    }

    private int[] find(String s, int i) {
        if (i == 1) return new int[]{1, 1};
        int[] a = find(s, i - 1);
        int n = Integer.parseInt(s.substring(i - 2, i));
        int temp = a[1];
        if (n < 27 && n != 10 && n != 20 && n > 9) a[1] += a[0];
        if (n == 10 || n == 20) {
            temp = a[0];
            a[1] -= (a[1] - a[0]);
        }
        a[0] = temp;
        System.out.println(Arrays.toString(a));
        return a;
    }
}
