package contests.contest27;

import java.util.Arrays;

/**
 * Created by sherxon on 4/8/17.
 */
public class NextGreaterElement3 {
    public static void main(String[] args) {
        System.out.println(nextGreaterElement(1999999999));
    }

    static public int nextGreaterElement(int n) {
        if (n < 12) return -1;
        char[] c = String.valueOf(n).toCharArray();
        reverse(c, 0, c.length - 1);
        for (int k = 1; k < c.length; k++) {
            if (c[k - 1] > c[k]) {
                int min = Integer.MAX_VALUE;
                int mini = k;
                for (int i = k - 1; i >= 0; i--) {
                    if (c[i] < min && c[i] > c[k]) {
                        min = c[i];
                        mini = i;
                    }
                }
                char temp = c[mini];
                c[mini] = c[k];
                c[k] = temp;
                Arrays.sort(c, 0, k);
                reverse(c, 0, k - 1);
                break;
            }
        }
        reverse(c, 0, c.length - 1);
        int res;
        try {
            res = Integer.parseInt(new String(c));
        } catch (Exception e) {
            return -1;
        }
        return res > n ? res : -1;

    }

    private static void reverse(char[] c, int i, int j) {
        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
    }
}
