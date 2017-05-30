package problems.medium;

/**
 * Created by sherxon on 1/15/17.
 */
public class MaxIncreasingSubsequence {


    static int lengthOfLIS(int[] a) {
        if (a.length == 0) return 0;
        int max = 1;
        int[] b = new int[a.length];
        for (int i = 0; i < b.length; i++) b[i] = 1;
        for (int i = 0; i < a.length; i++) {
            int maxsf = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] > a[j]) {
                    maxsf = Math.max(maxsf, b[j]);
                }
            }
            b[i] += maxsf;
            max = Math.max(max, b[i]);
        }
        return max;
    }
}
