package algo.sortingandsearching;

/**
 * Created by sherxon on 1/23/17.
 */
public class BinarySearch {
    /**
     * This is binary search algorithm, Time complexity is O(lgN) and does use extra space.
     * This finds any occurrence of given key
     */
    int search(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] == key) return mid; // key found

            if (a[mid] < key) lo = mid + 1;
            else hi = mid - 1;
        }

        return -(lo + 1); // key not found, position to be inserted is returned
    }

    /**
     * When there are duplicates, this finds the first occurrence of the key
     */
    int searchLowerBound(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] == key && (mid == 0 || a[mid - 1] != key)) return mid; // key found

            if (a[mid] < key) lo = mid + 1; // pay attention
            else hi = mid - 1;
        }

        return -(lo + 1); // key not found, position to be inserted is returned
    }

    /**
     * When there are duplicates, this finds the last occurrence of the key
     */
    int searchUpperBound(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] == key && (mid == a.length - 1 || a[mid + 1] != key)) return mid; // key found

            if (a[mid] <= key) lo = mid + 1; // pay attention
            else hi = mid - 1;
        }

        return -(hi + 1); // key not found, position to be inserted is returned
    }
}
