package problems.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 1/13/17.
 * Time complexity:  O(n^2)
 * Space complexity: O(n^2)
 */

public class FourSumII {
    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b.length; j++)
                if (!map.containsKey(a[i] + b[j]))
                    map.put(a[i] + b[j], 1);
                else
                    map.put(a[i] + b[j], map.get(a[i] + b[j]) + 1);

        int counter = 0;
        for (int i = 0; i < c.length; i++)
            for (int j = 0; j < d.length; j++) {
                int target = 0 - (c[i] + d[j]);
                if (map.containsKey(target))
                    counter += map.get(target);
            }
        return counter;
    }
}
