package problems.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Why Did you create this class? what does it do?
 */
public class AdvantageShuffle {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AdvantageShuffle().advantageCount(
                new int[] { 2, 7, 11, 15 },
                new int[] { 1, 10, 4, 11 }
        )));
        System.out.println(Arrays.toString(new AdvantageShuffle().advantageCount(
                new int[] { 12, 24, 8, 32 },
                new int[] { 13, 25, 32, 11 }
        )));
    }

    public int[] advantageCount(int[] a, int[] b) {
        if (a == null || a.length != b.length)
            return a;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        for (int i = 0; i < b.length; i++) {
            Integer val = map.higherKey(b[i]);
            if (val == null) {
                val = map.firstKey();
            }
            map.put(val, map.get(val) - 1);
            r[i] = val;
            if (map.get(val) == 0) {
                map.remove(val);
            }
        }
        return r;
    }
}
