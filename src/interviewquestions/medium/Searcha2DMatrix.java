package interviewquestions.medium;

import java.util.Arrays;

/**
 * Created by sherxon on 2/3/17.
 */
public class Searcha2DMatrix {

    static boolean searchMatrix(int[][] a, int target) {
        if (a.length == 0 || a[0].length == 0) return false;

        for (int i = 0; i < a.length; i++) {
            int len = a[i].length - 1;
            if (target == a[i][len] || target == a[i][0]) return true;
            if (target < a[i][len])
                return Arrays.binarySearch(a[i], target) > -1;
        }
        return false;
    }

}
