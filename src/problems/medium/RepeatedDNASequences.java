package problems.medium;

import java.util.*;

/**
 * Created by sherxon on 1/17/17.
 */
public class RepeatedDNASequences {

    public static List<String> findRepeatedDnaSequences(String s) {
        Map<Integer, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        if (s.length() == 0) return list;
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (map.containsKey(sub.hashCode()) && map.get(sub.hashCode()).equals(sub)) {
                set.add(sub);
            }
            map.put(sub.hashCode(), sub);
        }
        list.addAll(set);
        return list;
    }
}
