package interviewquestions.medium;

import java.util.Arrays;

/**
 * Created by sherxon on 2/3/17.
 */
public class Searcha2DMatrixII {

    /**
     * Compare first element of every array and it is smaller than target, it binary searches this row
     */
    boolean searchMatrix(int[][] a, int target) {
        if (a.length == 0 || a[0].length == 0) return false;
        for (int i = 0; i < a.length; i++) {
            int len = a[i].length - 1;
            if (a[i][0] == target || a[i][len] == target) return true;
            if (a[i][0] < target && Arrays.binarySearch(a[i], target) > -1) return true;
            if (a[i][0] > target) return false;
        }
        return false;
    }

    /**
     * We start search the matrix from top right corner, initialize the current position to top right corner,
     * if the target is greater than the value in current position, then the target can not be in entire row
     * of current position because the row is sorted, if the target is less than the value in current position,
     * then the target can not in the entire column because the column is sorted too. We can rule out one row or
     * one column each time,
     * so the time complexity is O(m+n).
     */
    boolean searchMatrix2(int[][] a, int target) {
        if (a.length == 0 || a[0].length == 0) return false;
        int col = a[0].length - 1;
        int row = 0;

        while (row < a.length && col > -1) {
            if (a[row][col] == target) return true;
            if (a[row][col] < target) row++;
            else col--;
        }
        return false;
    }

}
