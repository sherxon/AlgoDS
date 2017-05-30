package problems.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sherxon on 1/24/17.
 */
public class SubsetsII {
    public static void main(String[] args) {
        new SubsetsII().subsetsWithDup(new int[]{4, 4, 4, 1, 4});
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) return list;
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        boolean[] b = new boolean[nums.length];
        find(nums, b, -1, list, set);
        System.out.println(list);
        return list;
    }

    void find(int[] a, boolean[] b, int n, List<List<Integer>> list, Set<String> set) {
        if (n == a.length - 1) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < b.length; i++)
                if (b[i]) l.add(a[i]);

            StringBuilder sb = new StringBuilder(l.stream().map(String::valueOf).collect(Collectors.joining(",")));
            if (set.add(sb.toString())) {
                System.out.println(sb);
                list.add(l);
                set.add(sb.reverse().toString());
            }
        } else {

            b[n + 1] = true;
            find(a, b, n + 1, list, set);

            b[n + 1] = false;
            find(a, b, n + 1, list, set);
        }
    }
}
