package contests.contest36;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sherxon on 6/10/17.
 */
public class AddBoldTaginString {

  public static void main(String[] args) {
    System.out
        .println(new AddBoldTaginString().addBoldTag("aaabbcc", new String[]{"aaa", "aab", "bc"}));
  }

  public String addBoldTag(String s, String[] dict) {
    StringBuilder sb = new StringBuilder();
    List<Interval> list = new ArrayList<>();
    for (int i = 0; i < dict.length; i++) {
      int index = s.indexOf(dict[i]);
      if (index >= 0) {
        list.add(new Interval(index, index + dict[i].length()));
      }
    }
    List<Interval> intervals = merge2(list);
    if (intervals.size() == 0) {
      return s;
    }
    Interval prev = intervals.get(0);
    sb.append(s.substring(0, prev.start));
    sb.append("<b>").append(s.substring(prev.start, prev.end)).append("</b>");
    for (int i = 1; i < intervals.size(); i++) {
      Interval current = intervals.get(i);
      sb.append(s.substring(prev.end, current.start));
      sb.append("<b>").append(s.substring(current.start, current.end)).append("</b>");
    }
    sb.append(s.substring(intervals.get(intervals.size() - 1).end));
    return sb.toString();
  }

  public List<Interval> merge2(List<Interval> intervals) {
    if (intervals.size() <= 1) {
      return intervals;
    }
    Collections.sort(intervals, (a, b) -> {
      int c = a.start - b.start;
      if (c == 0) {
        c = a.end - b.end;
      }
      return c;
    });
    List<Interval> list = new ArrayList<>();
    list.add(intervals.get(0));
    for (int i = 1; i < intervals.size(); i++) {
      Interval prev = list.get(list.size() - 1);
      Interval cur = intervals.get(i);
      if (prev.end >= cur.start && cur.end >= prev.end) {
        prev.end = cur.end;
      } else if (cur.start > prev.end) {
        list.add(cur);
      }
    }
    return list;
  }

  private class Interval {

    public int start;
    public int end;

    public Interval() {
      start = 0;
      end = 0;
    }

    public Interval(int s, int e) {
      start = s;
      end = e;
    }
  }

}
