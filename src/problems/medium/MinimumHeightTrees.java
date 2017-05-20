package problems.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sherxon on 1/25/17.
 */
public class MinimumHeightTrees {
    public static void main(String[] args) {
        findMinHeightTrees(4,
                new int[][]{{1, 0}, {1, 2}, {1, 3}});
    }

    static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        if (n == 0) return list;
        if (n == 1) {
            list.add(0);
            return list;
        }
        List<Set<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < n; i++)
            sets.add(new HashSet<>());

        for (int[] edge : edges) {
            sets.get(edge[0]).add(edge[1]);
            sets.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < sets.size(); i++)
            if (sets.get(i).size() == 1) leaves.add(i);


        while (n > 2) {
            n -= leaves.size();
            List<Integer> newl = new ArrayList<>();
            for (Integer leaf : leaves) {
                int i = sets.get(leaf).iterator().next();
                sets.get(i).remove(leaf);
                if (sets.get(i).size() == 1) newl.add(i);
            }
            leaves = newl;
        }
        return leaves;
    }

}
