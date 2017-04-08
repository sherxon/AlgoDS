package algo.sortingandsearching;


/**
 * Created by sherxon on 2016-12-16.
 */
// Time Complexity -> O(n^2);
// Memory Complexity -> O(1);
// never use this

public class BubbleSort {

    public static <T extends Comparable> void sort(T[] a) {
        for (int i = 0; i < a.length; i++) {
            // last i elements are already in sorted
            for (int j = 1; j < a.length - i; j++) {
                if (a[j - 1].compareTo(a[j]) > 0) {
                    T temp = a[j - 1]; // swap
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * This is simple version of in-place, stable bubble sort, whose best case is O(n) and worst Case O(n^2);
     */
    public static void sortSimple(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean sorted = true; // flag to check if any swapping made
            // last elements sorted
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] < a[j - 1]) { //swap
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                    sorted = false;
                }
            }
            // if any swapping has not occurred in the last iteration, we can say it is sorted now
            if (sorted) break;
        }
    }

}
