package problems.medium;

import problems.utils.TreeNode;

import java.util.Collections;
import java.util.List;

/**
 * Created by sherxon on 2/26/17.
 */
public class LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d);
        if (s == null || s.length() == 0)
            return s;
        String r = "";
        for (String w : d) {
            if (w.length() > r.length() && canBeMade(s, w)) {
                r = w;
            }
        }
        return r;
    }

    boolean canBeMade(String s, String w) {
        int ind = -1;
        for (int i = 0; i < w.length(); i++) {
            ind = s.indexOf(w.charAt(i), ind + 1);
            if (ind < 0)
                return false;
        }
        return true;
    }
}
