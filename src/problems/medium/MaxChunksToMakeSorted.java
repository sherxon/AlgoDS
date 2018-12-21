package problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Why Did you create this class? what does it do?
 */
public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(new int[] { 5, 1, 1, 8, 1, 6, 5, 9, 7, 8 }));
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(new int[] { 0, 0, 1, 1, 1 }));
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(new int[] { 0, 1, 2, 3, 4, 5, 5 }));
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(new int[] { 2, 3, 2, 2 }));
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(new int[] { 2, 3, 2, 3, 3 }));
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(new int[] { 2, 3, 2, 3, 4 }));
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(new int[] { 2, 3, 2, 4, 3 }));
    }

    public int maxChunksToSorted(int[] a) {
        if (a == null || a.length == 0)
            return 0;
        boolean[] aa = new boolean[a.length];
        int max = 0;
        int counter = 0;
        int i = 0;
        int prev = 0;
        while (i < a.length) {
            aa[i] = true;
            max = Math.max(max, a[i]);
            if (isReady(aa, prev, max)) {
                counter++;
                prev = max + 1;
                i = prev;
            } else
                i++;

        }
        return counter;
    }

    boolean isReady(boolean[] a, int from, int to) {
        for (int k = from; k <= to; k++) {
            if (!a[k])
                return false;
        }
        return true;
    }

}
