package problems.medium;

/**
 * Created by sherxon on 1/2/17.
 */
public class MaximumSubarray {

    /**
    * We use two max, maxSoFar -> max sub array found so far and maxEndingHere -> maximum sub array size
    * that ends in this index. This is in place solution and time Complexity is O(N).
    * */
    public int maxSubArray(int[] a) {

        if (a == null || a.length == 0) return 0;

        int maxSoFar = a[0];
        int maxEndingHere = a[0];

        for (int i = 1; i < a.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + a[i], a[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
