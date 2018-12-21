package problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Why Did you create this class? what does it do?
 */
public class PositionsofLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        if (s == null || s.length() < 3)
            return list;

        int i = 0;
        int j = 0;
        while (j <= s.length()) {
            if (j == s.length() || s.charAt(i) != s.charAt(j)) {
                if (j - i > 2) {
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j - 1);
                    list.add(l);
                }
                i = j;
            }
            j++;
        }
        return list;
    }

}
