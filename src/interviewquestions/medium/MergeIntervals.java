package interviewquestions.medium;

import interviewquestions.utils.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 1/28/17.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 4));
        list.add(new Interval(1, 4));

        merge(list);
        System.out.println(list);
    }

    static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) return intervals;
        intervals.sort((a, b) -> a.start - b.start);
        List<Interval> list = new ArrayList<>();
        list.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval prev = list.get(list.size() - 1);
            Interval current = intervals.get(i);
            if (current.start == prev.start) {
                if (current.end > prev.end)
                    prev.end = current.end;
            } else if (current.start <= prev.end) {
                if (current.end > prev.end)
                    prev.end = current.end;
            } else list.add(current);

        }
        return list;
    }
}
