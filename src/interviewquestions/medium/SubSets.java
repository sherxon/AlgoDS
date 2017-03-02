package interviewquestions.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 1/11/17.
 */
public class SubSets {

    /**
     * This generates all subsets of given set.
     */
    public List<List<Integer>> subsets(int[] a) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] b = new boolean[a.length];
        generate(a, b, list, a.length);
        return list;
    }

    void generate(int[] a, boolean[] b, List<List<Integer>> list, int n) {
        if (n == 0) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < a.length; i++)
                if (b[i]) l.add(a[i]);
            list.add(l);
        } else {
            b[n - 1] = true;
            generate(a, b, list, n - 1);

            b[n - 1] = false;
            generate(a, b, list, n - 1);
        }
    }

    /**
     * This is DP solution to find subset Sum
     */
    boolean subsetSum(int[] a, int n, int k) {
        if (k == 0) return true;
        if (n == 0) return false;
        if (a[n - 1] > k) return subsetSum(a, n - 1, k);
        return subsetSum(a, n - 1, k) || subsetSum(a, n - 1, k - a[n - 1]);
    }
}
