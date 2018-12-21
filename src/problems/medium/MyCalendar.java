package problems.medium;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class MyCalendar {
    TreeMap<Integer, int[]> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (map.isEmpty()) {
            map.put(start, new int[] { start, end });
            return true;
        } else if (map.size() == 1) {
            int[] current = map.values().iterator().next();
            if (end <= current[0] || start >= current[1]) {
                map.put(start, new int[] { start, end });
                return true;
            } else {
                return false;
            }
        }

        int[] prev = null;
        for (Integer key : map.keySet()) {
            if (prev == null) {
                prev = map.get(key);
                if (end <= key) {
                    break;
                }
            } else {
                int[] current = map.get(key);
                if (start >= current[1])
                    continue;
                if (end < prev[1] || end > current[0])
                    return false;
                if (start >= current[0] || start < prev[1])
                    return false;
                break;
            }
        }
        map.put(start, new int[] { start, end });
        return true;
    }
}
