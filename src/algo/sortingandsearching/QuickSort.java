package algo.sortingandsearching;

/**
 * Created by sherxon on 2/20/17.
 */
public class QuickSort {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;

        int pivot = partition(a, lo, hi);
        sort(a, lo, pivot - 1);
        sort(a, pivot + 1, hi);

    }

    private static int partition(int[] a, int lo, int hi) {
        int pivot = lo + (hi - lo) / 2;
        swap(a, pivot, hi);
        int storeIndex = lo;
        for (int i = lo; i < hi; i++) {
            if (a[i] < a[hi]) {
                swap(a, storeIndex, i);
                storeIndex++;
            }
        }
        swap(a, hi, storeIndex);
        return storeIndex;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
