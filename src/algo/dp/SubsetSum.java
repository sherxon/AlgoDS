package algo.dp;

import java.util.Arrays;

/**
 * Created by sherxon on 3/14/17.
 */
public class SubsetSum {
    /**
     * This is DP solution for subsetSum problem. Time complexity is O(n*m)
     */
    boolean subsetSum2(int[] set, int sum) {
        boolean[][] a = new boolean[set.length][sum + 1];
        Arrays.sort(set);
        a[0][set[0]] = true;
        for (int i = 1; i < a.length; i++) {
            a[i - 1][0] = true;
            for (int j = 1; j < a[i].length; j++) {
                if (a[i - 1][j] || j < set[i])
                    a[i][j] = a[i - 1][j];
                else
                    a[i][j] = a[i - 1][j - set[i]];
            }
        }
        return a[set.length - 1][sum];
    }

    /**
     * This is brute force solution to find subset Sum.
     * Time Complexity is O(n^2) and Space Complexity is O(1);
     */
    boolean subsetSum(int[] a, int n, int k) {
        if (k == 0) return true;
        if (n == 0) return false;
        if (a[n - 1] > k) return subsetSum(a, n - 1, k);
        return subsetSum(a, n - 1, k) || subsetSum(a, n - 1, k - a[n - 1]);
    }
}
