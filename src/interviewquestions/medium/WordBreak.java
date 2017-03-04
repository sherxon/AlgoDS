package interviewquestions.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sherxon on 3/3/17.
 */
public class WordBreak {

    /**
     * We make helper array length of given word+1 and with all fields false.
     * The array element is true if such a word exists in dictionary.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] a = new boolean[s.length() + 1];
        a[0] = true;
        for (int i = 0; i < a.length; i++) {
            if (a[i]) {
                for (int j = i + 1; j < a.length; j++) {
                    if (set.contains(s.substring(i, j)))
                        a[j] = true;
                }
            }
            if (a[a.length - 1]) return true;
        }
        return a[a.length - 1];
    }
}
