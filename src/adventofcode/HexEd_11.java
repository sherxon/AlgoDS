package adventofcode;

import java.util.*;

/**
 * http://adventofcode.com/2017/day/11
 */
public class HexEd_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("1"))
                break;
            builder.append(s);
        }
        System.out.println(solve1(builder));
    }

    private static int solve1(StringBuilder builder) {
        if (builder == null || builder.length() <= 1)
            return 0;
        String[] a = builder.toString().split(",");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            String current = a[i];
            String opp = "";
            switch (current) {
                case "n":
                    opp = "s";
                    break;
                case "s":
                    opp = "n";
                    break;
                case "ne":
                    opp = "sw";
                    break;
                case "se":
                    opp = "nw";
                    break;
                case "sw":
                    opp = "ne";
                    break;
                case "nw":
                    opp = "se";
                    break;
            }
            if (!map.containsKey(current))
                map.put(current, 0);
            if (!map.containsKey(opp))
                map.put(opp, 0);

            if (map.get(opp) == 0) {
                map.put(current, map.get(current) + 1);
            } else {
                map.put(opp, map.get(opp) - 1);
            }
        }
        System.out.println(map);
        return 0;
    }

    private static int solve(StringBuilder builder) {
        if (builder == null || builder.length() <= 1)
            return 0;
        String[] a = builder.toString().split(",");
        int dest = 10_000;
        for (int i = 0; i < a.length; i++) {
            String current = a[i];
            if (current.length() == 1) {
                dest += (current.equals("n") ? -10 : 10);
            } else {
                if (dest % 2 != 0) {
                    if (current.equals("ne"))
                        dest -= 9;
                    else if (current.equals("se"))
                        dest += 1;
                    else if (current.equals("nw"))
                        dest -= 11;
                    else
                        dest -= 1;
                } else {
                    if (current.equals("ne"))
                        dest += 1;
                    else if (current.equals("se"))
                        dest += 11;
                    else if (current.equals("nw"))
                        dest -= 1;
                    else
                        dest += 9;
                }
            }
            System.out.println(dest);
        }
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        counts.put(0, 0);
        parent.put(0, 0);
        while (!queue.isEmpty()) {
            Integer current = queue.remove();
            if (current == dest - 10_000) {
                int key = 8;
                while (key != 0) {
                    System.out.print(key + " =>  ");
                    key = parent.get(key);
                }
                System.out.println();
                return counts.get(current);
            }
            generateNeighbors(map, current);

            for (Integer nei : map.get(current)) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    queue.add(nei);
                    counts.put(nei, counts.get(current) + 1);
                    parent.put(nei, current);
                }
            }
        }

        return counts.get(dest);
    }

    private static void generateNeighbors(Map<Integer, Set<Integer>> map, Integer current) {
        Set<Integer> set = new HashSet<>();
        set.add(current + 10);
        set.add(current - 10);
        if (current % 2 != 0) {
            set.add(current - 9);
            set.add(current + 1);
            set.add(current - 1);
            set.add(current - 11);
        } else {
            set.add(current + 1);
            set.add(current + 11);
            set.add(current - 1);
            set.add(current + 9);
        }
        map.put(current, set);
    }
}
