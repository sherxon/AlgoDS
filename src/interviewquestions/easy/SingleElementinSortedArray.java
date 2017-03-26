package interviewquestions.easy;

/**
 * Created by sherxon on 3/26/17.
 */
public class SingleElementinSortedArray {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2}));
    }

    static public int singleNonDuplicate(int[] a) {
        if (a.length == 1) return a[0];
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int nei = mid;

            if (mid > 0 && a[mid] == a[mid - 1]) nei = mid - 1;
            else if (mid < a.length - 1 && a[mid] == a[mid + 1]) nei = mid + 1;

            if (mid == nei) return a[mid];
            int left = Math.min(mid, nei);
            if (left % 2 != 0) j = left - 1;
            else i = Math.max(nei, mid) + 1;

        }
        return -1;
    }
}
