package adventofcode;

import java.util.*;

/**
 * http://adventofcode.com/2017/day/12
 */
@SuppressWarnings("Duplicates") public class DigitalPlumber_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("1"))
                break;
            if (s.length() > 0)
                builder.append(s).append("\n");
        }
        System.out.println(solve2(builder.toString()));
    }

    private static int solve(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        String[] a = s.split("\n");
        for (int i = 0; i < a.length; i++) {
            String[] aa = a[i].split(" ");
            int key = Integer.parseInt(aa[0]);
            if (!map.containsKey(key))
                map.put(key, new HashSet<>());
            for (int j = 2; j < aa.length; j++) {
                String value = aa[j].endsWith(",") ? aa[j].substring(0, aa[j].length() - 1) : aa[j];
                map.get(key).add(Integer.parseInt(value));
            }
        }

        return bfs(map, 0).size();

    }

    private static int solve2(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        String[] a = s.split("\n");
        for (int i = 0; i < a.length; i++) {
            String[] aa = a[i].split(" ");
            int key = Integer.parseInt(aa[0]);
            if (!map.containsKey(key))
                map.put(key, new HashSet<>());
            for (int j = 2; j < aa.length; j++) {
                String value = aa[j].endsWith(",") ? aa[j].substring(0, aa[j].length() - 1) : aa[j];
                map.get(key).add(Integer.parseInt(value));
            }
        }
        int count = 0;
        while (!map.isEmpty()) {
            int next = map.keySet().iterator().next();
            Set<Integer> group = bfs(map, next);
            for (Integer key : group) {
                map.remove(key);
            }
            count++;
        }
        return count;

    }

    private static Set<Integer> bfs(Map<Integer, Set<Integer>> map, int source) {
        Set<Integer> group = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited.add(0);
        while (!queue.isEmpty()) {
            Integer current = queue.remove();
            group.add(current);
            for (Integer nei : map.get(current)) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    queue.add(nei);
                }
            }
        }
        return group;
    }
}
