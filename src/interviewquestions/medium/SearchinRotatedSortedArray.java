package interviewquestions.medium;

/**
 * Created by sherxon on 2/11/17.
 */

import java.util.Arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become  3 4 5 6 7 0 1 2 3).
 */
public class SearchinRotatedSortedArray {

    /**
     * Solution is easy, we first find rotated pivot index and binary search both sides of pivot.
     * Time complexity is Log(N);
     */
    int search(int[] a, int target) {

        int pivot = findPivot(a); //find rotated point

        int left = Arrays.binarySearch(a, 0, pivot, target); // search left of array
        if (left > -1) return left;
        int right = Arrays.binarySearch(a, pivot, a.length, target); // search right of array
        if (right > -1) return right;
        return -1;
    }

    private int findPivot(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            //System.out.println(lo + " " + mid + " " + hi);
            if (mid == lo || mid == hi) {
                if (a[lo] < a[hi]) return lo;
                else return hi;
            }
            if (a[mid] < a[hi]) hi = mid;
            else if (a[mid] > a[hi]) lo = mid;
            else return mid;
        }
        return lo;
    }
}
