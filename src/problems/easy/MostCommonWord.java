package problems.easy;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        String[] words = paragraph.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            if (word.endsWith(",") || word.endsWith(";") || word.endsWith(".")
                || word.endsWith("!") || word.endsWith("?") || word.endsWith("'"))
                word = word.substring(0, word.length() - 1);
            if (set.contains(word))
                continue;

            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int max = 0;
        String res = null;
        for (String s : map.keySet()) {
            if (map.get(s) > max) {
                max = map.get(s);
                res = s;
            }
        }
        return res;
    }
}
