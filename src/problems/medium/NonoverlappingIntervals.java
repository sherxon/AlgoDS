package problems.medium;

import problems.utils.Interval;

import java.util.Arrays;

/**
 * Created by sherxon on 4/5/17.
 */
public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b) -> {
            int count1 = a.start - b.start;
            if (count1 == 0)
                count1 = a.end - b.end;
            return count1;
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start) {
                intervals[i].end = Math.min(intervals[i - 1].end, intervals[i].end);
                count++;
            }
        }
        return count;
    }
}
