package problems.hard;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
@SuppressWarnings("Duplicates") public class CutOffTreesForGolfEvent {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(54581641, 64080174, 24346381, 69107959));
        list.add(Arrays.asList(86374198, 61363882, 68783324, 79706116));
        list.add(Arrays.asList(668150, 92178815, 89819108, 94701471));
        list.add(Arrays.asList(83920491, 22724204, 46281641, 47531096));
        list.add(Arrays.asList(83920491, 22724204, 46281641, 47531096));
        list.add(Arrays.asList(89078499, 18904913, 25462145, 60813308));
        System.out.println(new CutOffTreesForGolfEvent().cutOffTree(list));
    }

    public int cutOffTree(List<List<Integer>> forest) {
        int count = 0;
        if (forest == null || forest.size() == 0)
            return 0;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                int v = forest.get(i).get(j);
                if (v == 0)
                    continue;
                if (v > 1)
                    q.add(new int[] { i, j, v });
            }
        }
        int[] current = new int[] { 0, 0, forest.get(0).get(0) };
        while (!q.isEmpty()) {
            int[] p = q.remove();
            int cc = find(current, p, forest);
            if (cc == -1)
                return -1;
            current = p;
            count += cc;
        }
        return count;
    }

    static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    int find(int[] current, int[] target, List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        boolean[][] visited = new boolean[m][n];

        visited[current[0]][current[1]] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(current);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] c = q.remove();
                if (c[0] == target[0] && c[1] == target[1])
                    return count;

                for (int[] d : dir) {
                    int f = c[0] + d[0];
                    int s = c[1] + d[1];
                    if (f < 0 || s < 0 || f >= m || s >= n || forest.get(f).get(s) == 0 || visited[f][s])
                        continue;
                    q.add(new int[] { f, s });
                    visited[f][s] = true;
                }
            }
            count++;
        }
        return -1;
    }

}
