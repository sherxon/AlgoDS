package interviewquestions.medium;

import java.util.*;

/**
 * Created by sherxon on 2/12/17.
 */
public class WordLadder {
    public int ladderLength(String a, String b, List<String> list) {
        Map<String, Set<String>> map = new HashMap<>();
        map.put(a, new HashSet<>());
        Queue<String> q = new LinkedList<>();
        for (String s : list) {
            addVertexAndEdge(s, map);
        }
        Set<String> visited = new HashSet<>(list.size());
        visited.add(a);
        q.add(a);
        Map<String, Integer> d = new HashMap<>(); // distance
        d.put(a, 1);
        while (!q.isEmpty()) {
            String x = q.remove();
            for (String s : map.get(x)) {
                if (!visited.contains(s)) {
                    visited.add(s);
                    d.put(s, d.get(x) + 1);
                    q.add(s);
                    if (s.equals(b))
                        return d.get(s);
                }
            }
        }
        return 0;
    }

    private void addVertexAndEdge(String s, Map<String, Set<String>> map) {
        map.put(s, new HashSet<>());
        for (String key : map.keySet()) {
            if (canBeConnected(key, s)) {
                map.get(key).add(s);
                map.get(s).add(key);
            }
        }

    }

    private boolean canBeConnected(String key, String s) {
        int diff = 0;
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) != s.charAt(i)) diff++;
            if (diff > 1) return false;
        }

        return diff == 1;
    }
}
