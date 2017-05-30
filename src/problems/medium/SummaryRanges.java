package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 1/24/17.
 */
public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0}));
    }

    static List<String> summaryRanges(int[] a) {
        List<String> list = new ArrayList<>();
        if (a.length == 0) return list;
        String s = String.valueOf(a[0]);
        list.add(s);
        for (int i = 1; i < a.length; i++) {
            if (a[i] - 1 != a[i - 1]) {
                s = list.get(list.size() - 1);
                if (!s.equals(String.valueOf(a[i - 1])))
                    list.set(list.size() - 1, s + "->" + a[i - 1]);
                list.add(String.valueOf(a[i]));
            } else if (a.length - 1 == i) {
                s = list.get(list.size() - 1);
                list.set(list.size() - 1, s + "->" + a[i]);
            }
        }

        return list;
    }
}
