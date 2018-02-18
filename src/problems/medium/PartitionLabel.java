package problems.medium;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class PartitionLabel {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    static public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            TreeSet<Integer> set = map.getOrDefault(s.charAt(i), new TreeSet<>());
            set.add(i);
            map.put(s.charAt(i), set);
        }
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int end = map.get(c).last();
            for (int j = i + 1; j < end; j++) {
                end = Math.max(end, map.get(s.charAt(j)).last());
            }
            res.add(end - i + 1);
            i = end + 1;
        }
        return res;

    }
}
