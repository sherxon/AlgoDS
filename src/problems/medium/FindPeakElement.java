package problems.medium;

/**
 * Created by sherxon on 2016-12-30.
 */
public class FindPeakElement {
    /**
    * We use two pointers, low and high. if middle element is peak we return it.
    * We continue searching right half if middle element is smaller than middle+1 element
    * else left is searched. Time complexity in O(LgN);
    * */
    public int findPeakElement(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (mid > 0 && mid < a.length - 1 && a[mid] >= a[mid - 1] && a[mid] >= a[mid + 1]) return mid;

            if (mid < a.length - 1 && a[mid] < a[mid + 1])
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }
}
