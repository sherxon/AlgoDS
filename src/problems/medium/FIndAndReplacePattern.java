package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Why Did you create this class? what does it do?
 */
public class FIndAndReplacePattern {

    public static void main(String[] args) {
        System.out.println(findAndReplacePattern(new String[] {
                "abc", "deq", "mee", "aqq", "dkd", "ccc"
        }, "abb"));
    }

    static public List<String> findAndReplacePattern(String[] words, String pattern) {
        if (words == null || words.length == 0)
            return new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (String s : words) {
            Map<Character, Character> strValues = new HashMap<>();
            Map<Character, Character> patterns = new HashMap<>();
            boolean yes = true;
            for (int i = 0; i < s.length(); i++) {
                char patternVal = strValues.getOrDefault(s.charAt(i), pattern.charAt(i));//a
                char strVal = patterns.getOrDefault(patternVal, s.charAt(i));//d
                if (strVal != s.charAt(i) || patternVal != pattern.charAt(i)) {
                    yes = false;
                    break;
                }
                strValues.put(s.charAt(i), patternVal);//d=>a, k->b
                patterns.put(pattern.charAt(i), strVal); //a=>d, b->k
            }
            if (yes)
                list.add(s);
        }
        return list;
    }
}
