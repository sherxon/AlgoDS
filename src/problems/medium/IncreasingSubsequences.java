package problems.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sherxon on 1/21/17.
 */
public class IncreasingSubsequences {
    static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] a = new boolean[nums.length];
        Set<String> set = new HashSet<>();
        perm(nums, a, a.length, list, set);
        return list;
    }

    private static void perm(int[] nums, boolean[] a, int i, List<List<Integer>> list, Set<String> set) {
        if (i == 0) {
            List<Integer> l = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < a.length; j++)
                if (a[j]) {
                    l.add(nums[j]);
                    sb.append(nums[j]).append(",");
                }
            if (check(l) && set.add(sb.toString()))
                list.add(l);
        } else {
            a[i - 1] = true;
            perm(nums, a, i - 1, list, set);
            a[i - 1] = false;
            perm(nums, a, i - 1, list, set);
        }


    }

    private static boolean check(List<Integer> l) {
        if (l.size() < 2) return false;
        for (int i = 1; i < l.size(); i++) {
            if (l.get(i) < l.get(i - 1)) return false;
        }
        return true;
    }
}

