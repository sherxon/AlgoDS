package interviewquestions.medium;

import java.util.List;

/**
 * Created by sherxon on 2/26/17.
 */
public class LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String res = "";

        for (String ss : d) {
            if (ss.length() == 0) continue;
            int x = s.indexOf(ss.charAt(0));
            if (x < 0) continue;
            boolean b = true;
            for (int i = 1; i < ss.length(); i++) {
                int m = s.indexOf(ss.charAt(i), x + 1);
                if (m <= 0) {
                    b = false;
                    break;
                }
                x = m;
            }
            if (b) {
                if (res.length() < ss.length()) {
                    res = ss;
                } else if (res.length() == ss.length() && ss.compareTo(res) < 0) {
                    res = ss;
                }
            }

        }

        return res;
    }
}
