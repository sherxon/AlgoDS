package algo.sortingandsearching;

import java.util.Arrays;

/**
 * Created by sherxon on 2016-12-16.
 */
public class TestSorting {
    public static void main(String[] args) {
        int n = (int) (Math.random() * 10);
        for (int i = 0; i < n; i++) {
            //Integer[] a = new Integer[n];
            int[] a = new int[n];
            for (int j = 0; j < a.length; j++) {
                a[j] = (int) (Math.random() * 10);
            }
            System.out.print(Arrays.toString(a) + " ==>> ");
            CountingSort.sort(a);


        }
    }
}
