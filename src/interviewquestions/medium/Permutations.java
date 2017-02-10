package interviewquestions.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 1/12/17.
 */
public class Permutations {
    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1, 2, 3, 4}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        rec(list, nums, 0);
        return list;
    }

    void rec(List<List<Integer>> list, int[] a, int n) {
        for (int i = n; i < a.length; i++) {
            swap(a, i, n);
            rec(list, a, n + 1);
            swap(a, n, i);
        }
        if (n == a.length - 1) {
            List<Integer> ll = new ArrayList<>();
            for (int i = 0; i < a.length; i++)
                ll.add(a[i]);
            list.add(ll);
        }
    }

    private void swap(int[] a, int n, int i) {
        int temp = a[n];
        a[n] = a[i];
        a[i] = temp;
    }
}
