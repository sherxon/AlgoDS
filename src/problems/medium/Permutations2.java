package problems.medium;

import java.util.*;

/**
 * Created by sherxon on 4/29/17.
 */
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<String> set= new HashSet<>();
        rec(list, nums, 0, set);
        return list;
    }
    void rec(List<List<Integer>> list, int[] a, int n, Set<String> set) {
        if (n == a.length - 1) {
            if(set.add(Arrays.toString(a))){
                List<Integer> ll = new ArrayList<>();
                for (int i = 0; i < a.length; i++)
                    ll.add(a[i]);
                list.add(ll);
            }

            return;
        }

        for (int i = n; i < a.length; i++) {
            if(i!=n && a[i]==a[n])continue;
            swap(a, i, n);
            rec(list, a, n + 1, set);
            swap(a, n, i);
        }

    }

    private void swap(int[] a, int n, int i) {
        int temp = a[n];
        a[n] = a[i];
        a[i] = temp;
    }
}
