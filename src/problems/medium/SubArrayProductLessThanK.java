package problems.medium;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Why Did you create this class? what does it do?
 */
public class SubArrayProductLessThanK {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] {
                10, 5, 2, 6
        }, 100));
    }

    static int numSubarrayProductLessThanK(int[] a, int k) {
        if (a == null || a.length == 0 || k == 0)
            return 0;
        int count = 0;
        int ii = 0;
        int jj = 0;
        long sum = 1;
        while (jj < a.length && ii <= jj) {
            if (a[jj] >= k) {
                jj++;
                ii = jj;
                continue;
            }
            if (sum * a[jj] < k) {
                sum *= a[jj];
                count += jj - ii;
                if (a[jj] < k)
                    count++;
                jj++;
            } else {
                sum /= a[ii];
                ii++;
            }
        }
        return count;
    }
}
