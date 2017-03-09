package interviewquestions.hard;

import java.util.*;

/**
 * Created by sherxon on 2/12/17.
 */

/**
 * to all shortest paths, i first used bfs to find distance from source to target and, from target to source i did dfs
 */
public class WordLadder2 {

    public List<List<String>> findLadders(String a, String b, List<String> list) {
        Map<String, Set<String>> map = new HashMap<>();
        map.put(a, new HashSet<>());
        Queue<String> q = new LinkedList<>();
        for (String s : list) {
            addVertexAndEdge(s, map);
        }

        q.add(a);
        Map<String, Integer> d = new HashMap<>(); // distance
        d.put(a, 1);
        List<List<String>> lists = new ArrayList<>();
        boolean isFound = false;

        while (!q.isEmpty()) {
            String x = q.remove();
            for (String s : map.get(x)) {
                if (!d.containsKey(s)) {
                    d.put(s, d.get(x) + 1);
                    if (s.equals(b)) {
                        isFound = true;
                    } else {
                        q.add(s);
                    }
                }
            }
            if (isFound) {
                LinkedList<String> path = new LinkedList<>();
                dfs(b, a, map, d, lists, path);
                return lists;
            }
        }

        return lists;
    }

    private void dfs(String source, String target,
                     Map<String, Set<String>> map,
                     Map<String, Integer> d,
                     List<List<String>> lists,
                     LinkedList<String> path) {
        if (target.equals(source)) {
            path.addFirst(target);
            lists.add(new ArrayList<>(path));
            path.removeFirst();
            return;
        }
        path.addFirst(source);
        for (String s : map.get(source)) {
            if (d.getOrDefault(s, -10) + 1 == d.get(source)) {
                dfs(s, target, map, d, lists, path);
            }
        }
        path.removeFirst();
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
