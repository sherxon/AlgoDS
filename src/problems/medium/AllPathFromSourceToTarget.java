package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Why Did you create this class? what does it do?
 */
public class AllPathFromSourceToTarget {
    public static void main(String[] args) {
        System.out.println(new AllPathFromSourceToTarget().allPathsSourceTarget(new int[][] {
                { 1, 2 },
                { 3 },
                { 3 },
                {},
                }));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] a) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        ll.add(0);
        go(a, 0, list, ll);
        return list;
    }

    void go(int[][] a, int i, List<List<Integer>> list, List<Integer> ll) {
        if (i == a.length - 1) {
            list.add(ll);
            return;
        }
        for (int j = 0; j < a[i].length; j++) {
            List<Integer> l = new ArrayList<>(ll);
            l.add(a[i][j]);
            go(a, a[i][j], list, l);
        }

    }
}
