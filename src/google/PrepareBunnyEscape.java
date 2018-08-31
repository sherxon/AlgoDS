package google;

import java.util.*;

/**
 * Created by sherxon on 6/24/17.
 */
public class PrepareBunnyEscape {

    public static void main(String[] args) {
        System.out.println(answer(new int[][] {
                { 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0 },
                }));
        System.out.println(answer(new int[][] {
                { 0, 1, 1, 0 },
                { 0, 0, 0, 1 },
                { 1, 1, 0, 0 },
                { 1, 1, 1, 0 },
                }));
        System.out.println(answer(new int[][] {
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 },
                }));
        System.out.println(answer(new int[][] {
                { 0, 1 },
                { 0, 0 },
                { 1, 1 },
                { 1, 0 },
                }));
    }

    public static int answer(int[][] a) {

        int n = a.length;
        int m = a[0].length;

        Map<Integer, Set<Integer>> map = new HashMap<>(m * n);
        Queue<Integer> walls = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    map.put(i * m + j, getNei(a, i, j));
                } else {
                    walls.add(i * m + j);
                }
            }
        }
        Map<Integer, Integer> fromSource = new HashMap<>();
        Map<Integer, Integer> fromDest = new HashMap<>();
        bfs(map, 0, fromSource);
        bfs(map, n * m - 1, fromDest);

        int min = Integer.MAX_VALUE;
        if (fromSource.get(n * m - 1) != null) {
            min = fromSource.get(n * m - 1);
        }

        while (!walls.isEmpty()) {
            Integer cw = walls.remove();
            int ii = cw / m;
            int jj = cw - ii * m;
            Set<Integer> neis = getNei(a, ii, jj);
            int minFromSource = Integer.MAX_VALUE;
            int minFromDest = Integer.MAX_VALUE;
            for (Integer nei : neis) {
                if (fromSource.get(nei) != null) {
                    minFromSource = Math.min(minFromSource, fromSource.get(nei));
                }
                if (fromDest.get(nei) != null) {
                    minFromDest = Math.min(minFromDest, fromDest.get(nei));
                }
            }
            if (minFromDest != Integer.MAX_VALUE && minFromSource != Integer.MAX_VALUE) {
                min = Math.min(min, minFromDest + minFromSource + 1);
            }
        }
        return min;
    }

    private static void bfs(Map<Integer, Set<Integer>> map, int source,
            Map<Integer, Integer> fromSource) {
        if (!map.containsKey(source)) {
            return;
        }
        fromSource.put(source, 1);
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        while (!q.isEmpty()) {
            Integer current = q.remove();
            if (map.containsKey(current)) {
                for (Integer nei : map.get(current)) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        fromSource.put(nei, fromSource.get(current) + 1);
                        q.add(nei);
                    }
                }
            }
        }
    }

    private static Set<Integer> getNei(int[][] a, int i, int j) {
        Set<Integer> set = new HashSet<>();
        int n = a.length;
        int m = a[i].length;
        if (i + 1 < n && a[i + 1][j] == 0) {
            set.add((i + 1) * m + j);
        }
        if (j + 1 < m && a[i][j + 1] == 0) {
            set.add((i) * m + j + 1);
        }
        if (j - 1 >= 0 && a[i][j - 1] == 0) {
            set.add((i) * m + j - 1);
        }
        if (i - 1 >= 0 && a[i - 1][j] == 0) {
            set.add((i - 1) * m + j);
        }

        return set;
    }

    private static void go(int[][] a, int[][] aa, int i, int j, int step, int ii, int jj) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[i].length) {
            return;
        }
   /* if(i==5 && j==5){
      System.out.println(a[i][j]);
    }*/
        if (a[i][j] == 1) {
            return;
        }
        if (i != 0 && j != 0 && aa[i][j] <= step) {
            return;
        }

        aa[i][j] = step;

        a[i][j] = 1;
        go(a, aa, i, j + 1, step + 1, ii, jj);
        go(a, aa, i, j - 1, step + 1, ii, jj);
        go(a, aa, i + 1, j, step + 1, ii, jj);
        go(a, aa, i - 1, j, step + 1, ii, jj);

        a[i][j] = 0;
    }

}
