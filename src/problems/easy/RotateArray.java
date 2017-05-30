package problems.easy;

/**
 * Created by sherxon on 2016-12-27.
 */

public class RotateArray {

    /**
    * The idea is simple. First we will reverse all array elements. Then do another reversion of elements
    * up to given kth-1 index and the of part of the array. Voila! rotated :)
    * Time complexity is O(N) + O(N) = O(N);
    * */
    public void rotate(int[] a, int k) {
        k %= a.length;
        reverse(a, 0, a.length - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, a.length - 1);
    }

    private void reverse(int[] a, int lo, int hi) {
        while (lo < hi) {
            int temp = a[lo];
            a[lo] = a[hi];
            a[hi] = temp;
            lo++;
            hi--;
        }
    }
}
