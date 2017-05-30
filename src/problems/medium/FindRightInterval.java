package problems.medium;

import problems.utils.Interval;

import java.util.TreeMap;

/**
 * Created by sherxon on 1/31/17.
 */
public class FindRightInterval {

    static int[] findRightInterval(Interval[] intervals) {
        if (intervals.length == 0) return new int[0];
        int[] a = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0;
        for (Interval interval : intervals) {
            map.put(interval.start, i++);
        }
        for (int ii = 0; ii < a.length; ii++) {
            Integer key = map.ceilingKey(intervals[ii].end);
            if (key == null) a[i] = -1;
            else a[i] = map.get(key);
        }

        return a;
    }
}
