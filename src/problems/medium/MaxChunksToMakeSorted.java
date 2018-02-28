package problems.medium;

/**
 * Why Did you create this class? what does it do?
 */
public class MaxChunksToMakeSorted {

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
