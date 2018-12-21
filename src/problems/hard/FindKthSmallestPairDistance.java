package problems.hard;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class FindKthSmallestPairDistance {
    public static void main(String[] args) {
        System.out.println(new FindKthSmallestPairDistance().smallestDistancePair(new int[] {
                2, 2, 2, 3, 3, 3, 4, 4, 4
        }, 34));
        System.out.println(new FindKthSmallestPairDistance().smallestDistancePair(new int[] {
                62, 100, 4
        }, 2));
        System.out.println(new FindKthSmallestPairDistance().smallestDistancePair(new int[] {
                1, 3, 1
        }, 1));
    }

    public int smallestDistancePair(int[] a, int k) {
        if (a == null || a.length == 0)
            return 0;
        int n = a.length;
        int n2 = 1000_000;
        int[] dp = new int[n2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = Math.abs(a[i] - a[j]);
                dp[diff]++;
            }
        }
        int sum = 0;
        for (int i = 0; i < n2; i++) {
            sum += dp[i];
            if (sum >= k)
                return i;
        }
        return 0;

    }
}
