package problems.hard;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class CutOffTreesForGolfEvent {
    public int cutOffTree(List<List<Integer>> forest) {
        int count = 0;
        if (forest == null || forest.size() == 0)
            return 0;
        TreeMap<Integer, Pair> map = new TreeMap<>();

        Map<Pair, Set<Pair>> gr = new HashMap<>();

        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                int v = forest.get(i).get(j);
                if (v == 0)
                    continue;
                if (v > 1)
                    map.put(v, new Pair(i, j));
                setNei(gr, i, j, forest);
            }
        }
        Pair current = new Pair(0, 0);
        for (Integer tree : map.keySet()) {
            Pair p = map.get(tree);
            int cc = find(current, gr, p);
            if (cc == -1)
                return -1;
            forest.get(p.i).set(p.j, 1);
            setNei(gr, p.i, p.j, forest);
            current = p;
            count += cc;
        }
        return count;
    }

    int find(Pair current, Map<Pair, Set<Pair>> map, Pair target) {
        Queue<Pair> q = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();
        visited.add(current);
        Map<Pair, Integer> dist = new HashMap<>();
        dist.put(current, 0);
        while (!q.isEmpty()) {
            Pair c = q.remove();

            if (c.equals(target))
                return dist.get(c);

            if (map.get(c) != null)
                for (Pair nei : map.get(c)) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        dist.put(nei, dist.get(c) + 1);
                    }
                }
        }
        if (dist.get(target) == null)
            return -1;
        return dist.get(target);
    }

    void setNei(Map<Pair, Set<Pair>> map, int i, int j, List<List<Integer>> forest) {
        int n = forest.size();
        int m = forest.get(i).size();
        Pair p;
        Pair c = new Pair(i, j);

        if (i - 1 >= 0 && j - 1 >= 0 && forest.get(i - 1).get(j - 1) == 1) {
            p = new Pair(i - 1, j - 1);
            if (!map.containsKey(c))
                map.put(c, new HashSet<>());
            map.get(c).add(p);

            if (!map.containsKey(p))
                map.put(p, new HashSet<>());
            map.get(p).add(c);
        }
        if (i + 1 < n && j - 1 >= 0 && forest.get(i + 1).get(j - 1) == 1) {
            p = new Pair(i + 1, j - 1);
            if (!map.containsKey(c))
                map.put(c, new HashSet<>());
            map.get(c).add(p);

            if (!map.containsKey(p))
                map.put(p, new HashSet<>());
            map.get(p).add(c);
        }
        if (i - 1 >= 0 && j + 1 < m && forest.get(i - 1).get(j + 1) == 1) {
            p = new Pair(i - 1, j + 1);
            if (!map.containsKey(c))
                map.put(c, new HashSet<>());
            map.get(c).add(p);

            if (!map.containsKey(p))
                map.put(p, new HashSet<>());
            map.get(p).add(c);
        }

        if (i + 1 < n && j + 1 < m && forest.get(i + 1).get(j + 1) == 1) {
            p = new Pair(i + 1, j + 1);
            if (!map.containsKey(c))
                map.put(c, new HashSet<>());
            map.get(c).add(p);

            if (!map.containsKey(p))
                map.put(p, new HashSet<>());
            map.get(p).add(c);
        }

    }

    private class Pair {
        int i, j;

        Pair(int ii, int jj) {
            i = ii;
            j = jj;
        }

        public boolean equals(Object o) {
            if (o == this)
                return true;
            Pair p = (Pair) o;
            return p.i == i && p.j == j;
        }
    }
}
