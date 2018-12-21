package problems.medium;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class NetworkDelay {
    public static void main(String[] args) {
        System.out.println(new NetworkDelay().networkDelayTime(
                new int[][] {
                        { 1, 2, 1 },
                        { 2, 3, 7 },
                        { 1, 3, 4 },
                        { 2, 1, 2 },
                        },
                3, 2
        ));
        System.out.println(new NetworkDelay().networkDelayTime(
                new int[][] {
                        { 1, 2, 1 },
                        { 2, 1, 3 },
                        },
                2, 2
        ));
        System.out.println(new NetworkDelay().networkDelayTime(
                new int[][] {
                        { 2, 1, 1 },
                        { 2, 3, 1 },
                        { 3, 4, 1 },
                        },
                4, 2
        ));
        System.out.println(new NetworkDelay().networkDelayTime(
                new int[][] {
                        { 1, 2, 1 },
                        { 2, 3, 2 },
                        { 1, 3, 2 },
                        },
                3, 1
        ));
        System.out.println(new NetworkDelay().networkDelayTime(
                new int[][] {
                        { 1, 2, 1 },
                        { 2, 3, 7 },
                        { 1, 3, 4 },
                        { 2, 1, 2 },
                        },
                3, 1
        ));

    }

    public int networkDelayTime(int[][] times, int n, int k) {
        if (times == null || times.length == 0)
            return 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int[] current = times[i];
            Map<Integer, Integer> set = map.getOrDefault(current[0], new HashMap<>());
            set.put(current[1], current[2]);
            map.put(current[0], set);
        }
        if (!bfs(map, n, k))
            return -1;

        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[k] = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (Integer node : map.keySet()) {
                Map<Integer, Integer> current = map.get(node);
                if (d[node] == Integer.MAX_VALUE)
                    continue;
                for (Integer nei : current.keySet()) {
                    int dis = d[node] + current.get(nei);
                    d[nei] = Math.min(d[nei], dis);
                }
            }
        }
        for (int i = 0; i < d.length; i++) {
            max = Math.max(max, d[i] == Integer.MAX_VALUE ? 0 : d[i]);
        }
        return max;
    }

    private boolean bfs(Map<Integer, Map<Integer, Integer>> map, int n, int k) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        visited.add(k);
        while (!q.isEmpty()) {
            Integer current = q.remove();
            if (!map.containsKey(current))
                continue;
            for (Integer nei : map.get(current).keySet()) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    q.add(nei);
                }
            }
        }

        return visited.size() == n;
    }
}
