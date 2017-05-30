package problems.hard;

import problems.utils.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 4/4/17.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<>();
        if (intervals.size() == 0) {
            list.add(newInterval);
            return list;
        }

        if (newInterval.start <= intervals.get(0).start) {
            list.add(newInterval);
            list.addAll(intervals);
        } else if (newInterval.start >= intervals.get(intervals.size() - 1).start) {
            list.addAll(intervals);
            list.add(newInterval);
        } else {
            list.add(intervals.get(0));
            for (int i = 1; i < intervals.size(); i++) {
                Interval cur = intervals.get(i);
                if (cur.start >= newInterval.start)
                    list.add(newInterval);
                list.add(cur);
            }
            if (list.size() == 1) {
                if (newInterval.start > list.get(0).start)
                    list.add(newInterval);
                else
                    list.add(0, newInterval);
            }
        }

        intervals = new ArrayList<>(list);
        list = new ArrayList<>(intervals.size());
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
