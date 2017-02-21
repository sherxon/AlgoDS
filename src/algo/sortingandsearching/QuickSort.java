package algo.sortingandsearching;

import java.util.Arrays;

/**
 * Created by sherxon on 2/20/17.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[]{4, 3, 1, 2};
        sort(a);
        System.out.println(Arrays.toString(a));
        countPrimes(50);
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        int pivot = lo + (hi - lo) / 2;

    }


    static int countPrimes(int n) {
        boolean[] a = new boolean[n];
        Arrays.fill(a, true);

        for (int i = 2; i < n / 2; i++) {
            if (a[i]) {
                for (int j = i * 2; j < n; j += i)
                    a[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (a[i]) {
                System.out.print(i + " ");
                count++;
            }
        }
        return count;

    }
}
