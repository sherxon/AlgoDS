package contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sherxon on 2/27/17.
 */
public class Solution2 {
    boolean found = false;

    public static void main(String[] args) {
        System.out.println(new Solution2().subsetSum(new int[]{1, 2, 3, 4, 5, 6, 10}, 7, 20));
    }

    public List<Integer> subsetsum(int[] a, int k) {
        List<Integer> list = new ArrayList<>();
        boolean[] b = new boolean[a.length];
        generate(a, b, list, a.length, k);
        Arrays.sort(a, 0, 10);
        return list;
    }

    void generate(int[] a, boolean[] b, List<Integer> list, int n, int k) {
        if (n == 0) {
            if (!found) {
                for (int i = 0; i < a.length; i++)
                    if (b[i]) k -= a[i];
                if (k == 0) {
                    for (int i = 0; i < a.length; i++)
                        if (b[i]) list.add(a[i]);
                    found = true;
                }
            }
        } else {
            b[n - 1] = true;
            generate(a, b, list, n - 1, k);
            b[n - 1] = false;
            generate(a, b, list, n - 1, k);
        }
    }


    boolean subsetSum(int[] a, int n, int k) {
        if (k == 0) return true;
        if (n == 0) return false;
        if (a[n - 1] > k) return subsetSum(a, n - 1, k);
        return subsetSum(a, n - 1, k) || subsetSum(a, n - 1, k - a[n - 1]);
    }

}
