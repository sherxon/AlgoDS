package problems.medium;

import java.util.TreeMap;

/**
 * Why Did you create this class? what does it do?
 */
public class HandofStraights {
    public boolean isNStraightHand(int[] a, int w) {
        if (a == null || w < 0)
            return false;
        if (a.length % w != 0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        while (!map.isEmpty()) {
            int min = map.firstKey();
            for (int i = min; i < w + min; i++) {
                Integer val = map.get(i);
                if (val == null)
                    return false;
                if (val == 1)
                    map.remove(i);
                else
                    map.put(i, val - 1);
            }
        }
        return true;
    }
}
