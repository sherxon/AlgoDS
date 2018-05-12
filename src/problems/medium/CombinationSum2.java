package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Why Did you create this class? what does it do?
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] a, int target) {
        Arrays.sort(a);
        List<List<Integer>> list = new ArrayList<>();
        go(a, target, list, new ArrayList<>(), 0);
        return list;
    }

    void go(int[] a, int target, List<List<Integer>> list, List<Integer> l, int k) {
        if (k > a.length)
            return;
        if (target < 0)
            return;
        if (target == 0) {
            if (list.stream().filter(e -> e.equals(l)).count() == 0)
                list.add(l);
            return;
        }
        for (int i = k; i < a.length; i++) {
            List<Integer> ll = new ArrayList<>(l);
            ll.add(a[i]);
            go(a, target - a[i], list, ll, i + 1);
        }
    }

}
