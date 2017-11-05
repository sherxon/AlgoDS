package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Why Did you create this class? what does it do?
 */
public class MaximumLengthOfRepeatedSubArray {
    public static void main(String[] args) {
        System.out.println(new MaximumLengthOfRepeatedSubArray().findLength(
                new int[] {
                        1, 2, 3, 2, 1
                },
                new int[] {
                        3, 2, 1, 4, 7
                }
        ));
    }

    public int findLength(int[] a, int[] b) {
        if (a == null || b == null || a.length == 0 || b.length == 0)
            return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i]))
                map.put(a[i], new ArrayList<>());
            map.get(a[i]).add(i);
        }
        int max = 0;
        for (int i = 0; i < b.length; i++) {
            if (map.containsKey(b[i])) {
                List<Integer> list = map.get(b[i]);
                for (Integer e : list) {
                    max = Math.max(max, count(e, a, i, b, max));
                }
            }
        }
        return max;
    }

    public int count(int i, int[] a, int e, int[] b, int max) {
        int count = 0;
        if (i + max >= a.length || e + max >= b.length || a[i + max] != b[e + max])
            return count;
        while (i < a.length && e < b.length) {
            if (a[i] != b[e])
                break;
            count++;
            i++;
            e++;
        }
        return count;
    }
}
