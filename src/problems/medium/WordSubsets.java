package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Why Did you create this class? what does it do?
 */
public class WordSubsets {
    public List<String> wordSubsets(String[] s, String[] b) {
        if (s.length == 0 || b.length == 0)
            return new ArrayList<>();
        int[] a = new int[26];
        int[] inner = new int[26];
        for (int i = 0; i < b.length; i++) {
            Arrays.fill(inner, 0);
            for (int j = 0; j < b[i].length(); j++) {
                inner[b[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < inner.length; j++) {
                a[j] = Math.max(a[j], inner[j]);
            }
        }
        List<String> r = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            Arrays.fill(inner, 0);
            for (int j = 0; j < s[i].length(); j++) {
                inner[s[i].charAt(j) - 'a']++;
            }
            boolean f = true;
            for (int j = 0; j < inner.length; j++) {
                if (inner[j] < a[j]) {
                    f = false;
                    break;
                }
            }
            if (f) {
                r.add(s[i]);
            }
        }
        return r;
    }
}
