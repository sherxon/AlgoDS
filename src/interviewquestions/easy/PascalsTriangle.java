package interviewquestions.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 2/17/17.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> l = new ArrayList<>(i);
            if (i == 0) {
                l.add(1);
                list.add(l);
                continue;
            }
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    l.add(1);
                } else {
                    l.add(list.get(i - 1).get(j) + list.get(i - 1).get(j - 1));
                }
            }
            list.add(l);
        }
        return list;
    }
}
