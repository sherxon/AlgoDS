package algo.sortingandsearching;


/**
 * Created by sherxon on 12/16/16.
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

    // simple version to understand easier
    public static void sortSimple(int[] a) {
        for (int i = 0; i < a.length; i++) {
            // last elements sorted
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] < a[j - 1]) { //swap
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

}
