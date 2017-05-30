package problems.easy;

/**
 * Created by sherxon on 1/11/17.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (a[mid] == target) return mid;
            if (a[mid] > target) j = mid - 1;
            else i = mid + 1;
        }
        return i;
    }
}
