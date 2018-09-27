package problems.medium;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Why Did you create this class? what does it do?
 */
public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, Boolean> bools = new HashMap<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < dislikes.length; i++) {
            int ii = dislikes[i][0];
            int jj = dislikes[i][1];
            Set<Integer> set = map.getOrDefault(ii, new HashSet<>());
            set.add(jj);
            map.put(ii, set);
            set = map.getOrDefault(jj, new HashSet<>());
            set.add(ii);
            map.put(jj, set);
        }
        bools.put(1, true);
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(1);
        while (!q.isEmpty()) {
            Integer current = q.remove();
            visited.add(current);
            if (map.get(current) != null) {
                for (Integer nei : map.get(current)) {
                    if (!visited.contains(nei)) {
                        if (bools.get(nei) == bools.get(current)) {
                            return false;
                        }
                        q.add(nei);
                        bools.put(nei, !bools.get(current));
                    }
                }
            }
        }
        return true;

    }
}