package problems.medium;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class IsGraphBipartite {
    public static void main(String[] args) {
        System.out.println(new IsGraphBipartite().isBipartite(new int[][] {
                { 1, 3, 2 },
                { 0, 2 },
                { 1, 3, 0 },
                { 0, 2 }
        }));
        System.out.println(new IsGraphBipartite().isBipartite(new int[][] {
                { 1 },
                { 0 },
                { 1, 0 },
                }));
        System.out.println(new IsGraphBipartite().isBipartite(new int[][] {
                { 1 },
                { 0 },
                { 4 },
                { 4 },
                { 2, 3 },
                }));
    }

    public boolean isBipartite(int[][] graph) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Boolean> color = new HashMap<>();
        Set<Integer> unvisited = new HashSet<>();

        for (int i = 0; i < graph.length; i++) {
            Set<Integer> nei = new HashSet<>();
            for (int j = 0; j < graph[i].length; j++) {
                nei.add(graph[i][j]);
            }
            map.put(i, nei);
            unvisited.add(i);
        }

        while (!unvisited.isEmpty()) {
            Integer next = unvisited.iterator().next();
            Queue<Integer> q = new LinkedList<>();
            q.add(next);
            color.put(next, true);
            unvisited.remove(next);

            while (!q.isEmpty()) {
                Integer current = q.remove();
                boolean currentColor = color.get(current);
                for (Integer nei : map.get(current)) {
                    if (unvisited.contains(nei)) {
                        unvisited.remove(nei);
                        q.add(nei);
                        color.put(nei, !currentColor);
                    }
                }
            }
        }

        for (Integer current : map.keySet()) {
            boolean currentColor = color.get(current);
            for (Integer nei : map.get(current)) {
                if (currentColor == color.get(nei))
                    return false;
            }

        }
        return true;
    }
}
