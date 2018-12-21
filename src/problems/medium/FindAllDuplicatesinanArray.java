package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 1/5/17.
 */

public class FindAllDuplicatesinanArray {

    /**
     * This find all duplicate elements from array. The idea is to negate previous elements. if the previous element
     * is already negative this element is duplicate. Time complexity is O(N) and in-place.
     */
    public List<Integer> findDuplicates(int[] a) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < a.length; ++i) {
            int index = Math.abs(a[i]) - 1;
            if (a[index] < 0)
                list.add(index + 1);
            a[index] *= -1;
        }
        return list;
    }
}
