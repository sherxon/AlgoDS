package interviewquestions.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 2/3/17.
 */
public class PalindromePairs {
    public static void main(String[] args) {
        System.out.println(palindromePairs(new String[]{"bat", "tab", "cat"}));
    }

    static List<List<Integer>> palindromePairs(String[] a) {
        List<List<Integer>> list = new ArrayList<>();
        if (a.length == 0) return list;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i != j && isP(a[i], a[j])) {
                    List<Integer> l = new ArrayList<>(2);
                    l.add(i);
                    l.add(j);
                    list.add(l);
                }
            }
        }
        return list;
    }

    static boolean isP(String p, String q) {
        StringBuilder sb = new StringBuilder();
        sb.append(p).append(q);

        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
