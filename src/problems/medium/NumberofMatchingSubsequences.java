package problems.medium;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Why Did you create this class? what does it do?
 */
public class NumberofMatchingSubsequences {
    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("abcde", new String[] { "a", "bb", "acd", "ace" }));
    }

    static public int numMatchingSubseq(String s, String[] words) {
        if (s == null || s.length() == 0)
            return 0;
        char[] a = s.toCharArray();
        TreeMap<Character, TreeSet<Integer>> map = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], new TreeSet<>());
            }
            map.get(a[i]).add(i);
        }
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            char[] b = words[i].toCharArray();
            int index = -1;
            int j = 0;
            for (; j < b.length; j++) {
                TreeSet<Integer> set = map.get(b[j]);
                if (set == null)
                    break;
                Integer k = set.higher(index);
                if (k == null || k < index)
                    break;
                index = k;
            }
            if (j >= b.length)
                count++;
        }
        return count;
    }
}
