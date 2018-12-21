package problems.hard;

import problems.medium.MaxChunksToMakeSorted;

/**
 * Why Did you create this class? what does it do?
 */
public class MaxChunksToMakeSorted2 {
    public static void main(String[] args) {
        System.out.println(new MaxChunksToMakeSorted2().maxChunksToSorted(new int[] { 5, 1, 1, 8, 1, 6, 5, 9, 7, 8 }));
        System.out.println(new MaxChunksToMakeSorted2().maxChunksToSorted(new int[] { 0, 0, 1, 1, 1 }));
        System.out.println(new MaxChunksToMakeSorted2().maxChunksToSorted(new int[] { 0, 1, 2, 3, 4, 5, 5 }));
        System.out.println(new MaxChunksToMakeSorted2().maxChunksToSorted(new int[] { 2, 3, 2, 2 }));
        System.out.println(new MaxChunksToMakeSorted2().maxChunksToSorted(new int[] { 2, 3, 2, 3, 3 }));
        System.out.println(new MaxChunksToMakeSorted2().maxChunksToSorted(new int[] { 2, 3, 2, 3, 4 }));
        System.out.println(new MaxChunksToMakeSorted2().maxChunksToSorted(new int[] { 2, 3, 2, 4, 3 }));
    }

    public int maxChunksToSorted(int[] a) {
        if (a == null || a.length == 0)
            return 0;
        int counter = 0;
        for (int i = 0; i < a.length; i++) {
            int last = i;
            int max = a[i];
            int maxi = i;
            int current = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (current > a[j]) {
                    last = j;
                    if (maxi != i && maxi < last)
                        current = max;
                    continue;
                }

                if (max <= a[j]) {
                    max = a[j];
                    maxi = j;
                }
            }
            i = last;
            counter++;
        }

        return counter;
    }

}
