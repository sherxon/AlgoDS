package problems.medium;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class ContainerWithMostWater {
    public int maxArea(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int max = 0;
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            max = Math.max(max, Math.min(a[r], a[l]) * (r - l));
            if (a[r] > a[l]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
