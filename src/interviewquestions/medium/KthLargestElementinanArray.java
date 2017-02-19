package interviewquestions.medium;

/**
 * Created by sherxon on 12/26/16.
 */
public class KthLargestElementinanArray {
    /**
    * This is quick select algorithm and average time complexity is O(N).
    * We use k as a pivot.
    * */
    public int findKthLargest(int[] nums, int k) {


        return partition(nums, 0, nums.length - 1, nums.length - k);
    }

    /*
    * This is main point. This method rearranges the array in a way that all elements less than pivot
    * are on left side of pivot and others on right. It then returns index of the pivot element.
    * */
    int partition(int[] a, int lo, int hi, int k) {
        int p = lo + (hi - lo) / 2;
        int storeIndex = lo;
        swap(a, p, hi);
        for (int i = lo; i < hi; i++) {
            if (a[i] < a[hi]) {
                swap(a, i, storeIndex);
                storeIndex++;
            }
        }

        swap(a, storeIndex, hi);
        if (storeIndex == k)
            return a[storeIndex];
        else if (k < storeIndex)
            return partition(a, lo, storeIndex - 1, k);
        else
            return partition(a, storeIndex + 1, hi, k);
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
